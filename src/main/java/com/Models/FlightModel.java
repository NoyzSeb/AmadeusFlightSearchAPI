package com.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;


@Document("Flights")
public class FlightModel {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    public String id;

    public String departureAirport;
    public String arrivalAirport;
    // This following two string will be produced as LocalDateTime and convertted to string by createFlight service.
    public String departureDateTime;
    public String returnDateTime;
    public float price;

    //Departure Airport
   
    public String getDepartureAirport(){
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport){
        this.departureAirport=departureAirport;
    }

    //Arrival Airport
    
    public String getArrivalAirport(){
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport){
        this.arrivalAirport=arrivalAirport;
    }

    //Departure Date/Time

    public String getDepartureDateTime(){
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime){
        this.departureDateTime=departureDateTime;
    }

    //Return Date/Time

    public String getReturnDateTime(){
        return returnDateTime;
    }

    public void setReturnDateTime(String returnDateTime){
        this.returnDateTime=returnDateTime;
    }

    //Price

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price=price;
    }

    //ID

    public String getID(){
        return this.id;
    }
}
