package pattern5;

public class SurgePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, RideContext context) {
        double surgeMultiplier = calculateSurgeMultiplier(context);
        return basePrice * context.getDistance() * surgeMultiplier;
    }

    private double calculateSurgeMultiplier(RideContext context) {
        double demandFactor = context.getDemandLevel() / (double)context.getDriversInArea();
        return Math.min(3.0, Math.max(1.0, demandFactor));
    }
}

