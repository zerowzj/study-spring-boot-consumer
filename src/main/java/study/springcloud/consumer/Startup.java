package study.springcloud.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import study.springcloud.consumer.support.SpringBootCfg;

@EnableEurekaClient
@EnableFeignClients(basePackages = {"study.springcloud.provider"})
@SpringBootApplication
public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }
}
