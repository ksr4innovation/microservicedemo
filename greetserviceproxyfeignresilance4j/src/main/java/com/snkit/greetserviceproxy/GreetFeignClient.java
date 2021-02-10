package com.snkit.greetserviceproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@FeignClient(name="GREET-SERVICE")
public interface GreetFeignClient {
	
	@GetMapping(value="/greet/getEmployeeGet")
	@CircuitBreaker(name="getEmployeeGet",fallbackMethod="getEmployeeGetFallBack")
	@RateLimiter(name="getEmployeeGet",fallbackMethod="getEmployeeGetFallBack")
	ResponseEntity<String> getEmployeeGet();
	
	default ResponseEntity<String> getEmployeeGetFallBack(Throwable throwable) {
		
		System.out.println("From FallBack getEmployeeGetFallBack "+throwable.getMessage());
		
		return new ResponseEntity("  Service is not available",HttpStatus.OK);
	}
}

/*@Component
 class GreetFeignClientFallBack implements GreetFeignClient {

	@Override
	public ResponseEntity<String> getEmployeeGet() {
		return new ResponseEntity("  Service is not available",HttpStatus.OK);
	}

}*/
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
