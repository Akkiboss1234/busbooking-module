package com.busbookingreservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    @Column(name="bus_id",unique=true)
    private long busId;

//    @OneToOne
//    @JoinColumn(name = "bus_id") // Foreign key column in the Route table
//    private Bus bus;
//    @OneToMany(mappedBy = "route")
//    private List<SubRoute> subRoutes;
////    @OneToOne
////    @JoinColumn(name = "bus_id") // Foreign key column in the Route table
////    private Bus bus;
//}
}