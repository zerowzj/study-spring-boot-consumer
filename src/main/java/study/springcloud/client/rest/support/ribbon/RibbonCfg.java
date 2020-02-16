package study.springcloud.client.rest.support.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
//@Configuration
//@RibbonClients(value = {
//        @RibbonClient(name = "study-springcloud-provider", configuration = RibbonCfg.class)
////        ,@RibbonClient(name = "study-springcloud-provider", configuration = RibbonCfg.class)
//})
public class RibbonCfg {


    @Bean
    public IRule ribbonRule() {
        new RoundRobinRule(); //轮询
        new RetryRule(); //
        IRule rule = new RandomRule();
        return rule;
    }

    @Bean
    public IPing ribbonPing() {
        IPing ping = new NoOpPing();
        return ping;
    }

//    @Bean
//    public ServerList<Server> ribbonServerList() {
//        return new ConfigurationBasedServerList();
//    }

//    @Bean
//    public ServerListSubsetFilter serverListFilter() {
//        ServerListSubsetFilter filter = new ServerListSubsetFilter();
//        return filter;
//    }
}
