package com.snkit.greetserviceproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="GREET-SERVICE")
public interface GreetFeignNoFaultTolerantClient {
	
	@GetMapping(value="/greet/getEmployeeGet")
	ResponseEntity<String> getEmployeeGet();
	
	
}


