package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.AirportModel;
import com.Repositories.AirportsRepo;

@Service
public class AirportService {
    @Autowired
    AirportsRepo airportsRepo;

    // Create
    public AirportModel createAirport(AirportModel airport){
        return airportsRepo.save(airport);
    }
    
    // Read
    public List<AirportModel> getAirports(){
        return airportsRepo.findAll();
    }

    public AirportModel getAirportByID(String id){
        return airportsRepo.findById(id).orElseThrow(()-> new RuntimeException("Couldnt find the airport with"+id));
    }
    
    // Update    
    public AirportModel updateAirportModel(String id, AirportModel airport){
        try {
            AirportModel oldAirport=getAirportByID(id);
            if(airport.getCity()!=null)oldAirport.setCity(airport.getCity());
            airportsRepo.save(oldAirport);
            return oldAirport;
        } catch (Exception e) {
            System.out.println("Something went wrong. Pleas check your airport details.\n"+e.getMessage());
            return airport;
        }
    }

    // Delete
    public String deleteById(String id){
        airportsRepo.deleteById(id);
        return String.format("Airport successfully deleted.");
    }

}
