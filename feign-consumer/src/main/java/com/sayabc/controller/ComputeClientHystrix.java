package com.sayabc.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/8/2
 *
 * @author: 李伟健
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return -9999;
    }
}
