package study.springcloud.consumer.rest.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableRetry
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer.rest")
public class SpringBootCfg {
}
