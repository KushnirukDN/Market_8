package com.investInside;

import java.io.IOException;
import java.util.TreeMap;

public class Solve {
    static TreeMap<Integer, Order> bookA = new TreeMap<>();
    static TreeMap<Integer, Order> bookB = new TreeMap<>();

    public static void solve (String[] units) throws IOException {
        for (String str : units) {
            String[] forObjectCreating = str.split(",");

            if (forObjectCreating.length == 4) {
                if (forObjectCreating[3].equals("ask")) {
                    bookA.put(Integer.parseInt(forObjectCreating[1]),
                            new Order(forObjectCreating[1], forObjectCreating[2], forObjectCreating[3]));
                } else {
                    bookB.put(Integer.parseInt(forObjectCreating[1]),
                            new Order(forObjectCreating[1], forObjectCreating[2], forObjectCreating[3]));
                }
            } else {
                if (forObjectCreating[0].equals("q")) {
                    if (forObjectCreating[1].equals("best_bid")) {
                        Query.bestBid(bookB);
                    } else if (forObjectCreating[1].equals("best_ask")) {
                        Query.bestAsk(bookA);
                    } else {
                        Query.sizePrice(bookA, bookB, Integer.parseInt(forObjectCreating[2]));
                    }
                } else {
                    if (forObjectCreating[1].equals("buy")) {
                        Order updatedOrder = Query.buy(bookA, Integer.parseInt(forObjectCreating[2]));
                        bookA.put(updatedOrder.getPrice(), updatedOrder);
                    } else {
                        Order updatedOrder = Query.sell(bookB, Integer.parseInt(forObjectCreating[2]));
                        bookB.put(updatedOrder.getPrice(), updatedOrder);
                    }
                }
            }
        }
    }
}
