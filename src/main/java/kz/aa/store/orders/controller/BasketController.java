package kz.aa.store.orders.controller;

import kz.aa.store.orders.model.dto.OrderItemDto;
import kz.aa.store.orders.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("basket")
public class BasketController {
    private final BasketService basketService;
    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;;
    }

    @PostMapping
    public ResponseEntity<?> addInBasket(@RequestBody @Valid OrderItemDto orderItem) {
        return ResponseEntity.ok(basketService.addIntoBasket(orderItem));
    }

    @GetMapping
    public ResponseEntity<?> getAllByUsername() {
        return ResponseEntity.ok(basketService.getAllByUsername());
    }
}
