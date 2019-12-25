package com.example.sentinelfeignprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 10:26
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@RestController
public class EchoController {

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return "provider-" + str;
    }

    @GetMapping("/degrade")
    public String degrade(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "provider-degrade";
    }

}
