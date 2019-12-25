package com.example.springcloudalibabadmeo.discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/5 上午8:32
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 *
 *  下面两种是不使用Feign的情况,
 */
@RestController
@RequestMapping("/consumer")
public class NacosConsumerController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * restTemplate实现的负载均衡
     * @param str
     * @return
     */
    @RequestMapping(value = "rest/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/hello/" + str, String.class);
    }

    /**
     *  loadBanlance 实现的负载均衡
     */
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/load/name")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        String url = serviceInstance.getUri() + "/hello/name";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }
}
