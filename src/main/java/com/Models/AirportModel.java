package com.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Document("Airport")
public class AirportModel {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    public String id;
    
    public String city;

    //City
    
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }

    //ID

    public String getID(){
        return this.id;
    }

}
