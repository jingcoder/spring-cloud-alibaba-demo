package com.example.sentinelgatewayexample;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 17:22
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@Configuration
public class MySCGConfiguration {

    @Bean
    public BlockRequestHandler blockRequestHandler() {
        return new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange,
                                                      Throwable t) {
                return ServerResponse.status(444)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(fromObject("SCS Sentinel block"));
            }
        };
    }

}
