package com.example;

import com.example.domain.GetLocationRequest;
import com.example.domain.GetLocationResponse;
import com.example.repositories.LocationRepository;
import com.example.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LocationEndpoint {
	private static final String NAMESPACE_URI = "http://localhost:8080";

	private LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

	@Autowired
	public LocationEndpoint(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationRequest")
	@ResponsePayload
	public GetLocationResponse getLocation(@RequestPayload GetLocationRequest request) {
		GetLocationResponse response = new GetLocationResponse();
		response.setLocation(locationService.getByPhone(request.getPhone()));
        return response;
	}
}
