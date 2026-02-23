import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final static double DEPOSIT_AMOUNT = 100;
    private final static double WITHDRAW_AMOUNT = 70;
    private final static int WRONG_ID = 2;
    private final static double INITIAL_BALANCE = 0;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccount(this.accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(this.accountHolder.id(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(this.accountHolder.id(), DEPOSIT_AMOUNT);
        this.bankAccount.deposit(WRONG_ID, DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.depositAndWithdrawTest(WITHDRAW_AMOUNT,
                DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - this.bankAccount.getWithdrawFee());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(this.accountHolder.id(), DEPOSIT_AMOUNT);
        this.bankAccount.withdraw(WRONG_ID, WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.bankAccount.getBalance());
    }

    @Test
    void testWithdrawOverBalance() {
        this.depositAndWithdrawTest(DEPOSIT_AMOUNT*2, DEPOSIT_AMOUNT);
    }

    @Test
    void testWithdrawNegativeAmount() {
        this.depositAndWithdrawTest(-DEPOSIT_AMOUNT, DEPOSIT_AMOUNT);
    }

    @Test
    void testDepositNegativeAmount() {
        this.bankAccount.deposit(this.accountHolder.id(), -DEPOSIT_AMOUNT);
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    private void depositAndWithdrawTest(final double withdrawAmount, final double expectedBalance) {
        this.bankAccount.deposit(this.accountHolder.id(), DEPOSIT_AMOUNT);
        this.bankAccount.withdraw(this.accountHolder.id(), withdrawAmount);
        assertEquals(expectedBalance, this.bankAccount.getBalance());
    }
}
