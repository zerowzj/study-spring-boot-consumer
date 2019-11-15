package study.springcloud.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import study.springcloud.consumer.support.SpringBootCfg;

public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}
