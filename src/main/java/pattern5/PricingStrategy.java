package pattern5;

public interface PricingStrategy {
    double calculatePrice(double basePrice, RideContext context);
}
