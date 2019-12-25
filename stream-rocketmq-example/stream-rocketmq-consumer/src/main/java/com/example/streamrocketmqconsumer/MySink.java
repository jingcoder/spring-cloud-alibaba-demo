package com.example.streamrocketmqconsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 11:10
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public interface MySink {

    @Input("input1")
    SubscribableChannel input1();

    @Input("input2")
    SubscribableChannel input2();

    @Input("input3")
    SubscribableChannel input3();

    @Input("input4")
    SubscribableChannel input4();

    @Input("input5")
    PollableMessageSource input5();
}
