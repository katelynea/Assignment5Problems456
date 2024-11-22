package pattern4;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentProxyTest {
    @Test
    public void testValidPayment() {
        PaymentProcessor processor = new PaymentProxy();
        boolean result = processor.processPayment(50.00, "4111111111111111", "123");
        assertTrue("Payment should be processed successfully", result);
    }

    @Test
    public void testInvalidCardNumber() {
        PaymentProcessor processor = new PaymentProxy();
        boolean result = processor.processPayment(50.00, "411111", "123");
        assertFalse("Payment should fail with invalid card number", result);
    }

    @Test
    public void testInvalidCvv() {
        PaymentProcessor processor = new PaymentProxy();
        boolean result = processor.processPayment(50.00, "4111111111111111", "1");
        assertFalse("Payment should fail with invalid CVV", result);
    }

    @Test
    public void testCardNumberFormatting() {
        PaymentProcessor processor = new PaymentProxy();
        boolean result = processor.processPayment(50.00, "4111 1111 1111 1111", "123");
        assertTrue("Payment should succeed with spaces in card number", result);
    }
}
