package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Models.FlightModel;
import com.Repositories.FlightsRepo;



@Service
public class FlightService {
    @Autowired
    FlightsRepo flightsRepo;
    
    
    
    // Create
    public FlightModel createFlight(FlightModel flight){
        return flightsRepo.save(flight);
    }
    
    // Read
    public List<FlightModel> getFlights(){
        return flightsRepo.findAll();
    }
    
    public FlightModel getFlightByID(String id){
        return flightsRepo.findById(id).orElseThrow(()-> new RuntimeException("Couldnt find the flight with"+id));
    }

    // Update
    public FlightModel updateFlight(String id,FlightModel flight){
        
        try {
            FlightModel oldFlight = getFlightByID(id);
            if(flight.getDepartureAirport()!=null)oldFlight.setDepartureAirport(flight.getDepartureAirport());
            if(flight.getArrivalAirport()!=null)oldFlight.setArrivalAirport(flight.getArrivalAirport());
            if(flight.getDepartureDateTime()!=null)oldFlight.setDepartureDateTime(flight.getDepartureDateTime());
            if(flight.getReturnDateTime()!=null)oldFlight.setReturnDateTime(flight.getReturnDateTime());
            if(flight.getPrice()>0f)oldFlight.setPrice(flight.getPrice());

            return flightsRepo.save(oldFlight);
        } catch (Exception e) {
            System.out.println("Something went wrong. Pleas check your flight details.\n"+e.getMessage());
            return flight;
        }
    }
    
    // Delete
    public String deleteFlight(String id){

        flightsRepo.deleteById(id);
        return String.format("User Succesfully DELETED");
    }
    
}
