package com.Components;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    
    
	@Scheduled(fixedRate = 5000)
	public void reportFlights() {
		//String url="http://localhost:8080/flights";
        
       
        
	}
}
