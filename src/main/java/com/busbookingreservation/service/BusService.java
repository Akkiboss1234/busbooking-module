package com.busbookingreservation.service;


import com.busbookingreservation.entity.Bus;
import com.busbookingreservation.entity.Route;
import com.busbookingreservation.entity.SubRoute;
import com.busbookingreservation.payload.BusDto;
import com.busbookingreservation.payload.SubRouteDto;
import com.busbookingreservation.repository.BusRepository;
import com.busbookingreservation.repository.DriverRepository;
import com.busbookingreservation.repository.RouteRepository;
import com.busbookingreservation.repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    public Bus addBus(BusDto busDto) {
//        // Create Route entity
//        Route route = new Route();
//        route.setFromLocation(busDto.getRoute().getFromLocation());
//        route.setToLocation(busDto.getRoute().getToLocation());
//        route.setFromDate(busDto.getRoute().getFromDate());
//        route.setToDate(busDto.getRoute().getToDate());
//        route.setTotalDuration(busDto.getRoute().getTotalDuration());
//        route.setFromTime(busDto.getRoute().getFromTime());
//        route.setToTime(busDto.getRoute().getToTime());
//
//
//        // Save Route entity
//        Route savedRoute = routeRepository.save(route);

        // Create Bus entity
        Bus bus= new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setSeats(busDto.getSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

       // bus.setRoute(route);
        // Save Busb entity
        //       bus.setRoute(route);
      Bus savedbus = busRepository.save(bus);
      return savedbus;
//        Route routeUpdate = routeRepository.findById(savedRoute.getId()).get();
//        routeUpdate.setBus(savedbus);
//        routeRepository.save(routeUpdate);

        // Save SubRoutes if available
//        if (busDto.getSubRoute() != null && !busDto.getSubRoute().isEmpty()) {
//            for (SubRouteDto subRouteDto : busDto.getSubRoute()) {
//                // Create SubRoute entity
//                SubRoute subRoute = new SubRoute();
//                subRoute.setFromLocation(subRouteDto.getFromLocation());
//                subRoute.setToLocation(subRouteDto.getToLocation());
//                subRoute.setFromDate(subRouteDto.getFromDate());
//                subRoute.setToDate(subRouteDto.getToDate());
//                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
//                subRoute.setFromTime(subRouteDto.getFromTime());
//                subRoute.setToTime(subRouteDto.getToTime());
//
//                // Set the Route for the SubRoute
//                subRoute.setRoute(savedRoute);
//
//                // Save SubRoute entity
//                SubRoute savedSubRoute = subRouteRepository.save(subRoute);
//            }\

        }
    }
