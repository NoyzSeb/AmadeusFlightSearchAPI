package com.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.Models.AirportModel;

@EnableMongoRepositories
public interface AirportsRepo extends MongoRepository<AirportModel,String>{
    
}
