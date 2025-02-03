 class Calculator {

    public int add(int a, int b) {
        return a + b;
    }


    public void greet() {
        System.out.println("Здравейте от Калкулатора!");
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int result = calc.add(10, 20);
        System.out.println("Сумата е: " + result);

        calc.greet();
    }
}