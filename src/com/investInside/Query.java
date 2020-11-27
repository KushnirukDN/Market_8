package com.investInside;

public class Query {
    public static Order bestBid() {
        int size = UpdateBooks.bookOfBid.get(UpdateBooks.bookOfBid.lastKey()).getSize();
        while(size == 0) {
            UpdateBooks.bookOfBid.remove(UpdateBooks.bookOfBid.lastKey());
            size = UpdateBooks.bookOfBid.get(UpdateBooks.bookOfBid.lastKey()).getSize();
        }
        return UpdateBooks.bookOfBid.get(UpdateBooks.bookOfBid.lastKey());
    }

    public static Order bestAsk()  {
       int size = UpdateBooks.bookOfAsk.get(UpdateBooks.bookOfAsk.firstKey()).getSize();

        while(size == 0) {
            UpdateBooks.bookOfAsk.remove(UpdateBooks.bookOfAsk.firstKey());
            size = UpdateBooks.bookOfAsk.get(UpdateBooks.bookOfAsk.lastKey()).getSize();
        }
        return UpdateBooks.bookOfAsk.get(UpdateBooks.bookOfAsk.firstKey());
    }

    public static void sizePrice(int price) {
        if (UpdateBooks.bookOfAsk.containsKey(price)) {
            ReadWrite.writeOutput(UpdateBooks.bookOfAsk.get(price).toString(UpdateBooks.bookOfAsk.get(price).getSize()));
        } else if (UpdateBooks.bookOfBid.containsKey(price)) {
            ReadWrite.writeOutput(UpdateBooks.bookOfBid.get(price).toString(UpdateBooks.bookOfBid.get(price).getSize()));
        } else {
            if (price < bestAsk().getPrice() && price > bestBid().getPrice()) {
                ReadWrite.writeZeroResult();
            }
        }
    }
}