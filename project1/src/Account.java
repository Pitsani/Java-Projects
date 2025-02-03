public class Account {
    private double balance;
    private String pinCode;
    private String accountNumber;

    public Account(double balance, String pinCode, String accountNumber) {
        this.balance = balance;
        this.pinCode = pinCode;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative!");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative!");
        if (amount > balance) throw new IllegalArgumentException("Amount caanot be greater that balance!");
        balance -= amount;
    }

    public boolean checkPin(String pinCode) {
        return this.pinCode.equals(pinCode);
    }

    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", pin='" + pinCode + '\'' +
                ", balance=" + balance +
                '}';
    }

}
