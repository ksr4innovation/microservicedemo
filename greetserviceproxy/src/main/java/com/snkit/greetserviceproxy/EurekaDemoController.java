package com.snkit.greetserviceproxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaDemoController {

	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping(value="/getHosts/{instanceId}")
	public List<String> getHosts(@PathVariable String instanceId){
		List<String> instances = new ArrayList();
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(instanceId);
		serviceInstances.forEach( si -> {
			String strInstace = si.getHost()+":"+si.getPort();
			instances.add(strInstace);
			
		});
		return instances;
	}
	
	@GetMapping(value="/getApps")
	public List<String> getApps(){
		return discoveryClient.getServices();
	}
	@Autowired 
	GreetFeignClient greetFeignClient;
	
	@GetMapping(value="/getEmployeeGet")
	public ResponseEntity<String> getEmployeeGet(){
		return greetFeignClient.getEmployeeGet();
	}
	
}
