package com.sayabc.controller;

//import com.jack.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

//    ExampleService exampleService;

//    private RedisClient
    @GetMapping("/add")
    public Integer add(Integer a, Integer b) {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        Integer result = a + b;
        logger.info("result: {}, host: {}, port:{}, serviceId: {}",
                result, serviceInstance.getHost(), serviceInstance.getServiceId(), serviceInstance.getPort());
        return result;
    }
//
//    @GetMapping("/test")
//    public String test(String word) {
//        return exampleService.wrap(word);
//    }


}
