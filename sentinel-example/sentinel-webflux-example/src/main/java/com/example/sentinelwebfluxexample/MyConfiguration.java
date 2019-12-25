package com.example.sentinelwebfluxexample;

import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.BlockRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 17:17
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@Configuration
public class MyConfiguration {

    @Bean
    public BlockRequestHandler blockRequestHandler() {
        return new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange,
                                                      Throwable t) {
                return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(fromObject("block"));
            }
        };
    }

}
