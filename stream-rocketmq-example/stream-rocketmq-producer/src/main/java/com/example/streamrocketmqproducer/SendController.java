package com.example.streamrocketmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 16:56
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    SenderService senderService;

    @RequestMapping("/str")
    public String sendStr(@RequestParam  String msg) throws Exception {
        senderService.send(msg);
        return "发送成功";
    }

    @RequestMapping("/foo")
    public String sendFoo(@RequestParam Integer id,String bar) throws Exception {
        Foo foo = new Foo();
        foo.setId(id);
        foo.setBar(bar);
        senderService.sendObject(foo,"tag-11111");
        return "发送成功";
    }


    @RequestMapping("/ibound")
    @InboundChannelAdapter("output1")
    public String inboundChannel() {
        return "Inbounds - hello world " + System.currentTimeMillis();
    }
}
