package com.sayabc.controller;

import com.sayabc.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/8/2
 *
 * @author: 李伟健
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/add")
    public String add() {
//        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=1&b=2", String.class).getBody();
        return consumerService.addService();
    }
}
