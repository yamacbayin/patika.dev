import java.util.TreeSet;

class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        this.accounts = new TreeSet<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account login(String email, String password) {
        for (Account account : accounts) {
            try {
                account.login(email, password);
                return account;
            } catch (InvalidAuthenticationException e) {
                // Catch the exception for each account and continue to the next one
            }
        }
        return null;
    }
}
