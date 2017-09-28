package com.vipkid.arch.controller;

import com.vipkid.arch.api.HelloService;
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
public class HelloController implements HelloService {
    @Override
    public String hello() {
        return "hello, world";
    }
}
