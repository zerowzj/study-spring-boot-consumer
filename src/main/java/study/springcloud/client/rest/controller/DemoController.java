package study.springcloud.client.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcloud.client.rest.support.utils.Results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/sayHi")
    public Map<String, Object> sayHi() {
        return Results.ok(null);
    }

    @PostMapping("/exception")
    public String getNextServer(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendError(500);
        } catch (Exception ex) {

        }
        return "";
    }
}
