package kz.aa.store.rabbit.orders;

import kz.aa.store.orders.model.dto.OrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "ORDERS")
public class OrderReceiver {

    @RabbitHandler
    public void process(OrderDto order) {
        System.out.println(order);
    }
}
