package pattern5;

import org.junit.Test;
import static org.junit.Assert.*;

public class PricingStrategyTest {
    private static final double DELTA = 0.001;

    @Test
    public void testStandardPricing() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.setStrategy(new StandardPricingStrategy());

        RideContext context = new RideContext(10.0, 14, 50, 30);
        double price = calculator.calculatePrice(context);

        assertEquals("Standard price should be basePrice * distance",
                20.0, price, DELTA); // basePrice = 2.0
    }

    @Test
    public void testSurgePricingHighDemand() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.setStrategy(new SurgePricingStrategy());

        RideContext surgeContext = new RideContext(10.0, 18, 10, 100);
        double price = calculator.calculatePrice(surgeContext);

        assertTrue("Surge price should be higher than standard price",
                price > 20.0);
        assertTrue("Surge multiplier should not exceed 3.0",
                price <= 60.0); // max 3x surge
    }

    @Test
    public void testSurgePricingLowDemand() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.setStrategy(new SurgePricingStrategy());

        RideContext lowDemandContext = new RideContext(10.0, 14, 100, 10);
        double price = calculator.calculatePrice(lowDemandContext);

        assertEquals("Low demand should result in standard pricing",
                20.0, price, DELTA);
    }

    @Test
    public void testStrategySwitch() {
        PriceCalculator calculator = new PriceCalculator();
        // Creating a context with high demand relative to drivers
        // (60 demand for 50 drivers should trigger surge pricing)
        RideContext context = new RideContext(10.0, 14, 50, 60);

        // Test standard pricing
        calculator.setStrategy(new StandardPricingStrategy());
        double standardPrice = calculator.calculatePrice(context);

        // Test surge pricing
        calculator.setStrategy(new SurgePricingStrategy());
        double surgePrice = calculator.calculatePrice(context);

        // Standard price should be basePrice(2.0) * distance(10.0) = 20.0
        assertEquals("Standard price should be 20.0", 20.0, standardPrice, DELTA);

        // Surge price should be higher
        assertTrue("Surge price should be higher than standard price", surgePrice > standardPrice);
        System.out.println("Standard Price: " + standardPrice);
        System.out.println("Surge Price: " + surgePrice);
    }
}