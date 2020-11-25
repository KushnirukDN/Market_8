package com.investInside;

import java.io.IOException;
import java.util.TreeMap;

public class OrderParser {
    static TreeMap<Integer, Order> bookA = new TreeMap<>();
    static TreeMap<Integer, Order> bookB = new TreeMap<>();

    public static String[] createOrderArray (String unit)  {
        String[] array = unit.split(",");
        return array;
    }

    public static void writeToAsk (String[] array) {
        bookA.put(Integer.parseInt(array[1]),
                new Order(array[1], array[2], array[3]));
    }

    public static void writeToBid (String[] array) {
        bookB.put(Integer.parseInt(array[1]),
                new Order(array[1], array[2], array[3]));
    }

    public static boolean defineType (String[] array) {
        boolean ifAsk = false;
        if (array[3].equals("ask")) {
            ifAsk = true;
        }
        return ifAsk;
    }
}
