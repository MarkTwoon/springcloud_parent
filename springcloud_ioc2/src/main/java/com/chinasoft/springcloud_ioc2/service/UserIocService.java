package com.chinasoft.springcloud_ioc2.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="springcloud-orm2", fallbackFactory=UserIocServiceFallbackFactory.class)
public interface UserIocService {
  
@RequestMapping(value="/selectCityAll")
public List<Map<String,Object>>  selectCityAll(Map<String,Object> map);

}
