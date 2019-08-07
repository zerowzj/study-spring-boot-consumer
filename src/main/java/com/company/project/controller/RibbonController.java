package com.company.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

//    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHi")
    public void sayHi() {
        restTemplate.getForObject("http://www.sohu.com", String.class);
    }
}
