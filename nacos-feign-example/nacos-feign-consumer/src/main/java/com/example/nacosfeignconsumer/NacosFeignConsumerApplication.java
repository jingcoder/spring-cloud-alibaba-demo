package com.example.nacosfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class NacosFeignConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(NacosFeignConsumerApplication.class, args);
    }

}




