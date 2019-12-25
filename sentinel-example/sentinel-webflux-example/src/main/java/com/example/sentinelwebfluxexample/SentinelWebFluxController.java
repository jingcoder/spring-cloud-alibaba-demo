package com.example.sentinelwebfluxexample;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 17:18
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@RestController
public class SentinelWebFluxController {

    @GetMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("simple string")
                // transform the publisher here.
                .transform(new SentinelReactorTransformer<>("mono"));
    }

    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.just("simple string")
                // transform the publisher here.
                .transform(new SentinelReactorTransformer<>("test"));
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.fromArray(new String[] { "a", "b", "c" })
                // transform the publisher here.
                .transform(new SentinelReactorTransformer<>("flux"));
    }

}
