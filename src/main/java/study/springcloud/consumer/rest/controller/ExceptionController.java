package study.springcloud.consumer.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @PostMapping("/throw_exception")
    public void throw_exception() {
        if (1 == 1) {
            throw new RuntimeException("Rest Client Exception");
        }
    }
}
