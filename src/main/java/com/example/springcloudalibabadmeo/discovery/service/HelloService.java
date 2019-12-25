package com.example.springcloudaliframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Stream;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/6 上午8:28
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */


@FeignClient(name="service-provider",fallback = HelloServiceFallback.class,configuration = FeignConfiguration.class)
public interface HelloService {
    @GetMapping("/hello/name")
    String getName();

    /**
     * 测试服务降级
     */
    @GetMapping("/test_404")
    String test404();
}



@Component
class FeignConfiguration {

    @Bean
    public HelloServiceFallback helloServiceFallback() {
        return new HelloServiceFallback();
    }

}

class HelloServiceFallback implements HelloService {

    @Override
    public String getName() {
        return "name method fallback";
    }

    @Override
    public String test404() {
        return "404 request fall back";
    }
}
