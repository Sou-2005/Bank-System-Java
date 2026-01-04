public class AccountFactory {

    public static Account createAccount(String owner, double balance, AccountType type) {
        return new Account(owner, balance, type);
    }
}
