package com.busbookingreservation.controller;

import com.busbookingreservation.entity.Bus;
import com.busbookingreservation.entity.Route;
import com.busbookingreservation.entity.SubRoute;
import com.busbookingreservation.payload.BusDto;
import com.busbookingreservation.payload.SearchListOfBusesDto;
import com.busbookingreservation.repository.BusRepository;
import com.busbookingreservation.repository.RouteRepository;
import com.busbookingreservation.repository.SubRouteRepository;
import com.busbookingreservation.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired

    private SubRouteRepository subRouteRepository;
  @Autowired
    private BusRepository busRepository;
    @Autowired
    private BusService busService;
    @Autowired
private RouteRepository routeRepository;
    @PostMapping("/add")
        public ResponseEntity<Bus> addBus(@RequestBody BusDto busDto)  {


        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);

        }
     @GetMapping
    public List<?> getAllBuses(@RequestParam String fromLocation,
                                 @RequestParam String toLocation,
                                 @RequestParam String fromDate) {




         List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
         List<SubRoute>  subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation,  toLocation,  fromDate);  //System.out.println(routes);
         List<SearchListOfBusesDto> buses = new ArrayList<>();
         if(routes!=null) {
             for (Route route : routes) {
                 Bus bus = busRepository.findById(route.getBusId()).get();
                 SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
                 buses.add(searchListOfBusesDto);
             }

         }

         if(subRoutes!=null) {
             for (SubRoute route: subRoutes) {
                 Bus bus = busRepository.findById(route.getBusId()).get();
                 SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
                 buses.add(searchListOfBusesDto);
             }
             return buses;
         }
         return null;
     }


    SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus , Route route) {
        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getId());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setSeats(bus.getSeats());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());

        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setToTime(route.getToTime());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusesDto.setRouteId(route.getId());
        return searchListOfBusesDto;
    }
    SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus , SubRoute route) {
        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getId());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setSeats(bus.getSeats());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());

        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setToTime(route.getToTime());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusesDto.setRouteId(route.getId());
        return searchListOfBusesDto;
    }
}