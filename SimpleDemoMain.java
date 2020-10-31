package com.nacosDemo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

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
//            String namespace = "15971bf0-a097-441d-b243-e2c90255d03e";
            String dataId = "nacos-simple-demo.yml";
            String group = "DEFAULT_GROUP";
            
            Properties properties = new Properties();
            properties.put("serverAddr",serverAddr);
//            properties.put("namespace",namespace);
            //获取配置
            ConfigService configService =  NacosFactory.createConfigService(properties);
            //dataId  group 超时时间
            String config = configService.getConfig(dataId,group,5000);
            System.out.println(config);

            //监听
            //String dataId, String group, Listener listener
            configService.addListener(dataId, group, new Listener() {
                public Executor getExecutor() {
                    return null;
                }
                //当有配置变化时获取通知
                public void receiveConfigInfo(String s) {
                    System.out.println(s);
                }
            });

//            while (true){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
