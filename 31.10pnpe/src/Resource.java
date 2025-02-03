public class Resource {
    int amount;
    double harvestRate;
    public Resource(int amount, double harvestRate){
        this.amount = amount;
        this.harvestRate = harvestRate;
    }
    public double harvest(){
        return amount-= (amount * harvestRate);
    }
}
