package com.example.Display.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class FeignProductRemoteServiceFallbackFactory implements FallbackFactory<FeignProductRemoteService>{
	
	@Override
	public FeignProductRemoteService create(Throwable cause) {
		System.out.println("t = " + cause);
		return productId -> "[this product is sold out]";
	}

}
