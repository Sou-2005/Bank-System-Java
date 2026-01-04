import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
public class BankService {
    private AccountRepository repository = new AccountRepository();
    private Logger logger = Logger.getInstance();
    public void openAccount(String owner, double balance, AccountType type) {
        Account account = AccountFactory.createAccount(owner, balance, type);
        repository.add(account);
        logger.log("An account has been opened for" + owner);
    }
    public void deposit(String owner, double amount) {
        Account acc = repository.findByOwner(owner);
        if (acc != null) {
            acc.deposit(amount);
            logger.log("Deposit has been made for " + amount + " in an account " + owner);
        } else {
            System.out.println("The account does not exist");
        }
    }
    public void withdraw(String owner, double amount) {
        Account acc = repository.findByOwner(owner);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                logger.log("Withdraw has been made for " + amount + " from account " + owner);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("The account does not exist");
        }
    }
    public void transfer(String from, String to, double amount) {
        Account fromAcc = repository.findByOwner(from);
        Account toAcc = repository.findByOwner(to);

        if (fromAcc != null && toAcc != null) {
            if (fromAcc.withdraw(amount)) {
                toAcc.deposit(amount);
                logger.log("Transfer of " + amount + " from " + from + " to " + to);
            } else {
                System.out.println("Failed transfer: insufficient balance");
            }
        } else {
            System.out.println("The account does not exist");
        }
    }

    public void duplicateAccount(String owner) {
        Account acc = repository.findByOwner(owner);
        if (acc != null) {
            repository.add(acc.clone());
            logger.log("The account was copied for" + owner);
        }
    }

    public void sendNotification(Notification notification, String message) {
        notification.send(message);
    }

    public void printAccounts() {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
        out.println("---- List of accounts ----");
        for (Account acc : repository.findAll()) {
            out.println(acc);
        }
    }
}