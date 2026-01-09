package com.bajaj.trading.dto;

import com.bajaj.trading.model.enums.*;

public class OrderRequest {
    public String symbol;
    public OrderType orderType;
    public OrderStyle orderStyle;
    public int quantity;
    public Double price;
}
