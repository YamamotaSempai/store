package kz.aa.store.orders.service;

import kz.aa.store.orders.model.Order;
import kz.aa.store.orders.model.dto.OrderDto;
import kz.aa.store.orders.repository.OrderJdbcRepository;
import kz.aa.store.rabbit.orders.OrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    private final OrderJdbcRepository orderJdbcRepository;
    private final OrderSender orderSender;
    private final BasketService basketService;

    @Autowired
    public OrdersService(OrderJdbcRepository orderJdbcRepository, OrderSender orderSender, BasketService basketService) {
        this.orderJdbcRepository = orderJdbcRepository;
        this.orderSender = orderSender;
        this.basketService = basketService;
    }

    public Page<Order> getAllOrdersByUser(String username, Pageable pageable) {
        List<Order> content = new ArrayList<>();
        long count = orderJdbcRepository.getCountOrdersByUser(username);
        if (count == 0)
            content = orderJdbcRepository.getAllOrdersByUser(username, pageable);
        return new PageImpl<>(content, pageable, count);
    }

    public OrderDto createOrder(OrderDto orderDto, String username) {
        Long id = preSaveOrder(username);
        orderDto.setOrderId(id);
        orderSender.send(orderDto);
        basketService.resetBasket(username);
        return orderDto;
    }

    private Long preSaveOrder(String username) {
        return orderJdbcRepository.preSave(username);
    }
}
