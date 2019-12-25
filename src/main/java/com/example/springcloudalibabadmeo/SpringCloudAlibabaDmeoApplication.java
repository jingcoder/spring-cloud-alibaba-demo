package com.example.springcloudalibabadmeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudAlibabaDmeoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaDmeoApplication.class, args);
    }

    @LoadBalanced
    @Bean
//    @SentinelRestTemplate(urlCleanerClass = UrlCleaner.class, urlCleaner = "clean")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
