package com.example.sentinelcoreexample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.sentinelcoreexample.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/23 下午9:25
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 *
 *   限流的demo 类
 */
@RestController
public class FlowLimitController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 默认为所有的 Http进行 埋点,即 所有的http会默认开启限流,不需要注解也可以
     * @return
     */
    @GetMapping("/hello")
//    @SentinelResource("resource")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/aa")
    @SentinelResource("aa")
    public String aa(int b, int a) {
        return "Hello test";
    }

    @GetMapping("/test")
    public String test1() {
        return "Hello test";
    }

    /**
     * redisTemplate 访问资源限流
     * @return
     */
    @GetMapping("/template")
    public String client() {
        return restTemplate.getForObject("http://www.taobao.com/test", String.class);
    }

    @Autowired
    TestService testService;

    /**
     * 调用有限流的内部方法
     */
   @GetMapping("/innerRes")
    public String innerResource(){
//       TestService testService = new TestService();
       return testService.hello(12321);
//       return "调用内部方法资源成功";
   }

    /**
     *   没有任何限流配置的方法,作为对比
     */
    @GetMapping("/noConfig")
    public String noConfig(){
        return "访问成功-noConfig";
    }

}
