public class Triangle extends Figure {
    double h;

    public Triangle(double side, double h) {
        super(side);
        this.h = h;
    }

    public double area() {
        return side * h / 2;
    }

}
