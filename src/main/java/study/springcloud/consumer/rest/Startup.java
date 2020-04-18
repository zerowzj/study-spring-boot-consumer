package study.springcloud.consumer.rest;

import org.springframework.boot.SpringApplication;
import study.springcloud.consumer.rest.support.SpringBootCfg;

public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}
