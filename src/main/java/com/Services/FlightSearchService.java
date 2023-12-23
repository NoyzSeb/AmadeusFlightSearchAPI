package com.Services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.FlightModel;

@Service
public class FlightSearchService {
    @Autowired
    FlightService flightService;

    public Map<String,List<FlightModel>> searchedFlights(FlightModel searchedFlight) {
        Map<String,List<FlightModel>> availableFlights= new HashMap<>();
        List<FlightModel> departureFlights  = new ArrayList<>();
        List<FlightModel> returnFlights  = new ArrayList<>();
        List<FlightModel> allFlights = flightService.getFlights();
        
        for(FlightModel flight : allFlights){
            if(
                flight.getDepartureAirport().equals(searchedFlight.getDepartureAirport())
                &&flight.getArrivalAirport().equals(searchedFlight.getArrivalAirport())
                &&flight.getDepartureDateTime().substring(0,10).equals(searchedFlight.getDepartureDateTime())
                
            ){
                departureFlights.add(flight);
            }
            else if(
                flight.getDepartureAirport().equals(searchedFlight.getDepartureAirport())
                &&flight.getArrivalAirport().equals(searchedFlight.getArrivalAirport())
                &&flight.getDepartureDateTime().substring(0,10).equals(searchedFlight.getReturnDateTime())
                
            ){
                returnFlights.add(flight);
            }
        }
        
        if(returnFlights.size()!=0){
            availableFlights.put("Return Flights",returnFlights);
            availableFlights.put("Departure Flights",departureFlights);
        }else{
            availableFlights.put("Departure Flights",departureFlights);
        }

       

        return availableFlights;
    }
}
