package com.company.project.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-boot-provider")
public interface DemoApi {

    @RequestMapping("/sayHi")
    String sayHi(@RequestParam(name = "name") String name) ;
}
