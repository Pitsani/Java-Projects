public abstract class BaseBuilding{
    protected String name;
    protected int level;
    protected double constructionTime;
    protected double gasRequired;
    protected double metalRequired;
    protected double crystalRequired;
    protected double uraniumRequired;

    public BaseBuilding(String name, int level, double constructionTime, double gasRequired, double metalRequired, double crystalRequired, double uraniumRequired) {
        this.name=name;
        this.level = level;
        this.constructionTime = constructionTime;
        this.gasRequired=gasRequired;
        this.metalRequired=metalRequired;
        this.crystalRequired=crystalRequired;
        this.uraniumRequired=uraniumRequired;
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public double getConstructionTime(){
        return constructionTime;
    }

    public double getGasRequired(){
        return gasRequired;
    }

    public double getMetalRequired(){
        return metalRequired;
    }

    public double getCrystalRequired(){
        return crystalRequired;
    }

    public double getUraniumRequired(){
        return uraniumRequired;
    }

    public void construct(Planet target){

    }

    public void upgrade(){

    }

    public void applyEffect(){

    }
}
