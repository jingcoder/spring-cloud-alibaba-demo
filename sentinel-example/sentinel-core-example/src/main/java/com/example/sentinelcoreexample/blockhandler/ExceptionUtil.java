package com.example.sentinelcoreexample.blockhandler;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/23 下午9:18
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public final class ExceptionUtil {

    private ExceptionUtil() {

    }

    public static SentinelClientHttpResponse handleException(HttpRequest request,
                                                             byte[] body,
                                                             ClientHttpRequestExecution execution,
                                                             BlockException ex) {
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("custom block info");
    }

}
