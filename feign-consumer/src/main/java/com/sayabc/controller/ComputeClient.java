package com.sayabc.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/8/2
 *
 * @author: 李伟健
 */
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @GetMapping("/add")
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
