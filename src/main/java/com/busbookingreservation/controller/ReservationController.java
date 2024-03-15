package com.busbookingreservation.controller;

import com.busbookingreservation.entity.Bus;
import com.busbookingreservation.entity.Passenger;
import com.busbookingreservation.entity.Route;
import com.busbookingreservation.entity.SubRoute;
import com.busbookingreservation.payload.ReservationDto;
import com.busbookingreservation.repository.BusRepository;
import com.busbookingreservation.repository.PassengerRepository;
import com.busbookingreservation.repository.RouteRepository;
import com.busbookingreservation.repository.SubRouteRepository;
import com.busbookingreservation.util.EmailService;
import com.busbookingreservation.util.ExcelGenerator;
import com.busbookingreservation.util.PdfTicketGeneratorService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ExcelGenerator excelGenerator;
    @Autowired
    private EmailService emailService;
    @Autowired

    private PdfTicketGeneratorService pdfTicketGeneratorService;
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
   private PassengerRepository passengerRepository;
    //http://localhost:8080/api/reservation?busId=1&routeId=1
@PostMapping
    public ResponseEntity<String> bookTicket(
         @RequestParam long busId,

         @RequestParam long routeId,
       @RequestBody Passenger passenger
         //@RequestParam String seatNumber

         ) throws MessagingException {

        boolean busIsPresent= false;
        boolean routeIsPresent= false;
        boolean subRouteIsPresent= false;
        Optional<Bus> byId = busRepository.findById(busId);

        if(byId.isPresent()){
          busIsPresent=true;
            Bus bus = byId.get();
        }

        Optional<Route> byRouteId = routeRepository.findById(routeId);

        if(byId.isPresent()){
            routeIsPresent=true;
            Route  route = byRouteId.get();
        }
        Optional<SubRoute> bySubRouteId = subRouteRepository.findById(routeId);

        if(bySubRouteId.isPresent()){
            subRouteIsPresent=true;
            SubRoute subRoute = bySubRouteId.get();
        }

        if(busIsPresent&&routeIsPresent||busIsPresent&&subRouteIsPresent){
//add passenger
            Passenger p = new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setRouteId(routeId);
            p.setBusId(busId);

            Passenger savepassenger = passengerRepository.save(p);
            byte[] pdfbytes = pdfTicketGeneratorService.generateTicket(savepassenger, byRouteId.get().getFromLocation(), byRouteId.get().getToLocation(), byRouteId.get().getFromDate());
       emailService.sendEmailWithAttachment(passenger.getEmail(),"Booking confirm","your reservation id"+savepassenger.getId(),pdfbytes,"ticket");

        }
        return  new ResponseEntity<>("done", HttpStatus.CREATED) ;
    }

    @GetMapping("/passengers/excel")
    public ResponseEntity<byte[]> generateExcel(){

    try{
        List<Passenger> passengers=fetchPassengersFromDatabase();
 byte[] excelBytes= excelGenerator.generateExcelFile(passengers);
        HttpHeaders headers = new HttpHeaders();
   headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "passengers_data.xlsx");

        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    private List<Passenger> fetchPassengersFromDatabase() {

    return passengerRepository.findAll();
    }

}


