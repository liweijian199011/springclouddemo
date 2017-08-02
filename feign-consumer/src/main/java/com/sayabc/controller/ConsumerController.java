package com.sayabc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ComputeClient computeClient;

    @GetMapping("/add")
    public Integer add() {
        return computeClient.add(10, 20);
    }
}
