package com.luno.softone.springcloudcustomerdemo.controller;

import com.luno.softone.springcloudcustomerdemo.dto.HelloMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author luojian
 * @version 1.0
 * @ClassName: HelloworldController
 * @Reason: TODO ADD REASON(可选)
 * @date: 2018年12月19日 16:30
 * @company:宝尊电商
 * @since JDK 1.8
 */
@RestController
public class HelloWorldController {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return "hello world";
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
