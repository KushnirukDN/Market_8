package com.investInside;

import java.util.TreeMap;

public class UpdateBooks {

    static final TreeMap<Integer, Order> bookOfAsk = new TreeMap<>();
    static final TreeMap<Integer, Order> bookOfBid = new TreeMap<>();

    public void writeToAsk(Order order) {
        if (bookOfAsk.containsKey(order.getPrice())) {
            bookOfAsk.get(order.getPrice()).setSize(order.getSize());
        } else {
            bookOfAsk.put(order.getPrice(), order);
        }
    }

    public void writeToBid(Order order) {
        if (bookOfBid.containsKey(order.getPrice())) {
            bookOfBid.get(order.getPrice()).setSize(order.getSize());
        } else {
            bookOfBid.put(order.getPrice(), order);
        }
    }
}
