package com.bajaj.trading.controller;

import com.bajaj.trading.model.Trade;
import com.bajaj.trading.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {

    private final OrderService service;

    public TradeController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trade> trades() {
        return service.getTrades();
    }
}
