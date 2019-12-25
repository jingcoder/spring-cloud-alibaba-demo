package com.example.streamrocketmqproducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 15:29
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public interface MySource {

    @Output("output1")
   public MessageChannel output1();

    @Output("output2")
    MessageChannel output2();

    @Output("output3")
    MessageChannel output3();

    @Output("output5")
    MessageChannel output5();

}
