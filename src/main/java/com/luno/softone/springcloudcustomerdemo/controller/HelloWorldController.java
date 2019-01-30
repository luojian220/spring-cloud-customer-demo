package com.luno.softone.springcloudcustomerdemo.controller;

import com.luno.softone.springcloudcustomerdemo.dto.HelloMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author luojian
 * @version 1.0
 * @ClassName: HelloworldController
 * @Reason: TODO ADD REASON(可选)
 * @date: 2018年12月19日 16:30
 * @company:
 * @since JDK 1.8
 */
@RestController
//这里面的属性有可能会更新的，git中的配置中心变化的话就要刷新，没有这个注解内，配置就不能及时更新
@RefreshScope
public class HelloWorldController {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${name}")
    private String name;

    @GetMapping("/")
    public String home() {
        return "hello world , customer : " + name;
    }

    @GetMapping("/message")
    public Object getMessage() {
        HelloMessageDTO hello = getMessageFromHelloService();
        log.debug("Result helloworld message:{}", hello);
        return hello;
    }

    private HelloMessageDTO getMessageFromHelloService() {
        HelloMessageDTO hello = restTemplate.getForObject("http://provide-app/message", HelloMessageDTO.class);
        log.debug("From hello service : {}.", hello);
        return hello;
    }


}
