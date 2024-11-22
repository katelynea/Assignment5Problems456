package pattern4;

public class PaymentProxy implements PaymentProcessor{
    private PayPalService paypalService;
    public PaymentProxy() {
        this.paypalService = new PayPalService();
    }

    @Override
    public boolean processPayment(double amount, String cardNumber, String cvv) {
        // Pre-process data
        if (!validateCard(cardNumber, cvv)) {
            return false;
        }

        // Format data for PayPal
        String formattedCard = formatCardNumber(cardNumber);

        // Forward to PayPal
        return paypalService.processPayment(amount, formattedCard, cvv);
    }

    private boolean validateCard(String cardNumber, String cvv) {
        // Validation logic
        return cardNumber.replaceAll("\\s+", "").length() >= 16 && cvv.length() >= 3;
    }

    private String formatCardNumber(String cardNumber) {
        // Format card number according to PayPal requirements
        return cardNumber.replaceAll("\\s+", "");
    }
}
