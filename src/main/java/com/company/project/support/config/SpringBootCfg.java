package com.company.project.support.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.company.project")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.company.project")
public class SpringBootCfg {
}
