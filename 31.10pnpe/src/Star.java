public class Star extends OrbitableSpaceObject{
    public Star(String name, int coordinateX, int coordinateY, int coordinateZ, double mass) {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
    }

    public void displayInfo() {
        System.out.println("Star: " + name);
        System.out.printf("Coordinates: %d  :  %d  :  %d\n", coordinateX, coordinateY, coordinateZ);
        System.out.println("Mass: " + mass);
    }
}
