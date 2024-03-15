package com.busbookingreservation.controller;

import com.busbookingreservation.entity.Route;
import com.busbookingreservation.repository.RouteRepository;
import com.busbookingreservation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/{busId}")
    public ResponseEntity<Route> createRoute(@PathVariable long busId, @RequestBody Route route){
        Route route1 = routeService.createRoute(busId, route);
        return new ResponseEntity<>(route1, HttpStatus.CREATED);
    }
}
