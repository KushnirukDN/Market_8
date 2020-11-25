package com.investInside;


import java.io.IOException;

public class Solve {
    public static void solve (String[] units) throws IOException {

        for (String str : units) {
           String[] array = OrderParser.createOrderArray(str);

           switch (array[0]) {
               case("u"):
                   if (OrderParser.defineType(array)) {
                       OrderParser.writeToAsk(array);
                   } else {
                       OrderParser.writeToBid(array);
                   }
                   break;

               case("q"):
                   if (array[1].equals("best_bid")) {
                       Query.bestBid(OrderParser.bookB);
                   } else if (array[1].equals("best_ask")) {
                       Query.bestAsk(OrderParser.bookA);
                   } else {
                       Query.sizePrice(OrderParser.bookA, OrderParser.bookB, Integer.parseInt(array[2]));
                   }
                   break;

               case("o"):

                   if (array[1].equals("buy")) {
                       Order updatedOrder = Query.buy(OrderParser.bookA, Integer.parseInt(array[2]));
                       OrderParser.bookA.put(updatedOrder.getPrice(), updatedOrder);
                   } else {
                       Order updatedOrder = Query.sell(OrderParser.bookB, Integer.parseInt(array[2]));
                       OrderParser.bookB.put(updatedOrder.getPrice(), updatedOrder);
                   }

                   break;
               default:
                   System.out.println("какая-то лажа");
           }
        }
    }
}
