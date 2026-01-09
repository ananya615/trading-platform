package com.bajaj.trading.controller;

import com.bajaj.trading.dto.OrderRequest;
import com.bajaj.trading.model.Order;
import com.bajaj.trading.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order place(@RequestBody OrderRequest req) {
        return service.placeOrder(req);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable String id) {
        return service.getOrder(id);
    }
}
