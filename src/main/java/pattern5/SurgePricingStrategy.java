package pattern5;

public class SurgePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, RideContext context) {
        double surgeMultiplier = calculateSurgeMultiplier(context);
        return basePrice * context.getDistance() * surgeMultiplier;
    }

    private double calculateSurgeMultiplier(RideContext context) {
        // Modified multiplier calculation to ensure surge pricing
        // when demand is higher than 50% of available drivers
        double demandFactor = context.getDemandLevel() / (double)context.getDriversInArea();

        // If demand is more than 50% of available drivers, apply surge
        if (demandFactor > 0.5) {
            // This will give us a multiplier between 1.5 and 3.0
            return Math.min(3.0, 1.5 + demandFactor);
        }

        // Otherwise, use standard pricing
        return 1.0;
    }
}

