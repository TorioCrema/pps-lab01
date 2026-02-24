import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.FeeBankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeBankAccountTest {
    private BankAccount bankAccount;
    private AccountHolder accountHolder;

    @Test
    public void testInialBalance() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new FeeBankAccount(this.accountHolder, 0);
        assertEquals(0, this.bankAccount.getBalance());
    }
}
