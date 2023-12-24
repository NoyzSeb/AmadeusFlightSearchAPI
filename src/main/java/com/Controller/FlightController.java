package com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Models.FlightModel;
import com.Services.FlightService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@Tag(name="REST End Points of Flights CRUD operations.")
@RestController
@RequestMapping("admin")
public class FlightController {
    @Autowired
    FlightService flightService;

    @Operation(summary =" Returns list of saved Flights.")
    @GetMapping(value="flights",produces = "application/json")
    public ResponseEntity<List<FlightModel>> getFlights() {
        return ResponseEntity.ok(flightService.getFlights());
    }

    @Operation(summary =" Creates flight.")
    @PostMapping(value="createFlight",produces = "application/json")
    public ResponseEntity<FlightModel> createFlight(@RequestBody FlightModel flight) {
        
        return ResponseEntity.ok(flightService.createFlight(flight));
    }

    @Operation(summary =" Finds flight with given id and updates it with given new flight details.")
    @PutMapping(value="updateFlight/{id}",produces = "application/json")
    public ResponseEntity<FlightModel> updateFlight(@PathVariable String id,@RequestBody FlightModel flight) {
        
        return ResponseEntity.ok(flightService.updateFlight(id,flight));
    }

    @Operation(summary =" Deletes flight with given id")
    @DeleteMapping(value="deleteFlight/{id}",produces = "application/string")
    public ResponseEntity<String> deleteFlight(@PathVariable String id) {
        
        return ResponseEntity.ok(flightService.deleteFlight(id));
    }

    
    
    
}
