package study.springcloud.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import study.springcloud.client.rest.support.SpringBootCfg;

public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}
