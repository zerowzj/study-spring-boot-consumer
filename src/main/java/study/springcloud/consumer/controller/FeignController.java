package study.springcloud.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcloud.provider.DemoService;

@RestController
@RequestMapping("/feign")
public class FeignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private DemoService demoService;

    @GetMapping("/sayHi")
    public void sayHi() {
        demoService.hello("wangzhj");
    }
}
