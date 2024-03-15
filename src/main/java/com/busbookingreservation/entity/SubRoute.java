package com.busbookingreservation.entity;

import com.busbookingreservation.payload.SubRouteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubRoute  {
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

//    @ManyToOne
//    @JoinColumn(name = "route_id") // Foreign key column in the SubRoute table
//    private Route route;
@Column(name="route_id", unique=true,nullable=false)
private long routeId;
    @Column(name="bus_id", unique=true,nullable=false)
private long busId;
}
