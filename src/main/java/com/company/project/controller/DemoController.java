package com.company.project.controller;

import com.company.project.api.DemoApi;
import com.company.project.bean.DemoPO;
import com.company.project.bean.DemoRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoApi demoApi;

    @RequestMapping("/demo1")
    public String demo1() {
        return demoApi.demo1("wangzhj");
    }

    @RequestMapping("/demo2")
    public String demo2() {
        return demoApi.demo2("wangzhj");
    }

    @RequestMapping("/demo3")
    public String demo3() {
        DemoPO param = new DemoPO();
        param.setName("wangzhj");
        DemoRO bean = demoApi.demo3(param);
        return bean.getName() + "==" + bean.getMsg();
    }
}
