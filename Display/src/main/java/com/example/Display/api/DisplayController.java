package com.example.Display.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Display.service.FeignProductRemoteService;
import com.example.Display.service.ProductRemoteService;

@RestController
@RequestMapping(path="/displays")
public class DisplayController {
	
	
	private final ProductRemoteService productRemoteService;
	private final FeignProductRemoteService feignProductRemoteService;
	
	public DisplayController(ProductRemoteService productRemoteService, FeignProductRemoteService feignProductRemoteService) {
		this.productRemoteService = productRemoteService;
		this.feignProductRemoteService = feignProductRemoteService;
	}
	
	@GetMapping(path="/{displayId}")
	public String getDisplayDetail(@PathVariable String displayId) {
		String productInfo = productRemoteService.getProductInfo("1111");
		return String.format("[display id = %s at %s %s ]", displayId, System.currentTimeMillis(), productInfo);
	}
	
	private String getProductInfo() {
		return feignProductRemoteService.getProductInfo("12345");
//		return productRemoteService.getProductInfo("12345");
	}

}
