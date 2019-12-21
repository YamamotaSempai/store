package kz.aa.store.rabbit.orders;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderSender {
    private final AmqpTemplate rabbitTemplate;

    public OrderSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        String context = "hello " + LocalDateTime.now();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
