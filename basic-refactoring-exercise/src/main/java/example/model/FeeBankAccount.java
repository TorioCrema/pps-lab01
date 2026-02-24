package example.model;

public class FeeBankAccount extends SimpleBankAccount {
    private static final double DEFAULT_FEE_AMOUNT = 1;
    private final double feeAmount;

    public FeeBankAccount(final AccountHolder holder, final double balance) {
        this(holder, balance, DEFAULT_FEE_AMOUNT);
    }

    public FeeBankAccount(final AccountHolder holder, final double balance, final double fee) {
        super(holder, balance);
        this.feeAmount = fee;
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, amount + this.feeAmount);
    }
}
