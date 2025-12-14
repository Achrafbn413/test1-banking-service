
public class Main {

    public static void main(String[] args) {

        AccountService account = new Account();

        // Test scenario provided in the subject
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Print final bank statement
        account.printStatement();
    }
}
