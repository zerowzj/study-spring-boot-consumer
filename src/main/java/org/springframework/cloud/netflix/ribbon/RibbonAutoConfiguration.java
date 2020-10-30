//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.cloud.netflix.ribbon;

import com.netflix.client.IClient;
import com.netflix.client.http.HttpRequest;
import com.netflix.ribbon.Ribbon;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.actuator.HasFeatures;
import org.springframework.cloud.client.loadbalancer.AsyncLoadBalancerAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
@Conditional({RibbonAutoConfiguration.RibbonClassesConditions.class})
@RibbonClients
@AutoConfigureAfter(
        name = {"org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration"}
)
@AutoConfigureBefore({LoadBalancerAutoConfiguration.class, AsyncLoadBalancerAutoConfiguration.class})
@EnableConfigurationProperties({RibbonEagerLoadProperties.class, ServerIntrospectorProperties.class})
public class RibbonAutoConfiguration {
    @Autowired(
            required = false
    )
    private List<RibbonClientSpecification> configurations = new ArrayList();
    @Autowired
    private RibbonEagerLoadProperties ribbonEagerLoadProperties;

    public RibbonAutoConfiguration() {
    }

    @Bean
    public HasFeatures ribbonFeature() {
        return HasFeatures.namedFeature("Ribbon", Ribbon.class);
    }

    @Bean
    @ConditionalOnMissingBean
    public SpringClientFactory springClientFactory() {
        SpringClientFactory factory = new SpringClientFactory();
        factory.setConfigurations(this.configurations);
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean({LoadBalancerClient.class})
    public LoadBalancerClient loadBalancerClient() {
        return new RibbonLoadBalancerClient(this.springClientFactory());
    }

    @Bean
    @ConditionalOnClass(
            name = {"org.springframework.retry.support.RetryTemplate"}
    )
    @ConditionalOnMissingBean
    public LoadBalancedRetryFactory loadBalancedRetryPolicyFactory(final SpringClientFactory clientFactory) {
        return new RibbonLoadBalancedRetryFactory(clientFactory);
    }

    @Bean
    @ConditionalOnMissingBean
    public PropertiesFactory propertiesFactory() {
        return new PropertiesFactory();
    }

    @Bean
    @ConditionalOnProperty({"ribbon.eager-load.enabled"})
    public RibbonApplicationContextInitializer ribbonApplicationContextInitializer() {
        return new RibbonApplicationContextInitializer(this.springClientFactory(), this.ribbonEagerLoadProperties.getClients());
    }

    static class RibbonClassesConditions extends AllNestedConditions {
        RibbonClassesConditions() {
            super(ConfigurationPhase.PARSE_CONFIGURATION);
        }

        @ConditionalOnClass({Ribbon.class})
        static class RibbonPresent {
            RibbonPresent() {
            }
        }

        @ConditionalOnClass({AsyncRestTemplate.class})
        static class AsyncRestTemplatePresent {
            AsyncRestTemplatePresent() {
            }
        }

        @ConditionalOnClass({RestTemplate.class})
        static class RestTemplatePresent {
            RestTemplatePresent() {
            }
        }

        @ConditionalOnClass({IClient.class})
        static class IClientPresent {
            IClientPresent() {
            }
        }
    }

    private static class OnRibbonRestClientCondition extends AnyNestedCondition {
        OnRibbonRestClientCondition() {
            super(ConfigurationPhase.REGISTER_BEAN);
        }

        @ConditionalOnProperty({"ribbon.restclient.enabled"})
        static class RibbonProperty {
            RibbonProperty() {
            }
        }

        /** @deprecated */
        @Deprecated
        @ConditionalOnProperty({"ribbon.http.client.enabled"})
        static class ZuulProperty {
            ZuulProperty() {
            }
        }
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Conditional({RibbonAutoConfiguration.OnRibbonRestClientCondition.class})
    @interface ConditionalOnRibbonRestClient {
    }

    @Configuration(
            proxyBeanMethods = false
    )
    @ConditionalOnClass({HttpRequest.class})
    @RibbonAutoConfiguration.ConditionalOnRibbonRestClient
    protected static class RibbonClientHttpRequestFactoryConfiguration {
        @Autowired
        private SpringClientFactory springClientFactory;

        protected RibbonClientHttpRequestFactoryConfiguration() {
        }

        @Bean
        public RestTemplateCustomizer restTemplateCustomizer(final RibbonClientHttpRequestFactory ribbonClientHttpRequestFactory) {
            return (restTemplate) -> {
                restTemplate.setRequestFactory(ribbonClientHttpRequestFactory);
            };
        }

        @Bean
        public RibbonClientHttpRequestFactory ribbonClientHttpRequestFactory() {
            return new RibbonClientHttpRequestFactory(this.springClientFactory);
        }
    }
}
