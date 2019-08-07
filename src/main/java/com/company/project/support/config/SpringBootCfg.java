package com.company.project.support.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.company.project")
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.company.project")
public class SpringBootCfg {
}
