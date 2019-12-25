package com.example.streamrocketmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 11:18
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

@Component
public class CustomRunnerWithTransactional  implements CommandLineRunner {

    @Autowired
    private SenderService senderService;

    @Override
    public void run(String... args) throws Exception {
        // COMMIT_MESSAGE message
        senderService.sendTransactionalMsg("transactional-msg1", 1);
        // ROLLBACK_MESSAGE message
        senderService.sendTransactionalMsg("transactional-msg2", 2);
        // ROLLBACK_MESSAGE message
        senderService.sendTransactionalMsg("transactional-msg3", 3);
        // COMMIT_MESSAGE message
        senderService.sendTransactionalMsg("transactional-msg4", 4);
    }
}
