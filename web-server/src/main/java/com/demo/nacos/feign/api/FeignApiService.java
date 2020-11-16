package com.demo.nacos.feign.api;

import com.demo.feign.api.FeignApi;
import com.demo.nacos.fallBack.feignFallBack;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author : qt
 * @Title : FeignApiService
 * @Description : FeignApiService
 * @date : 2020-11-5 16:25
 */
@Component
@FeignClient(name = "feign",fallback = feignFallBack.class)
public interface FeignApiService extends FeignApi {
}
