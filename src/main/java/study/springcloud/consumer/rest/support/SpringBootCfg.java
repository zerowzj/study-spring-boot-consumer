package study.springcloud.consumer.rest.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer.rest")
public class SpringBootCfg {
}

