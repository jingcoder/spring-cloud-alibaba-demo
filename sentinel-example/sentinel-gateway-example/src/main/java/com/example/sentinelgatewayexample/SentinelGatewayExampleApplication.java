package com.example.sentinelgatewayexample;

import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class SentinelGatewayExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelGatewayExampleApplication.class, args);
    }

}
