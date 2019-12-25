package com.example.sentinelfeignconsumer.fallback;

import com.example.sentinelfeignconsumer.service.EchoService;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 10:39
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public class EchoServiceFallback implements EchoService {

    private Throwable throwable;

    EchoServiceFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * 调用服务提供方的输出接口.
     * @param str 用户输入
     * @return
     */
    @Override
    public String echo(String str) {
        return "consumer-fallback-default-str" + throwable.getMessage();
    }

    @Override
    public String degrade() {
        return " consumer-fallback-degrade ";
    }

}
