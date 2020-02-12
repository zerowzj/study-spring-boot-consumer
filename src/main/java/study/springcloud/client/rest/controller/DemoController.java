package study.springcloud.client.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/exception")
    public String getNextServer(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendError(500);
        } catch (Exception ex) {

        }
        return "";
    }
}
