package com.chinasoft.springcloud_orm1_2.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public List<Map<String,Object>>  selectCityAll(Map<String,Object> map);

}
