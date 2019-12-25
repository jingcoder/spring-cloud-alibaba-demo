package com.example.streamrocketmqconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 11:18
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@Component
public class ConsumerCustomRunner implements CommandLineRunner {

    @Autowired
    private MySink mySink;

    /**
     * 轮询使用者，就是提供了一个 允许主动拉取信息的配置而已，
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        while (true) {
            mySink.input5().poll(m -> {
                String payload = (String) m.getPayload();
                System.out.println("pull msg: " + payload);
            }, new ParameterizedTypeReference<String>() {
            });
            Thread.sleep(2_000);
        }
    }
}
