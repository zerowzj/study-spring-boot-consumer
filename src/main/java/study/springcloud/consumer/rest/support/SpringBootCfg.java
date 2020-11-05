package study.springcloud.consumer.rest.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer.rest",
        exclude = {})
public class SpringBootCfg {
}
