package com.demo.nacos.feign.api;

import com.demo.feign.api.FeignApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : qt
 * @Title : FeignApiService
 * @Description : FeignApiService
 * @date : 2020-11-5 16:25
 */
@FeignClient(name = "feign")
public interface FeignApiService extends FeignApi {

}
