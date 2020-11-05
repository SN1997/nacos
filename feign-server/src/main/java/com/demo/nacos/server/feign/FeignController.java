package com.demo.nacos.server.feign;

import com.demo.feign.api.FeignApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZXC
 * @Date 2020/10/31 16:12
 * @description
 */
@RestController
public class FeignController implements FeignApi {

    @Value("${common.name:null}")
    private String feign;

    @Override
    public Map<String, Object> testFeign() {
        Map<String, Object> feignMap = new HashMap<>();
        feignMap.put("feign", feign);
        return feignMap;
    }

}
