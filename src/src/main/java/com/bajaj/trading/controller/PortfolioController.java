package com.bajaj.trading.controller;

import com.bajaj.trading.model.Holding;
import com.bajaj.trading.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    private final OrderService service;

    public PortfolioController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Holding> portfolio() {
        return service.getPortfolio();
    }
}
