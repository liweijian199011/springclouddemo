package com.vipkid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace1Application {

    private static final Logger logger = LoggerFactory.getLogger(Trace1Application.class);

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace-1", method = RequestMethod.GET)
    public String trace(HttpServletRequest request) throws Exception {
//        URL url = new URL("http://localhost:1235/trace-2");
//        URLConnection conn = url.openConnection();4
//        return conn.getContent().toString();
        logger.info("---call trace-1, TraceId: {}, spanID: {}, spanName: {}, parentSpanId: {}--------", request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"), request.getHeader("X-Span-Name"), request.getHeader("X-B3-ParentSpanId"));
        restTemplate().getForEntity("http://localhost:1236/trace-3", String.class).getBody();

        logger.info("---call trace-1, TraceId: {}, spanID: {}, spanName: {}, parentSpanId: {}--------", request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"), request.getHeader("X-Span-Name"), request.getHeader("X-B3-ParentSpanId"));
        return restTemplate().getForEntity("http://localhost:1235/trace-2", String.class).getBody();
//        return "";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");
    }

	public static void main(String[] args) {
		SpringApplication.run(Trace1Application.class, args);
	}
}
