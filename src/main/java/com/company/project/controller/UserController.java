package com.company.project.controller;

import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/checkin")
    public String checkin() {
        userService.checkinAdmin();
        return "ok";
    }
}
