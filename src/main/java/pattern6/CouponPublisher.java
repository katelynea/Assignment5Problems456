package pattern6;

public interface CouponPublisher {
    void subscribe(RiderObserver rider);
    void unsubscribe(RiderObserver rider);
    void notifyRiders(String coupon);
}