package com.chinasoft.springcloud_ioc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= "com.chinasoft.springcloud_ioc1.service")
public class Ioc1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ioc1Application.class, args);
    }

}
