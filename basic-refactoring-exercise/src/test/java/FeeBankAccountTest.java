import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.FeeBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeBankAccountTest {
    private BankAccount bankAccount;
    private AccountHolder accountHolder;
    private final double depositAmount = 100;

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
        this.bankAccount.deposit(this.accountHolder.id(), depositAmount);
        assertEquals(depositAmount, this.bankAccount.getBalance());
    }

    @Test
    public void testCorrectWithdraw() {
        final double withdrawAmount = 50;
        final double feeAmount = 1;
        this.bankAccount.deposit(this.accountHolder.id(), this.depositAmount);
        this.bankAccount.withdraw(this.accountHolder.id(), withdrawAmount);
        assertEquals(this.depositAmount - withdrawAmount - feeAmount, this.bankAccount.getBalance());
    }
}
