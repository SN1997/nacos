package com.demo.nacos.server.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ZXC
 * @Date 2020/11/4 11:51
 * @description
 */
@Configuration
public class ConsumerConfigure {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
