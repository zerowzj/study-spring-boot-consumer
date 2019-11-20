package study.springcloud.consumer.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@EnableEurekaClient
@EnableOAuth2Client
//@EnableFeignClients(basePackages = {"study.springcloud.provider"})
@SpringBootApplication(scanBasePackages = "study.springcloud.consumer")
public class SpringBootCfg {
}
