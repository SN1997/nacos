package com.demo.nacos.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:06
 * @description
 */
@EnableAutoConfiguration
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }
}