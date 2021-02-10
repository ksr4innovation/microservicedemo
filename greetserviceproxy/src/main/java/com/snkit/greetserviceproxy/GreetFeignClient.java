package com.snkit.greetserviceproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import feign.hystrix.FallbackFactory;


@FeignClient(name="GREET-SERVICE",
fallback=GreetFeignClientFallBack.class)
public interface GreetFeignClient {
	@GetMapping(value="/greet/getEmployeeGet")
	ResponseEntity<String> getEmployeeGet();
}

@Component
 class GreetFeignClientFallBack implements GreetFeignClient {

	@Override
	public ResponseEntity<String> getEmployeeGet() {
		return new ResponseEntity("  Service is not available",HttpStatus.OK);
	}

}
/*@Component
class GreetFeignClientFallBackFactory implements FallbackFactory<GreetFeignClient>{

	@Override
	public GreetFeignClient create(Throwable cause) {
		
		return new GreetFeignClient() {

			@Override
			public ResponseEntity<String> getEmployeeGet() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
	
}*/
