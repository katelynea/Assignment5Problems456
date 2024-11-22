package pattern5;

public class RideContext {
    private double distance;
    private int timeOfDay;
    private int driversInArea;
    private int demandLevel;

    public RideContext(double distance, int timeOfDay, int driversInArea, int demandLevel) {
        this.distance = distance;
        this.timeOfDay = timeOfDay;
        this.driversInArea = driversInArea;
        this.demandLevel = demandLevel;
    }

    public double getDistance() { return distance; }
    public int getTimeOfDay() { return timeOfDay; }
    public int getDriversInArea() { return driversInArea; }
    public int getDemandLevel() { return demandLevel; }
}
