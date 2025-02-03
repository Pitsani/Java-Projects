public class Rectangle extends Figure {
    double side2;

    public Rectangle(double side, double side2) {
        super(side);
        this.side2 = side2;
    }

    public double area() {
        return side * side2;
    }
}
