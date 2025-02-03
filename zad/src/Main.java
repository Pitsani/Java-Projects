import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        double a, b, h;
        do {
            System.out.println("Enter a number of a figure:");
            System.out.println("1.Square    2.Rectangle    3.Triangle   4. Circle   5.Exit");
            num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Enter side of a square: ");
                    a = scan.nextDouble();
                    Figure sq1 = new Square(a);
                    System.out.printf("Area of square: %f\n", sq1.area());
                    break;
                case 2:
                    System.out.println("Enter side 'a' of rectangle: ");
                    a = scan.nextDouble();
                    System.out.println("Enter side 'b' of rectangle: ");
                    b = scan.nextDouble();
                    Figure rec1 = new Rectangle(a, b);
                    System.out.printf("Area of rectangle: %f\n", rec1.area());
                    break;
                case 3:
                    System.out.println("Enter side 'a' of triangle: ");
                    a = scan.nextDouble();
                    System.out.println("Enter height of triangle: ");
                    h = scan.nextDouble();
                    Figure tri1 = new Triangle(a, h);
                    System.out.printf("Area of triangle: %f\n", tri1.area());
                    break;
                case 4:
                    System.out.println("Enter radius of circle: ");
                    double radius = scan.nextDouble();
                    Circle cir1 = new Circle(radius);
                    System.out.printf("Area of circle: %f\n", cir1.area());
                case 5:
                    break;

                default:
                    System.out.println("Enter a valid number of a figure!");
                    break;
            }
        }
        while (num != 4);
        scan.close();
    }
}
