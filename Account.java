public class Account implements Cloneable {

    private String owner;
    private double balance;
    private AccountType type;

    public Account(String owner, double balance, AccountType type) {
        this.owner = owner;
        this.balance = balance;
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getType() {
        return type;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public Account clone() {
        return new Account(owner + "_copy", balance, type);
    }

    @Override
    public String toString() {
        return owner + " |Balance : " + balance + " | Type: " + type;
    }
}