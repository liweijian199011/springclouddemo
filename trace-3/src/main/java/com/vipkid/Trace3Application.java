package com.vipkid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace3Application {

    private static final Logger logger = LoggerFactory.getLogger(Trace3Application.class);

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping(value = "/trace-3", method = RequestMethod.GET)
    public String trace(HttpServletRequest request) {
        logger.info("---call trace-3, TraceId: {}, spanID: {}, spanName: {}, parentSpanId: {}--------", request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"), request.getHeader("X-Span-Name"), request.getHeader("X-B3-ParentSpanId"));
        return "Trace";
    }

	public static void main(String[] args) {
		SpringApplication.run(Trace3Application.class, args);
	}
}