package com.example.nacosfeignconsumer.service;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/10 下午2:50
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }




}

class EchoServiceFallback implements EchoService {

    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback";
    }

    @Override
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return "divide fallback";
    }

    @Override
    public String notFound() {
        return "notFound fallback";
    }

}

