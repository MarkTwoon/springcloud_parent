package com.chinasoft.springcloud_orm2_1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasoft.springcloud_orm2_1.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*注意 ORM的controller层  数据传递
 * 统一配置异步接口 返回json数据
 * 注解引入异步控制层*/
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="selectCityAll")
	@HystrixCommand(fallbackMethod="hystrixselectCityAll") //一旦服务调用失败，就调用hystrixGetUser方法
	public List<Map<String,Object>>  selectCityAll(@RequestBody Map<String,Object> map){
	 /*注意 ORM中的controller层控制器方法 均为异步交互 直接返回json数据
	  * 因为ORM控制器 对外提供了一个数据传输的访问action
	  * 对内 内部调用service层 用于执行SQL指令执行结果
	  *  获取select查询结果集  或DML操作的返回布尔值 */
		System.out.println("IOC2:ORM2_1数据传递");
		 List<Map<String,Object>>  list= userService.selectCityAll(map);
		 /*若查询结果无数据  则抛出熔断异常 转而跳出当前方法体 
		  * 交由熔断方法 进行数据异常捕获处理*/
		if(list.size() <=  0){
			throw new RuntimeException("查询数据为空");
		}
		return list;
	}

	public List<Map<String,Object>>  hystrixselectCityAll(@RequestBody Map<String,Object> map){
		Map<String,Object> map1=new HashMap<String, Object>();
		map1.put("mark", "查询结果为空，不存在指定数据-ORM2_1");
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map1);
		System.out.println("ORM2_1熔断");
		return list;
	}


}
