package com.example.sentinelfeignconsumer.service;

import com.example.sentinelfeignconsumer.fallback.EchoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 10:37
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@FeignClient(name = "sentinel-feign-provider",fallbackFactory = EchoServiceFallbackFactory.class)
public interface EchoService {

    /**
     * 调用服务提供方的输出接口.
     * @param str 用户输入
     * @return echo result
     */
    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping("/degrade")
    String degrade();
}
