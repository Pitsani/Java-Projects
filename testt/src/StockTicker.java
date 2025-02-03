import java.util.ArrayList;
import java.util.HashMap;

public class StockTicker {
    protected HashMap<String, ArrayList<Double>> stockInfo;

    public StockTicker() {
        this.stockInfo = new HashMap<>();
    }

    public void addStock(String name, Double price){
        if(!stockInfo.containsKey(name)){
            ArrayList<Double> prices = new ArrayList<>();
            prices.add(price);
            stockInfo.put(name, prices);
        }
        else{
            updateStock(name, price);
        }
    }

    public void updateStock(String name, double price){
        if(stockInfo.containsKey(name)){
            stockInfo.get(name).add(price);
        }
        else{
            System.out.println("No such name of stock");
        }
    }

    public double getFirst(String name){
        if(stockInfo.containsKey(name)){
            ArrayList<Double> prices = stockInfo.get(name);
            return prices.getFirst();
        }
        else{
            throw new IllegalArgumentException("Stock does not exist!");
        }
    }

    public double getLast(String name){
        if(stockInfo.containsKey(name)){
            ArrayList<Double> prices = stockInfo.get(name);
            return prices.getLast();
        }
        else{
            throw new IllegalArgumentException("Stock does not exist!");
        }
    }
}
