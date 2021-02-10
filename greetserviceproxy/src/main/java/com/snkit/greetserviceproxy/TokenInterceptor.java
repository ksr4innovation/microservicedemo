package com.snkit.greetserviceproxy;

import feign.RequestInterceptor;
import feign.RequestTemplate;


public class TokenInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		System.out.println("  from DemoInterceptor ");
		
		template.header("token", "Token from itnerceptor .............");
		
	}

}
