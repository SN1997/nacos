package com.demo.nacos.server.web;

import com.aspose.words.Document;
import com.demo.nacos.feign.api.FeignApiService;
import com.demo.nacos.util.WordToPdf;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:12
 * @description
 */
@RestController
@RefreshScope
@DefaultProperties(defaultFallback = "hystrixFallback")
public class WebController {
    Logger log = LoggerFactory.getLogger(WebController.class);
    @Value("${common.name:null}")
    private String config;

    @Resource
    private FeignApiService feignApiService;

    @GetMapping("/config")
    public void getConfig() throws Exception {
        Document document=new Document("C:\\Users\\Administrator\\Desktop\\jfyxxy.docx");
        File file = new File("C:\\Users\\Administrator\\Desktop\\shengcheng.html");
        FileWriter fw = null;
        BufferedWriter bw = null;
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        String content = WordToPdf.parseWord2Html(document);
        bw.write(content);
        bw.flush();
        fw.flush();
    }

    @GetMapping("/configTest")
    public Map<String, Object> configTest() {
        Map<String, Object> map = new HashMap();
        map.put("configTest", config);
        return map;
    }
    @GetMapping("/feign")
    public Map<String, Object> testFeign() {
        return feignApiService.testFeign();
    }

    @GetMapping("/ribbon")
    public Map<String, Object> testRibbon() {
        return feignApiService.testRibbon();
    }

    @GetMapping("/hystrix")
//    @HystrixCommand(fallbackMethod = "hystrixFallback",commandProperties = {
//
//    })
    @HystrixCommand
    public Map<String, Object> testHystrix(@RequestParam(value = "id",defaultValue = "0") Integer id) throws Exception{
        if(id == 1){
            throw new Exception("熔断测试");
        }
        System.out.println("1");
        Thread.sleep(5000);
        System.out.println("2");
        return feignApiService.testHystrix();
    }

    @GetMapping("/hystrix1")
//    @HystrixCommand
    public Map<String, Object> testHystrix1(@RequestParam(value = "id",defaultValue = "0") Integer id) throws Exception{
        if(id == 1){
            throw new Exception("熔断测试");
        }
        return feignApiService.testHystrix();
    }

    /**
     * @Title : hystrixFallback
     * @Description : 服务降级执行的方法：必须给一个和请求接口相同的参数以及相同的返回值
     * @author : qt
     * @date : 2020-11-12 17:24
     */
    private Map<String, Object> hystrixFallback() {
        Map<String, Object> hystrixMap = new HashMap<>();
        hystrixMap.put("testHystrix", "网络拥堵，请稍后再试~");
        return hystrixMap;
    }

}
