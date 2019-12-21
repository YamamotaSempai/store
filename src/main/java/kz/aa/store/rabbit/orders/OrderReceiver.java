package kz.aa.store.rabbit.orders;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "orders")
public class OrderReceiver {
    @RabbitHandler
    public void process(String order) {
        System.out.println(order);
    }
}
