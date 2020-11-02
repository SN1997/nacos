package com.demo.nacos.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:06
 * @description
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }
}
