public class BankTransferAbtractclassPayment extends AbtractclassPayment {
    private String bankAccount;

    public BankTransferAbtractclassPayment(double amount, String bankAccount) {
        super(amount);
        this.bankAccount = bankAccount;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing bank transfer payment of $" + amount +
                " for bank account " + bankAccount);
    }
}
