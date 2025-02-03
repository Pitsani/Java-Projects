public class Main {
    public static void main(String[] args) throws IllegalArgument {
        StockTicker ticker = new StockTicker();
        ticker.addStock("Bitcoin", 150.0);

        System.out.println("First Price of Bitcoin: " + ticker.getInitialPrice("Bitcoin"));

        ticker.updatePrice("Bitcoin", 160.0);
        ticker.addStock("Bitcoin", 159.0);
        System.out.println("Last price of Bitcoin: " + ticker.getLastPrice("Bitcoin"));

        ticker.addStock("GOOG", 2000.0);
        System.out.println("First Price of GOOG: " + ticker.getInitialPrice("GOOG"));
        ticker.addStock("GOOG", 20099.0);
        System.out.println("First Price of GOOG: " + ticker.getLastPrice("GOOG"));

        System.out.println("Last price of MSFT: " + ticker.getLastPrice("MSFT"));

    }
}