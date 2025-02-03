interface Payable{
    double pay();
}

public abstract class BankAccount implements Payable {
    protected double suma;
    protected double tax;

    public BankAccount(double suma, double tax) {
        this.suma = suma;
        this.tax = tax;
    }

}

