import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Account implementation for the Banking Service test.
 * Handles deposits, withdrawals and statement printing.
 */
public class Account implements AccountService {

    // List storing all account transactions in memory
    private final List<Transaction> transactions = new ArrayList<>();

    // Current account balance
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        // Validate deposit amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        balance += amount;

        // Store transaction with updated balance
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        // Validate withdrawal amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than zero");
        }

        // Check sufficient balance
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;

        // Store transaction as negative amount
        transactions.add(new Transaction(LocalDate.now(), -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date        || Amount || Balance");

        // Create a reversed copy to print latest transactions first
        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        for (Transaction t : reversed) {
            System.out.printf(
                    "%s || %d || %d%n",
                    t.getDate(),
                    t.getAmount(),
                    t.getBalanceAfter()
            );
        }
    }
}
