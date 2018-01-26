package net.northking.cloudplatform.config;

import net.northking.cloudplatform.constants.MQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
@Configuration
public class FanoutRabbitConfig {

        /**
         * 批次业务相关交换器以及队列
         */
        //创建Fanout交换器
        @Bean
        FanoutExchange batchExchange() {
        return new FanoutExchange(MQConstants.batchExchangeP);
    }
        //创建队列
        @Bean
        public Queue batchQueue() {
            return new Queue(MQConstants.batchQueueP);
        }

        //将对列绑定到batchExchange交换器
        @Bean
        Binding bindingExchangeA(Queue batchQueue, FanoutExchange batchExchange) {
            return BindingBuilder.bind(batchQueue).to(batchExchange);
        }
    //---------------------------------------------------------------------------------

        /**
         * 顾客业务相关交换器以及队列
         */
        @Bean
        FanoutExchange customerExchange() {//用于云平台和客户端客户信息同步的交换机
            return new FanoutExchange(MQConstants.customerExchangeP);
        }

        @Bean
        public Queue customerQueue() { //用于云平台和客户端客户信息同步的队列
            return new Queue(MQConstants.customerQueueP);
        }


        //将对列绑定到customerExchange交换器
        @Bean
         Binding bindingExchangeC(Queue customerQueue, FanoutExchange customerExchange) {
            return BindingBuilder.bind(customerQueue).to(customerExchange);
        }
}
