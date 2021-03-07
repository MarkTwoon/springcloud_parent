package com.chinasoft.springcloud_ioc.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="springcloud-orm", fallbackFactory=UserIocServiceFallbackFactory.class)
public interface UserIocService {
  
@RequestMapping(value="/selectCityAll")
public List<Map<String,Object>>  selectCityAll(Map<String,Object> map);

}
