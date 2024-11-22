package pattern6;

import java.util.ArrayList;
import java.util.List;

public class CouponSystem implements CouponPublisher {
    private List<RiderObserver> riders = new ArrayList<>();

    @Override
    public void subscribe(RiderObserver rider) {
        if (!riders.contains(rider)) {
            riders.add(rider);
        }
    }

    @Override
    public void unsubscribe(RiderObserver rider) {
        riders.remove(rider);
    }

    @Override
    public void notifyRiders(String coupon) {
        for (RiderObserver rider : riders) {
            rider.update(coupon);
        }
    }

    public void generateCoupon(String promotion) {
        String coupon = promotion + ": SAVE" + System.currentTimeMillis() % 1000;
        notifyRiders(coupon);
    }
}
