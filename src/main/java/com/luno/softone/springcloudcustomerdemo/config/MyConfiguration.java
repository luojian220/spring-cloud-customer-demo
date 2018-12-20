package com.luno.softone.springcloudcustomerdemo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author luojian
 * @version 1.0
 * @ClassName: MyConfiguration
 * @Reason: TODO ADD REASON(可选)
 * @date: 2018年12月20日 11:33
 * @company:宝尊电商
 * @since JDK 1.8
 */
@Configuration
public class MyConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}