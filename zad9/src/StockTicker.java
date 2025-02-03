import java.util.ArrayList;
import java.util.HashMap;

public class StockTicker {
    private final HashMap<String, ArrayList<Double>> listOfStocks;

    public StockTicker() {
        listOfStocks = new HashMap<>();
    }

    public void addStock(String stockName, Double price) {
        if (!listOfStocks.containsKey(stockName)) {
            ArrayList<Double> prices = new ArrayList<>();
            prices.add(price);
            listOfStocks.put(stockName, prices);
        } else {
            updatePrice(stockName, price);
        }
    }
    public void updatePrice(String stockName, double price) {
        if (listOfStocks.containsKey(stockName)) {
            listOfStocks.get(stockName).add(price);
        } else {
            System.out.println("Stock does not exist!");
        }
    }

    public double getLastPrice(String stockName) throws IllegalArgument {
        if (listOfStocks.containsKey(stockName)) {
            ArrayList<Double> prices = listOfStocks.get(stockName);
            return prices.getLast();
        } else {
            throw new IllegalArgument("Stock doesn't exist!");
        }
    }

    public double getInitialPrice(String stockName) throws IllegalArgument {
        if (listOfStocks.containsKey(stockName)) {
            ArrayList<Double> prices = listOfStocks.get(stockName);
            return prices.getFirst();
        } else {
            throw new IllegalArgument("Stock does not exist!");
        }
    }
}

