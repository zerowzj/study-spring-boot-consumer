package study.springcloud.client.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import study.springcloud.client.rest.support.SpringBootCfg;

@Slf4j
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}
