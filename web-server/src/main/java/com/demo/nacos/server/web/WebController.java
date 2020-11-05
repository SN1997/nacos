package com.demo.nacos.server.web;

import com.demo.nacos.feign.api.FeignApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:12
 * @description
 */
@RestController
@RefreshScope
public class WebController {

    @Value("${common.name:null}")
    private String config;

    @Resource
    private FeignApiService feignApiService;

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> map = new HashMap();
        map.put("config", config);
        return map;
    }

    @GetMapping("/feign")
    public Map<String, Object> testFeign() {
        return feignApiService.testFeign();
    }

}
