package kz.aa.store.rabbit.orders;

import kz.aa.store.orders.model.dto.OrderDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
    private final AmqpTemplate rabbitTemplate;

    public OrderSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(OrderDto orderDto) {
        this.rabbitTemplate.convertAndSend("ORDERS", orderDto);
    }
}
