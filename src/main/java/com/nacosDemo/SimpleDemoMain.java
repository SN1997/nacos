package com.nacosDemo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @Author ZXC
 * @Date 2020/10/31 13:13
 * @description
 */
public class SimpleDemoMain {

    public static void main(String[] args) {
        //使用nacos配置中心获取配置信息
        try {
            //配置信息
            String serverAddr ="127.0.0.1:8848";
            String dataId = "nacos-simple-demo.yml";
            String group = "DEFAULT_GROUP";
            
            Properties properties = new Properties();
            properties.put("serverAddr",serverAddr);
            //获取配置
            ConfigService configService =  NacosFactory.createConfigService(properties);
            //dataId  group 超时时间
            String config = configService.getConfig(dataId,group,5000);
            System.out.println(config);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
