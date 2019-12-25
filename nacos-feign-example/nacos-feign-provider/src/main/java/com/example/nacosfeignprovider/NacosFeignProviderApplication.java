package com.example.nacosfeignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosFeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosFeignProviderApplication.class, args);
    }

}




