package com.example.nacosgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 这是 网关应用，此demo仅仅是静态路由配置，后续可依靠nacos实现动态路由配置
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosGatewayApplication.class, args);
    }
}
