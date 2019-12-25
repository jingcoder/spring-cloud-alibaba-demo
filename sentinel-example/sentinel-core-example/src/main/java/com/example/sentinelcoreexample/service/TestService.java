package com.example.sentinelcoreexample.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinelcoreexample.blockhandler.ExceptionUtil;
import org.springframework.stereotype.Service;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 上午1:05
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 *
 *  SentinelResource 可以注解在任意一个方法,即资源可以一个方法(代码块)
 */
@Service
public class TestService {

    /**
     * blockHandler 是位于 ExceptionUtil 类下的 handleException 静态方法，需符合对应的类型限制.
      */
    @SentinelResource(value = "service-test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {
        System.out.println("Test");
    }

    /**
     * blockHandler 是位于当前类下的 exceptionHandler 方法，需符合对应的类型限制.
     *
      */
    @SentinelResource(value = "service-hello", blockHandler = "exceptionHandler")
    public String hello(long s) {
        return String.format("Hello at %d", s);
    }

    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

}
