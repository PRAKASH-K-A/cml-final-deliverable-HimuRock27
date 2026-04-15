import java.util.concurrent.*;

public class OrderPersister implements Runnable {

    private BlockingQueue<Order> queue;

    public OrderPersister(BlockingQueue<Order> q) {
        this.queue = q;
    }

    public void run() {
        while (true) {
            try {
                Order o = queue.take();
                DatabaseManager.insertOrder(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}