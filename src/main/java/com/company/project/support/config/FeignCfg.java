package com.company.project.support.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignCfg {

    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}
