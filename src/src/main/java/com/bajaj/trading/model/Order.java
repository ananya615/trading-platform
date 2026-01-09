package com.bajaj.trading.model;

import com.bajaj.trading.model.enums.*;

public class Order {
    public String orderId;
    public String symbol;
    public OrderType orderType;
    public OrderStyle orderStyle;
    public int quantity;
    public Double price;
    public OrderStatus status;
}
