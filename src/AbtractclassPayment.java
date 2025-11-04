public abstract class AbtractclassPayment {
    protected double amount;

    public AbtractclassPayment(double amount) {
        this.amount = amount;
    }

    public void paymentDetails() {
        System.out.println("Processing payment of $" + amount);
    }

    public abstract void processPayment();
}
