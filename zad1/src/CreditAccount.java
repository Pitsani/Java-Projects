public class CreditAccount extends BankAccount{
    private int months;

    public CreditAccount(double suma, double tax, int months){
        super(suma,tax);
        this.months = months;
    }

    public double pay(){
        return suma*Math.pow(1+(tax),months);
    }
}
