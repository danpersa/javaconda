package org.danix.javaconda.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableHystrix
@EnableTransactionManagement(
        order = Ordered.LOWEST_PRECEDENCE,
        mode = AdviceMode.ASPECTJ)
public class HystrixConfig {

    // sets the hystrix aspect to have higher precedence compared to the Transaction AOP
    @Bean
    @Primary
    @Order(value = Ordered.HIGHEST_PRECEDENCE)
    public HystrixCommandAspect hystrixAspect() {
        return new HystrixCommandAspect();
    }
}
