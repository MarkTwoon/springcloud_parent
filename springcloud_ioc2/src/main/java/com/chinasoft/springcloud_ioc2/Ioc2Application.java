package com.chinasoft.springcloud_ioc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= "com.chinasoft.springcloud_ioc2.service")
public class Ioc2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ioc2Application.class, args);
    }

}
