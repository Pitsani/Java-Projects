interface Area {
    double area();
}

public abstract class Figure implements Area {
    double side;

    public Figure(double side) {
        this.side = side;
    }
}
