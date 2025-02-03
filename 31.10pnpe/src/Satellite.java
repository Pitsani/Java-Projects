public class Satellite extends SpaceObject implements Orbiter{
    public Satellite(String name, int coordinateX, int coordinateY, int coordinateZ, double mass) {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
    }

    @Override
    public void orbit(SpaceObject target) throws NotValidSpaceObjectException {

    }

    public void displayInfo() {
        System.out.println("Satellite: " + name);
        System.out.printf("Coordinates: %d  :  %d  :  %d\n", coordinateX, coordinateY, coordinateZ);
        System.out.println("Mass: " + mass);
    }
}
