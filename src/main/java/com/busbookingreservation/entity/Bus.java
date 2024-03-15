package com.busbookingreservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name="bus_number")
    private String busNumber;
    private String busType;
    private String price;
    private int seats;
    private int availableSeats;

//    @OneToOne(mappedBy = "bus")
//    private Route route;


//    @OneToOne
//    @JoinColumn(name="driver_id")
//    private Driver driver;
}
