package study.springcloud.client.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springcloud.client.rest.support.utils.Results;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/sayHi")
    public Map<String, Object> sayHi() {
        return Results.ok(null);
    }

    @PostMapping("/throwException")
    public void throwException() {
        if (1 == 1) {
            throw new RuntimeException("client exception");
        }
    }

    @PostMapping("/timeout")
    public void timeout(@RequestParam Long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
