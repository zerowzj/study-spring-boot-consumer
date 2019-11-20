package study.springcloud.consumer.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@EnableEurekaClient
@EnableResourceServer
@EnableFeignClients(basePackages = {"study.springcloud.provider"})
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer")
public class SpringBootCfg {
}
