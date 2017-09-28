package com.jack.controller;

import com.jack.api.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/28.
 *
 * @author liweijian.
 */
@FeignClient("METEOR-SERVICE")
public interface HelloControllerClient extends HelloService {
}
