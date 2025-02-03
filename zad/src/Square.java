public class Square extends Figure {
    public Square(double side) {
        super(side);
    }

    public double area() {
        return side * side;
    }
}
