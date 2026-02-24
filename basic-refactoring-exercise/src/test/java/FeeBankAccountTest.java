import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.FeeBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeBankAccountTest {
    private BankAccount bankAccount;
    private AccountHolder accountHolder;

    @BeforeEach
    public void beforeEach() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new FeeBankAccount(this.accountHolder, 0);
    }

    @Test
    public void testInialBalance() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    public void testCorrectDeposit() {
        final double depositAmount = 100;
        this.bankAccount.deposit(this.accountHolder.id(), depositAmount);
        assertEquals(depositAmount, this.bankAccount.getBalance());
    }
}
