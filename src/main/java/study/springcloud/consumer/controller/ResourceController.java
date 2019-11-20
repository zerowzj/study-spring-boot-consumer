package study.springcloud.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @GetMapping("/sayHi")
    public void sayHi() {
        LOGGER.info("S");
    }
}
