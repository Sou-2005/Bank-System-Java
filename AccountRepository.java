import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    public void add(Account account) {
        accounts.add(account);
    }

    public Account findByOwner(String owner) {
        for (Account acc : accounts) {
            if (acc.getOwner().equals(owner)) {
                return acc;
            }
        }
        return null;
    }

    public List<Account> findAll() {
        return accounts;
    }
}
