package com.demo.nacos.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:12
 * @description
 */
@RestController
@RefreshScope
public class WebController {

    @Value("${common.name}")
    private String config;

    @GetMapping("/config")
    public String getConfig(){
        return config;
    }
}
