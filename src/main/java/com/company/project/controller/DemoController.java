package com.company.project.controller;

import com.company.project.api.DemoApi;
import com.company.project.bean.DemoParam;
import com.company.project.bean.DemoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoApi demoApi;

    @RequestMapping("/demo/sayHi")
    public String sayHi() {
        return demoApi.sayHi("wangzhj");
    }

    @RequestMapping("/demo/sayBye")
    public String sayBye() {
        DemoParam param = new DemoParam();
        param.setName("wangzhj");
        DemoResult bean = demoApi.sayBye(param);
        return bean.getName() + "==" + bean.getMsg();
    }
}
