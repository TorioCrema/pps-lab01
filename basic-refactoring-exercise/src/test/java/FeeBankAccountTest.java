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
    private final double initialBalance = 0;

    @BeforeEach
    public void beforeEach() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new FeeBankAccount(this.accountHolder, this.initialBalance);
    }

    @Test
    public void testInialBalance() {
        assertEquals(this.initialBalance, this.bankAccount.getBalance());
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
        this.testBalanceAfterDepositAndWithdraw(withdrawAmount,
                this.depositAmount - withdrawAmount - feeAmount);
    }

    @Test
    public void testWrongIDDeposit() {
        final int wrongID = 2;
        this.bankAccount.deposit(wrongID, this.depositAmount);
        assertEquals(this.initialBalance, this.bankAccount.getBalance());
    }

    @Test
    public void testWrongIDWithdraw() {
        final int wrongID = 2;
        this.bankAccount.deposit(this.accountHolder.id(), this.depositAmount);
        this.bankAccount.withdraw(wrongID, this.depositAmount);
        assertEquals(this.depositAmount, this.bankAccount.getBalance());
    }

    @Test
    public void testWithdrawOverBalance() {
        this.testBalanceAfterDepositAndWithdraw(this.depositAmount * 2, this.depositAmount);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        this.testBalanceAfterDepositAndWithdraw(-this.depositAmount, this.depositAmount);
    }

    @Test
    public void testDepositNegativeAmount() {
        this.bankAccount.deposit(this.accountHolder.id(), -this.depositAmount);
        assertEquals(this.initialBalance, this.bankAccount.getBalance());
    }

    private void testBalanceAfterDepositAndWithdraw(final double withdrawAmount, final double expectedBalance) {
        this.bankAccount.deposit(this.accountHolder.id(), this.depositAmount);
        this.bankAccount.withdraw(this.accountHolder.id(), withdrawAmount);
        assertEquals(expectedBalance, this.bankAccount.getBalance());
    }
}
