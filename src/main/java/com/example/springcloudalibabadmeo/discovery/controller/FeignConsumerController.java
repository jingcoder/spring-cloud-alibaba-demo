package com.example.springcloudalibabadmeo.discovery.controller;

import com.example.springcloudalibabadmeo.discovery.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/6 上午12:58
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 *
 *   使用Feign的例子
 */

@RestController
@RequestMapping("/feign")
public class FeignConsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello-service")
    public String getName(){
        return helloService.getName();
    }

    @GetMapping("/404_fallback")
    public String test404FallBack(){
        return helloService.test404();
    }

}
