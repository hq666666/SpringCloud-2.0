package com.person.provider.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderService02 {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/provide")
    public String provide(){
        return "提供者服务,请消费"+port;
    }
}
