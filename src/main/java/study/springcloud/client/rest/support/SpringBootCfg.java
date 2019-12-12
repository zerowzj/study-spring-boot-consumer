package study.springcloud.client.rest.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.retry.annotation.EnableRetry;
import study.springcloud.client.rest.support.ribbon.RibbonCfg;

@EnableRetry
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "study.springcloud.client.rest")
public class SpringBootCfg {
}
