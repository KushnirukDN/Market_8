package com.investInside;

public class MarketOder {

    public void buy(int shares){
        int bestBidSize = Query.bestAsk().getSize();

        if (shares > bestBidSize) {
            for (Integer key : UpdateBooks.bookOfAsk.keySet()) {
                shares = UpdateBooks.bookOfAsk.get(key).getSize() - shares;
                if (shares < 0) {
                    UpdateBooks.bookOfAsk.get(key).setSize(0);
                    shares = Math.abs(shares);
                } else {
                    UpdateBooks.bookOfAsk.get(key).setSize(shares);
                }
            }
        } else {
            Order orderUpdate = UpdateBooks.bookOfAsk.get(UpdateBooks.bookOfAsk.lastKey());
            orderUpdate.setSize(bestBidSize - shares);
        }
    }


    public void sell(int shares) {
        int bestBidSize = Query.bestBid().getSize();

        if (shares > bestBidSize) {
            for (Integer key : UpdateBooks.bookOfBid.descendingKeySet()) {
                shares = UpdateBooks.bookOfBid.get(key).getSize() - shares;
                if (shares < 0) {
                    UpdateBooks.bookOfBid.get(key).setSize(0);
                    shares = Math.abs(shares);
                } else {
                    UpdateBooks.bookOfBid.get(key).setSize(shares);
                }
            }
            } else {
                Order orderUpdate = UpdateBooks.bookOfBid.get(UpdateBooks.bookOfBid.lastKey());
                orderUpdate.setSize(bestBidSize - shares);
            }
        }
}
