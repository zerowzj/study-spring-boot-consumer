package study.springcloud.consumer.rest.controller.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping("/sayHi")
    public String sayHi() {
        return "hello...";
    }
}
