package com.company.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoApi demoApi;

    @RequestMapping("/demo/sayHi")
    public String sayHi(){
        return demoApi.sayHi("wangzhj");
    }
}
