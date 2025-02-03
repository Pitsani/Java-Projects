public class DebitAccount extends BankAccount{
    public DebitAccount(double suma, double tax){
        super(suma,tax);
    }
    public double pay(){
        return suma*(tax+1);
    }

}
