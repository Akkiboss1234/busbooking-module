package com.busbookingreservation.payload;

import lombok.Data;

@Data
public class SearchListOfBusesDto {
private long busId;
    private String busNumber;
    private String busType;
    private String price;
    private int seats;
    private int availableSeats;

    private long routeId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;

}
