package com.company.project;

import com.company.project.support.config.SpringBootCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootCfg.class, args);
    }
}
