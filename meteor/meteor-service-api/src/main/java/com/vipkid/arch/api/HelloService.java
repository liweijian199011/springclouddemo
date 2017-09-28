package com.vipkid.arch.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/28.
 *
 * @author liweijian.
 */
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
