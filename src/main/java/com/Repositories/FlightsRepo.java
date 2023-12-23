package com.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.Models.FlightModel;
 
@EnableMongoRepositories
public interface FlightsRepo extends MongoRepository<FlightModel,String> {
        
}
