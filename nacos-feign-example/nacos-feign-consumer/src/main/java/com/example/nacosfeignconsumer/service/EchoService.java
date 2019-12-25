package com.example.nacosfeignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/7 8:56
 * @Email xu.xiaojing@frontsurf.com
 * @Description 熔断器hystrix默认是关闭的, 所以需要:feign.hystrix.enabled=true
 */

@FeignClient(name = "nacos-feign-provider", fallback = EchoServiceFallback.class,
        configuration = FeignConfiguration.class)
public interface EchoService {
    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping("/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    default String divide(Integer a) {
        return divide(a, 0);
    }

    @GetMapping("/notFound")
    String notFound();
}

//@Configuration

