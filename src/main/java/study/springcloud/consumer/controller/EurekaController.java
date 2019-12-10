package study.springcloud.consumer.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EurekaController {

    private DiscoveryClient discoveryClient;

    public void demo() {

    }
}
