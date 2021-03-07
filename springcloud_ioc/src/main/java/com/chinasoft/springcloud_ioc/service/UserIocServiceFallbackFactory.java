package com.chinasoft.springcloud_ioc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class UserIocServiceFallbackFactory implements FallbackFactory<UserIocService>{

    @Override
    public UserIocService create(Throwable arg0) {
        // TODO Auto-generated method stub
        return new UserIocService(){
            /*ORM线程 远程调用异常的  catch异常捕获执行*/
            @Override
            public List<Map<String, Object>> selectCityAll(Map<String,Object> map) {
                // TODO Auto-generated method stub
                Map<String,Object> map1=new HashMap<String, Object>();
                map1.put("mark", "ORM线程运行异常，远程调用数据传输失败-IOC熔断");
                List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
                list.add(map1);
                return list;
            }



        };
    }



}
