package com.example.producingwebservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.GetCountryResponse;



@RestController
@RequestMapping("/countries")
public class ClientController {
	
	@Autowired
	CountryClient client;
	
	
	@GetMapping(value = "/{country}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public GetCountryResponse findCountryByString(@PathVariable("country") String country) {
		
		GetCountryResponse response1 = client.getCountry(country);
		return response1;
		
	} 

}
