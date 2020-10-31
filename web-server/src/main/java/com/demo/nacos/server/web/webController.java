package com.demo.nacos.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:12
 * @description
 */
@RestController
public class webController {

    @Value("${common.name}")
    private String config;

    @GetMapping("/config")
    public String getConfig(){
        return config;
    }
}
