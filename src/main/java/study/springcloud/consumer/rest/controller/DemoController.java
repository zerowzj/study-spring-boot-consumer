package study.springcloud.consumer.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcloud.consumer.rest.support.utils.Results;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/sayHi")
    public Map<String, Object> sayHi() {
        return Results.ok();
    }
}
