package com.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.Models.FlightModel;
import com.Services.FlightSearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name="REST End Point of flight search")
@RestController
public class FlightSearch {
    @Autowired
    FlightSearchService flightSearchService;
    
    
    
     @GetMapping("")
    public String goToSwagger() {
        String body =
        "<HTML><body> <a href=\"http://localhost:8080/swagger-ui/index.html#/\">SWAGGER PAGE</a></body></HTML>"
        +"<HTML><body> <a href=\"http://localhost:8080/login#/\">LOGIN PAGE</a></body></HTML>";
        return (body);
    }


    @GetMapping(value="flightSearch",produces = "application/json")
    public ResponseEntity<Map<String,List<FlightModel>>> getAvailableFlights(
    @RequestParam(name = "Departure AirportName",required = true) String departureAirport
    ,@RequestParam(name = "Arrival AirportName",required = true) String arrivalAirport
    ,@RequestParam(name="Arrival Date",required = true) String departureDateTime
    ,@RequestParam(name="Return Date (Optional)",defaultValue = "DD-MM-YYYY")  String returnDateTime 
    )
    {   
        FlightModel searchedFlight=new FlightModel();
        searchedFlight.setDepartureAirport(departureAirport);
        searchedFlight.setArrivalAirport(arrivalAirport);
        searchedFlight.setDepartureDateTime(departureDateTime);
        if(returnDateTime!="DD-MM-YYYY")searchedFlight.setReturnDateTime(returnDateTime);

        return ResponseEntity.ok(flightSearchService.searchedFlights(searchedFlight));
       // return ResponseEntity.ok(searchedFlight);
    }

}
