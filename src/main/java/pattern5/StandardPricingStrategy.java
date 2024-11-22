package pattern5;


public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, RideContext context) {
        return basePrice * context.getDistance();
    }
}