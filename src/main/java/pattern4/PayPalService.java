package pattern4;

public class PayPalService implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount, String cardNumber, String cvv) {
        // Simulate PayPal API call
        System.out.println("Processing $" + amount + " through PayPal");
        System.out.println("Card: " + cardNumber + ", CVV: " + cvv);
        return true;
    }
}
