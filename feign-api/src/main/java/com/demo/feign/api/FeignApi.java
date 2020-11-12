package com.demo.feign.api;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author : qt
 * @Title : FeignApi
 * @Description : FeignApi
 * @date : 2020-11-5 16:15
 */
public interface FeignApi {

	@GetMapping("/feign")
	Map<String, Object> testFeign();

	@GetMapping("/ribbon")
	Map<String, Object> testRibbon();

	@GetMapping("/hystrix")
	Map<String, Object> testHystrix();

}
