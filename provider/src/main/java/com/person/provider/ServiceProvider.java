package com.person.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //将服务注册到eureka
public class ServiceProvider {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider.class,args);
    }
}
