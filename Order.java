public class Order {
    private String clOrdID;
    private String symbol;
    private char side;
    private double price;
    private double quantity;

    public Order(String id, String sym, char s, double p, double q) {
        this.clOrdID = id;
        this.symbol = sym;
        this.side = s;
        this.price = p;
        this.quantity = q;
    }

    public void reduceQty(double q) {
        this.quantity -= q;
    }

    public double getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public char getSide() { return side; }
    public String getSymbol() { return symbol; }
    public String getClOrdID() { return clOrdID; }
}