package com.vipkid.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/28.
 *
 * @author liweijian.
 */

@RestController
public class HelloController {

    @Autowired
    private HelloControllerClient helloControllerClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return helloControllerClient.hello();
    }
}
