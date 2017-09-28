package com.vipkid.arch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MeteorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeteorConsumerApplication.class, args);
	}
}