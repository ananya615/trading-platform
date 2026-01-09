package com.bajaj.trading.service;

import com.bajaj.trading.dto.OrderRequest;
import com.bajaj.trading.model.*;
import com.bajaj.trading.model.enums.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final Map<String, Order> orders = new HashMap<>();
    private final List<Trade> trades = new ArrayList<>();
    private final Map<String, Holding> portfolio = new HashMap<>();

    public Order placeOrder(OrderRequest req) {
        if (req.quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");

        if (req.orderStyle == OrderStyle.LIMIT && req.price == null)
            throw new IllegalArgumentException("Price is mandatory for LIMIT order");

        Order order = new Order();
        order.orderId = UUID.randomUUID().toString();
        order.symbol = req.symbol;
        order.orderType = req.orderType;
        order.orderStyle = req.orderStyle;
        order.quantity = req.quantity;
        order.price = req.price;
        order.status = OrderStatus.EXECUTED;

        executeTrade(order);
        orders.put(order.orderId, order);
        return order;
    }

    private void executeTrade(Order order) {
        Trade trade = new Trade();
        trade.tradeId = UUID.randomUUID().toString();
        trade.orderId = order.orderId;
        trade.symbol = order.symbol;
        trade.quantity = order.quantity;
        trade.price = order.price != null ? order.price : 3650.50;
        trades.add(trade);

        Holding h = portfolio.getOrDefault(order.symbol, new Holding());
        h.symbol = order.symbol;
        h.quantity += order.quantity;
        h.averagePrice = trade.price;
        h.currentValue = h.quantity * 3650.50;
        portfolio.put(order.symbol, h);
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public Collection<Holding> getPortfolio() {
        return portfolio.values();
    }
}
