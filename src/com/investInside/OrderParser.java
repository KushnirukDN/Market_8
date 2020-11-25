package com.investInside;

import java.util.TreeMap;

public class OrderParser {
    static TreeMap<Integer, Order> bookA = new TreeMap<>();
    static TreeMap<Integer, Order> bookB = new TreeMap<>();

    public static String[] createOrderArray (String unit)  {
        return unit.split(",");
    }

    public static void writeToAsk (String[] array) {
        int price = Integer.parseInt(array[1]);
        int size = Integer.parseInt(array[2]);

        //checkBookB(price);

        if (bookA.containsKey(price)) {
            bookA.get(price).setSize(size);
        } else {
            bookA.put(Integer.parseInt(array[1]),
                    new Order(array[1], array[2], array[3]));
        }
    }

    public static void writeToBid (String[] array) {
        int price = Integer.parseInt(array[1]);
        int size = Integer.parseInt(array[2]);

       // checkBookA(price);

        if (bookB.containsKey(price)) {
            bookB.get(price).setSize(size);
        } else {
            bookB.put(Integer.parseInt(array[1]),
                    new Order(array[1], array[2], array[3]));
        }
    }

    public static boolean defineType (String[] array) {
        boolean ifAsk = false;
        if (array[3].equals("ask")) {
            ifAsk = true;
        }
        return ifAsk;
    }

    public static void checkBookA(int price) {
        if (bookA.containsKey(price)) {
            bookA.remove(price);
        }
    }

    public static void checkBookB(int price) {
        if (bookB.containsKey(price)) {
            bookB.remove(price);
        }
    }
}
