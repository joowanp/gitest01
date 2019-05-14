package com.example.Display.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductRemoteServiceImpl implements ProductRemoteService  {
	
	public static final String url = "http://product/products/";
	private final RestTemplate restTemplate;
	
	
	public ProductRemoteServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	@HystrixCommand(commandKey = "productInfo", fallbackMethod = "getProductInfoFallback")
	public String getProductInfo(String productId) {
		return restTemplate.getForObject( url + productId, String.class);
	
	}
	
	public String getProductInfoFallback(String productId, Throwable t) {
		System.out.println("t = " + t);
		return "[This Product is sold out]";
	}
	
}

