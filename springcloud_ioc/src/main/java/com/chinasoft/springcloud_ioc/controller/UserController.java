package com.chinasoft.springcloud_ioc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.chinasoft.springcloud_ioc.service.UserIocService;
import com.chinasoft.springcloud_util.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {
	/* private static String REST_URL_PREFIX = "http://localhost:8001";
	 直接根据微服务名调用，而不再是根据地址和端口了，运用了eureka的发现功能
	private static String REST_URL_PREFIX = "http://springcloud-orm";

	@Autowired
	private RestTemplate restTemplate;*/
	@Autowired
	@Resource
	private UserIocService userService;
  /*IOC的第一个 异步接口 控制器*/
  @RequestMapping(value="/selectCityAll")
  @ResponseBody
  public List<Map<String,Object>>  selectCityAll(@RequestParam Map<String,Object> Map){
	   System.out.println(Map);
	  List<Map<String,Object>> list=userService.selectCityAll(Map);
	  return list;
  }
  

}