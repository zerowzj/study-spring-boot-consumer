package study.springcloud.consumer.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient
@EnableEurekaClient
@EnableFeignClients(basePackages = {"study.springcloud.provider"})
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer")
public class SpringBootCfg {
}
