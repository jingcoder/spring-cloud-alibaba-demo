package com.example.sentinelfeignconsumer.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 10:40
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@Component
public class EchoServiceFallbackFactory implements FallbackFactory<EchoServiceFallback> {

    @Override
    public EchoServiceFallback create(Throwable throwable) {
        return new EchoServiceFallback(throwable);
    }
}
