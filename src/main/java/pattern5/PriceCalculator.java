package pattern5;

public class PriceCalculator {
    private PricingStrategy strategy;
    private double basePrice = 2.0; // Base price per km

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(RideContext context) {
        return strategy.calculatePrice(basePrice, context);
    }
}
