import java.util.*;
import java.util.concurrent.*;

public class OrderBook {

    private NavigableMap<Double, List<Order>> bids =
            new ConcurrentSkipListMap<>(Collections.reverseOrder());

    private NavigableMap<Double, List<Order>> asks =
            new ConcurrentSkipListMap<>();

    public synchronized List<Execution> match(Order incoming) {
        List<Execution> trades = new ArrayList<>();

        if (incoming.getSide() == '1') {
            matchOrder(incoming, asks, trades);
        } else {
            matchOrder(incoming, bids, trades);
        }

        if (incoming.getQuantity() > 0) {
            add(incoming);
        }

        return trades;
    }

    private void add(Order o) {
        NavigableMap<Double, List<Order>> side =
                (o.getSide() == '1') ? bids : asks;

        side.computeIfAbsent(o.getPrice(), k -> new LinkedList<>()).add(o);
    }

    private void matchOrder(Order incoming,
                            NavigableMap<Double, List<Order>> opposite,
                            List<Execution> trades) {

        while (incoming.getQuantity() > 0 && !opposite.isEmpty()) {

            double bestPrice = opposite.firstKey();

            if (incoming.getSide() == '1' && incoming.getPrice() < bestPrice) break;
            if (incoming.getSide() == '2' && incoming.getPrice() > bestPrice) break;

            List<Order> list = opposite.get(bestPrice);
            Order resting = list.get(0);

            double qty = Math.min(incoming.getQuantity(), resting.getQuantity());

            trades.add(new Execution(incoming, resting, qty, bestPrice));

            incoming.reduceQty(qty);
            resting.reduceQty(qty);

            if (resting.getQuantity() == 0) {
                list.remove(0);
                if (list.isEmpty()) opposite.remove(bestPrice);
            }
        }
    }
}