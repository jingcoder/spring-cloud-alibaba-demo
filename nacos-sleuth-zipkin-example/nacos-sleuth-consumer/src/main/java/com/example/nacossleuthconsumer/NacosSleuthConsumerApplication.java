package com.example.nacossleuthconsumer;

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
public class NacosSleuthConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSleuthConsumerApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public String trace() {
        System.out.println("===<call consumer trace-1>===");
        return restTemplate().getForEntity("http://provider-trace/trace", String.class).getBody();
    }

}
