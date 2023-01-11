package com.example.producingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;


public class CountryClient extends WebServiceGatewaySupport{
	
	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	  public GetCountryResponse getCountry(String country) {

	    GetCountryRequest request = new GetCountryRequest();
	    request.setName(country);

	    log.info("Requesting location for " + country);

	    GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
	        .marshalSendAndReceive("http://localhost:8088/ws?WSDL", request);
	            
	    return response;
	  }

}
