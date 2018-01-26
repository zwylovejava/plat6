package net.northking.cloudplatform.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
@Component
public class FanoutSender {
    /**
     * exchange:交换机名称
     * message：消息内容
     */
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String exchange,String message) {
        String context = message;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(exchange,"", context);
    }
}
