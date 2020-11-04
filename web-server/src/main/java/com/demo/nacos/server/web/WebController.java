package com.demo.nacos.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate restTemplate;

    @Value("${common.name}")
    private String config;

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> map = new HashMap();
        map.put("ceshi", config);
        return map;
    }

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("web-server");
        String path = String.format("http://%s:%s/web-server/%s", serviceInstance.getHost(), serviceInstance.getPort(), message);
//        String result = restTemplate.getForObject(path, String.class);
        return String.format(" %s from %s %s", message, serviceInstance.getHost(), serviceInstance.getPort());
    }

}
