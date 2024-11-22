package pattern6;

public class Rider implements RiderObserver {
    private String name;

    public Rider(String name) {
        this.name = name;
    }

    @Override
    public void update(String coupon) {
        System.out.println(name + " received coupon: " + coupon);
    }

    public String getName() {
        return name;
    }
}