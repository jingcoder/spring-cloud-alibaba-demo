package com.example.feignprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/5 下午11:56
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/name")
    public String getName(){
        return "xiaojing";
    }
}
