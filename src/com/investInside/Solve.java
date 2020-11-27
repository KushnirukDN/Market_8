package com.investInside;

public class Solve {
    private final UpdateBooks updateBooks;
    private final ReadWrite readWrite;
    private final Query query;
    private final MarketOder marketOder;

    public Solve(UpdateBooks updateBooks, ReadWrite readWrite, Query query, MarketOder marketOder) {
        this.updateBooks = updateBooks;
        this.readWrite = readWrite;
        this.query = query;
        this.marketOder = marketOder;
    }

    public void solving(String[] inputsList) {
        for (String inputItem : inputsList) {
            String[] tempArray = inputItem.split(",");//Массив из строки разделенный по запятым, для парсинга и создания Order
            Order order = new Order();

            order.setOperationType(tempArray[0]); //определения типа операции, от него зависит как именно собирается объект Order

            switch (order.getOperationType()) {
                case UPDATE:
                    order.setPrice(Integer.parseInt(tempArray[1]));
                    order.setSize(Integer.parseInt(tempArray[2]));
                    order.setOrderType(tempArray[3]);
                    processUpdate(order);
                    break;
                case QUERY:
                    order.setOrderType(tempArray[1]);
                    switch (order.getOrderType()) {
                        case SIZE:
                            order.setPrice(Integer.parseInt(tempArray[2]));
                            break;
                        default:
                            break;
                    }
                    processQuery(order);
                    break;
                case MARKET_ORDER:
                    order.setOrderType(tempArray[1]);
                    order.setSize(Integer.parseInt(tempArray[2]));
                    processMarketOrder(order, order.getSize());
                    break;
                default:
                    break;
            }
        }
    }

    public void processUpdate(Order order) {
        switch (order.getOrderType()) {
            case ASK:
                updateBooks.writeToAsk(order);
                break;
            case BID:
                updateBooks.writeToBid(order);
                break;
            default:
                break;
        }
    }

    private void processQuery(Order order)  {
            switch (order.getOrderType()) {
                case BEST_ASK:
                    readWrite.writeOutput(query.bestAsk().toString());
                    break;
                case BEST_BID:
                    readWrite.writeOutput(query.bestBid().toString());
                    break;
                case SIZE:
                    query.sizePrice(order.getPrice());
                    break;
                default:
                    break;
            }
        }

    private void processMarketOrder(Order order, int shares) {
        switch (order.getOrderType()) {
            case SELL:
                marketOder.sell(shares);
                break;
            case BUY:
                marketOder.buy(shares);
                break;
            default:
                break;
        }
    }
}
