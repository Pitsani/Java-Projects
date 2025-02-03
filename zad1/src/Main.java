public class Main {
    public static void main(String[] args) {
        BankAccount debitAcc = new DebitAccount(100,0.05);
        BankAccount creditAcc = new CreditAccount(100,0.05, 12);

        BankAccount[] account = {debitAcc,creditAcc};

        for(BankAccount acc : account){
            System.out.printf("Interest: %.2f",acc.pay());
        }
        }
    }
