package pattern4;

public interface PaymentProcessor {
    boolean processPayment(double amount, String cardNumber, String cvv);

}
