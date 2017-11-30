package com.company.project.controller;

import com.company.project.api.DemoApiClient;
import com.company.project.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoApiClient demoApiClient;

    @RequestMapping("/demo/sayHi")
    public String sayHi() {
        return demoApiClient.sayHi("wangzhj");
    }

    @RequestMapping("/demo/sayBye")
    public String sayBye() {
        DemoBean bean = demoApiClient.sayBye("xiaohong");
        return bean.getMsg();
    }
}
