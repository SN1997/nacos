package com.demo.nacos.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:06
 * @description
 */
@ComponentScan({"com.demo.nacos"})
@SpringBootApplication
@Configuration
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.demo.nacos.feign"})
@EnableCircuitBreaker
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }

}
