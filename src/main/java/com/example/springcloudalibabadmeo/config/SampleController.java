package com.example.springcloudalibabadmeo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author xu.xiaojing
 * @Date 2019/11/5 上午1:20
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@RestController
@RefreshScope
class SampleController {

    @Value("${user.name}")
    String userName;

    @Value("${user.age:25}")
    Integer age;

//    @Value("${user.height}")
    Integer height;


//    @Autowired
//    private NacosConfigManager nacosConfigManager;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age + " "+height+  "!";
//                + nacosConfigManager.getConfigService();
    }

}
