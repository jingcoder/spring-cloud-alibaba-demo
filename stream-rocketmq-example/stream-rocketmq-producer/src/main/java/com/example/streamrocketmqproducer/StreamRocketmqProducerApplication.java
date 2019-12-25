package com.example.streamrocketmqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding({MySource.class})
public class StreamRocketmqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamRocketmqProducerApplication.class, args);
    }

}
