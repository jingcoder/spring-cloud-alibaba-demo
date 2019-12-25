package com.example.sentinelcoreexample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 上午1:23
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 *
 *  这是服务熔断降级的demo
 */
@RestController
public class DegradeController {

    /**
     * 这里仅有 熔断降级,没有限流,配置一下即可
     * @return
     */
    @SentinelResource(value = "degrade",fallback = "fallback")
    @GetMapping("/degrade")
    public String degrade(){
        try {
            // 测试延时
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "访问成功";
    }

   public  String fallback(){
        return "access fail ,fallback";
    }
}
