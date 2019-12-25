package com.example.sentinelcoreexample;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.example.sentinelcoreexample.blockhandler.ExceptionUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SentinelCoreExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelCoreExampleApplication.class, args);
    }


    /**
     * 调用链限流
     * @return
     */
    @Bean
    @SentinelRestTemplate(blockHandler = "handleException",
            blockHandlerClass = ExceptionUtil.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }

    @Bean
    public Converter myConverter() {
        return new JsonFlowRuleListConverter();
    }

}
