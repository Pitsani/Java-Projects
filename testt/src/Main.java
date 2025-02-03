public class Main {
    public static void main(String[] args) {
        StockTicker stocks = new StockTicker();
        stocks.addStock("Bitcoin", 150.0);
        stocks.addStock("Dogecoin", 190.0);
        stocks.updateStock("Dogecoin", 145.0);
        System.out.println(stocks.getFirst("Bitcoin"));
        System.out.println(stocks.getLast("Dgecoin"));
    }
}