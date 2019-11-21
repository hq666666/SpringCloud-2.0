package com.person.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 搭建provider集群：所创建服务
 */
@SpringBootApplication
@EnableEurekaClient //服务注册
public class ServiceProvider02 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider02.class,args);
    }
}
