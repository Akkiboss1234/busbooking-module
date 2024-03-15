package com.busbookingreservation.payload;


import com.busbookingreservation.entity.Driver;
import com.busbookingreservation.entity.Route;
import com.busbookingreservation.entity.SubRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusDto {


    private String busNumber;
    private String busType;
    private String price;
    private int seats;
    private int availableSeats;
   // private Driver driver;
//    private RouteDto route;
//    private List<SubRouteDto> subRoute;


}

