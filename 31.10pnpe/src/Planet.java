import java.util.ArrayList;
import java.util.List;

public class Planet extends OrbitableSpaceObject implements Orbiter{
    Resource metal;
    Resource gas;
    Resource crystal;
    Resource uranium;
    private List<BaseBuilding> buildings;
    public Planet(String name, int coordinateX, int coordinateY, int coordinateZ, double mass) {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
        this.metal = new Resource(metal.amount, 1.0);
        this.gas = new Resource(gas.amount,0.5);
        this.crystal = new Resource(crystal.amount, 0.2);
        this.uranium = new Resource(uranium.amount, 0.1);
        this.buildings = new ArrayList<>();
    }

    public void displayInfo() {
        System.out.println("Planet: " + name);
    }

    @Override
    public void orbit(SpaceObject target) throws NotValidSpaceObjectException {

    }

    void harvestMetal() {

    }

    void harvestGas() {

    }

    void harvestCrystal() {

    }

    void harvestUranium() {

    }

    void listOfBuildings(){

    }



}

