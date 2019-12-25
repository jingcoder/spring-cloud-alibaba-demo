package com.example.streamrocketmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 15:30
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@Component
public class CustomRunner implements CommandLineRunner {


    private  String bindingName="output1";

   /* public CustomRunner(String bindingName) {
        this.bindingName = bindingName;
    }*/

    @Autowired
    private SenderService senderService;

    @Autowired
    private MySource mySource;

    @Override
    public void run(String... args) throws Exception {
        if (this.bindingName.equals("output1")) {
            int count = 5;
            for (int index = 1; index <= count; index++) {
                String msgContent = "msg-" + index;
                if (index % 3 == 0) {
                    senderService.send(msgContent);
                }
                else if (index % 3 == 1) {
                    senderService.sendWithTags(msgContent, "tagStr");
                }
                else {
                    senderService.sendObject(new Foo(index, "foo"), "tagObj");
                }
            }
        }
//        else if (this.bindingName.equals("output3")) {
        bindingName="output3";
            int count = 10;
            for (int index = 1; index <= count; index++) {
                String msgContent = "pullMsg-" + index;
                mySource.output3()
                        .send(MessageBuilder.withPayload(msgContent).build());
            }

        bindingName="output5";
         count = 10;
        for (int index = 1; index <= count; index++) {
            String msgContent = "pullMsg-" + index;
            mySource.output5()
                    .send(MessageBuilder.withPayload(msgContent).build());
        }
//        }

    }

}
