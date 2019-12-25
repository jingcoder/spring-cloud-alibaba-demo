package com.example.streamrocketmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableDiscoveryClient
@SpringBootApplication
public class StreamRocketmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamRocketmqConsumerApplication.class, args);
    }

}
