/**
 * Public interface defining account operations.
 * This interface must not be modified as per test instructions.
 */
public interface AccountService {

    void deposit(int amount);

    void withdraw(int amount);

    void printStatement();
}
