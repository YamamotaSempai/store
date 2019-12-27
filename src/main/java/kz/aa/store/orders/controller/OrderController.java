package kz.aa.store.orders.controller;

import kz.aa.store.orders.model.dto.OrderDto;
import kz.aa.store.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrdersService ordersService;

    @Autowired
    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<?> getOrdersByUser(Principal principal, Pageable pageable) {
        return ResponseEntity.ok(ordersService.getAllOrdersByUser(principal.getName(), pageable));
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderDto orderDto,
                                         Principal principal) {
        return ResponseEntity.ok(ordersService.saveOrder(orderDto, "test"));
    }
}
