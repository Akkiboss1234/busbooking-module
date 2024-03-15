package com.busbookingreservation.service;

import com.busbookingreservation.entity.Route;
import com.busbookingreservation.exception.ResourseNotFound;
import com.busbookingreservation.repository.BusRepository;
import com.busbookingreservation.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;
    public Route createRoute(long busId,Route route){
        busRepository.findById(busId).orElseThrow(
                ()->new ResourseNotFound("bus not added!!")
        );
        Route r = routeRepository.findByBusId(route.getBusId());

        if(r!=null){
            throw new ResourseNotFound("Route was already added");
        }

        if (r==null){
             routeRepository.save(route);
             return route;
        }
        return  null;

    }
}
