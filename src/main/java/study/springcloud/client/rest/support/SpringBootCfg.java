package study.springcloud.client.rest.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@RibbonClient
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer")
public class SpringBootCfg {
}
