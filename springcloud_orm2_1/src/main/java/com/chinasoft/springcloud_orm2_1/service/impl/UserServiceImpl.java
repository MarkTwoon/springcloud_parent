package com.chinasoft.springcloud_orm2_1.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.chinasoft.springcloud_orm2_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.springcloud_orm2_1.dao.UserMapper;

@Service
public class UserServiceImpl  
                            implements UserService {
  @Autowired
  private UserMapper userMapper;
  private  static  String UUIDMark= UUID.randomUUID().toString().replaceAll("-","");

@Override
public List<Map<String,Object>>  selectCityAll(Map<String,Object> map) {
	// TODO Auto-generated method stub
    System.out.println("ORM2_1微服务在响应客户端请求……");
    System.out.println("ORM2_1: " + UUIDMark);
	return userMapper.selectCityAll(map);
}


	
	
	
	
}
