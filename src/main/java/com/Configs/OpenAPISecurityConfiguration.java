package com.Configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
  info =@Info(
    title = "FlightSearch API",
    version = "betaV1",
    contact = @Contact(
      name = "MBerk", email = "m.berkdincer@hotmail.com", url = ""
    ),
    license = @License(
      name = "Apache 4.0", url = "https://www.apache.org/licenses/LICENSE-4.0"
    ),
    termsOfService = "${tos.uri}",
    description = "Amadeus Travel to Future Case Study"
  ),
  servers = @Server(
    url = "http://localhost:8080",
    description = "In Development"
  )
)
public class OpenAPISecurityConfiguration {
    
}
