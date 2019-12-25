package com.example.streamrocketmqproducer;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 15:24
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@RocketMQTransactionListener(txProducerGroup = "myTxProducerGroup", corePoolSize = 5,
        maximumPoolSize = 10)
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg,
                                                                 Object arg) {
        Object num = msg.getHeaders().get("test");

        if ("1".equals(num)) {
            System.out.println(
                    "executer: " + new String((byte[]) msg.getPayload()) + " unknown");
            return RocketMQLocalTransactionState.UNKNOWN;
        } else if ("2".equals(num)) {
            System.out.println(
                    "executer: " + new String((byte[]) msg.getPayload()) + " rollback");
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        System.out.println(
                "executer: " + new String((byte[]) msg.getPayload()) + " commit");
        return RocketMQLocalTransactionState.COMMIT;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        System.out.println("check: " + new String((byte[]) msg.getPayload()));
        return RocketMQLocalTransactionState.COMMIT;
    }
}
