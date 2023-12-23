package com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Models.AirportModel;
import com.Services.AirportService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@Tag(name="REST End Points of Airports CRUD operations")
@RestController
@RequestMapping("airports")
public class AirportController {
    @Autowired
    AirportService airportService;
     
    @GetMapping(value="",produces = "application/json")
    public ResponseEntity<List<AirportModel>> getAirports() {
        return ResponseEntity.ok(airportService.getAirports());
    }
    
    @PostMapping(value="createAirport",produces = "application/json")
    public ResponseEntity<AirportModel> createAirport(@RequestBody AirportModel airportModel) {
        return ResponseEntity.ok(airportService.createAirport(airportModel));
    }

    @PutMapping(value="updateAirport/{id}",produces = "application/json")
    public ResponseEntity<AirportModel> updateAirport(@PathVariable String id,@RequestBody AirportModel airportModel) {
        return ResponseEntity.ok(airportService.updateAirportModel(id,airportModel));
    }
    
    @DeleteMapping(value="deleteAirport/{id}",produces = "application/string")
    public ResponseEntity<String> deleteAirport(@PathVariable String id) {
        return ResponseEntity.ok(airportService.deleteById(id));
    }
}
