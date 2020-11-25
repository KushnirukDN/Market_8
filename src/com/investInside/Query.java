package com.investInside;

import java.io.IOException;
import java.util.TreeMap;

public class Query {
    public static void bestBid(TreeMap<Integer, Order> orders) throws IOException {
        int count = 0;
        int size = orders.get(orders.lastKey() - count).getSize();
        if (size == 0) {
            while (size == 0) {
                count++;
                size = orders.get(orders.lastKey() - count).getSize();
            }
        }
        ReadWrite.writeResult(orders.get(orders.lastKey() - count).toString());
    }

    public static void bestAsk(TreeMap<Integer, Order> orders) throws IOException {
        int count = 0;
        int size = orders.get(orders.firstKey() + count).getSize();
        if (size == 0) {
            while (size == 0) {
                count++;
                size = orders.get(orders.firstKey() + count).getSize();
            }
        }
        ReadWrite.writeResult(orders.get(orders.firstKey() + count).toString());
    }

    public static void sizePrice(TreeMap<Integer, Order> bookA, TreeMap<Integer, Order> bookB, int price) throws IOException {
        if (bookA.containsKey(price)) {
            ReadWrite.writeResult(bookA.get(price).getSize() + "\n");
        } else if (bookB.containsKey(price)) {
            ReadWrite.writeResult(bookB.get(price).getSize() + "\n");
        } else {
            ReadWrite.writeResult("0\n");
        }
    }

    public static Order buy(TreeMap<Integer, Order> orders, int shares){
        int count = 0;
        int size = orders.get(orders.firstKey() + count).getSize();
        if (size == 0) {
            while (size == 0) {
                count++;
                size = orders.get(orders.firstKey() + count).getSize();
            }
        }
        Order tempOrder = orders.get(orders.firstKey() + count);
        tempOrder.setSize(tempOrder.getSize() - shares);
        return tempOrder;
    }

    public static Order sell(TreeMap<Integer, Order> orders, int shares) {
        int count = 0;
        int size = orders.get(orders.lastKey() - count).getSize();
        if (size == 0) {
            while (size == 0) {
                count++;
                size = orders.get(orders.lastKey() - count).getSize();
            }
        }
        Order tempOrder = orders.get(orders.lastKey() - count);
        tempOrder.setSize(tempOrder.getSize() - shares);
        return tempOrder;
    }
}