package com.demo.nacos.fallBack;

import com.demo.nacos.feign.api.FeignApiService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lsz
 * @date 2020/11/12 18:30
 */
@Component
public class feignFallBack implements FeignApiService {


    @Override
    public Map<String, Object> testFeign() {
        Map map=new HashMap();
        map.put("message","testFeign异常");
        return map;
    }

    @Override
    public Map<String, Object> testRibbon() {
        Map map=new HashMap();
        map.put("message","testRibbon异常");
        return map;
    }

    @Override
    public Map<String, Object> testHystrix() {
        Map map=new HashMap();
        map.put("message","testHystrix异常");
        return map;
    }
}
