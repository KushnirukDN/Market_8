package com.investInside;

import java.io.Serializable;

public class Order implements Serializable {
    private OperationType operationType;
    private int price;
    private int size;
    OrderType orderType;

    public Order() {
    }

    public Order(OperationType operationType, String price, String size, OrderType orderType) {
        this.operationType = operationType;
        this.price = Integer.parseInt(price);
        this.size = Integer.parseInt(size);
        this.orderType = orderType;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        if(operationType.equals("u")) {
           this.operationType = OperationType.UPDATE;
        } else if(operationType.equals("q")) {
            this.operationType = OperationType.QUERY;
        } else if(operationType.equals("o")) {
            this.operationType = OperationType.MARKET_ORDER;
        }
    }


    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setOrderType(String type) {
        if (type.equals("ask")) {
            this.orderType = OrderType.ASK;
        } else if (type.equals("bid")) {
            this.orderType = OrderType.BID;
        } else if (type.equals("best_ask")) {
            this.orderType = OrderType.BEST_ASK;
        } else if (type.equals("best_bid")) {
            this.orderType = OrderType.BEST_BID;
        } else if (type.equals("size")) {
            this.orderType = OrderType.SIZE;
        } else if (type.equals("sell")) {
            this.orderType = OrderType.SELL;
        } else if (type.equals("buy")) {
            this.orderType = OrderType.BUY;
        }
    }

    @Override
    public String toString() {
        return  price +
                "," + size +
                "\n";
    }

    public String toString(int size) {
        return  size +
                "\n";
    }
}