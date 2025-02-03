public abstract class SpaceObject {
    String name;
    int coordinateX;
    int coordinateY;
    int coordinateZ;
    double mass;

    public abstract void displayInfo();

    public SpaceObject(String name, int coordinateX, int coordinateY, int coordinateZ, double mass) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
        this.mass = mass;
    }
}
