package com.example.sentinelfeignconsumer.controller;

import com.example.sentinelfeignconsumer.service.CourseRecordService;
import com.example.sentinelfeignconsumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 10:37
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@RestController
public class TestController {


    @Autowired
    private EchoService echoService;

    @Autowired
    CourseRecordService courseRecordService;

    @GetMapping("/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

    @GetMapping("/degrade")
    public String degrade(){
        return echoService.degrade();
    }

    @GetMapping("/test")
    public String test(){
        return courseRecordService.test("哈哈哈");
    }

    @GetMapping("/test2")
    public String test2(){
        return courseRecordService.test2("哈哈哈2");
    }
}
