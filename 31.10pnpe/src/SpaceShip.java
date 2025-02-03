public class SpaceShip extends SpaceObject implements Fly{
    String type;
    double speed;
    double cargoCapacity;
    double weaponPower;

    public SpaceShip(String name, String type, double mass, int coordinatesX, int coordinatesY, int coordinatesZ, double speed, double cargoCapacity, double weaponPower) {
        super(name, coordinatesX,coordinatesY, coordinatesZ, mass);
        this.type = type;
        this.speed = speed;
        this.cargoCapacity = cargoCapacity;
        this.weaponPower = weaponPower;
    }

    public void displayInfo(){
        System.out.println("SpaceShip: " + name + ", Type: " + type);
    }

    public void flyTo(SpaceObject destination) {
        System.out.println(name + " is flying to " + destination.name);
    }

    public void travel() {

    }

    public void harvestResource(Planet target, Resource resource) {
        double harvestedAmount = resource.harvest();
        System.out.println("Harvested " + harvestedAmount + " from " + target.name);
    }

    public void attack(SpaceShip enemy) {
        System.out.println(name + " is attacking " + enemy.name);
    }
}

