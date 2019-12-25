package com.example.nacossleuthprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class NacosSleuthProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSleuthProviderApplication.class, args);
    }



    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public String trace() {
        System.out.println("===<call provider trace-1>===");
        return "success rep ";
    }

}
