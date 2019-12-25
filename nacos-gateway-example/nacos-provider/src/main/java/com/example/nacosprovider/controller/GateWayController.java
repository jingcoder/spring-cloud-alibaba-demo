package com.example.nacosprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/6 22:38
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@RestController
@RequestMapping("/gateway_pro")
public class GateWayController {

    @GetMapping("/hello")
    public String name(){
        return "this is gateway's provider";
    }
}
