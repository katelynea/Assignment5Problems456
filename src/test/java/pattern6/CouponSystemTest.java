package pattern6;

import org.junit.Test;
import static org.junit.Assert.*;

public class CouponSystemTest {
    private static class TestRider implements RiderObserver {
        private String name;
        private boolean notificationReceived = false;
        private String lastCoupon = null;
        private int notificationCount = 0;

        public TestRider(String name) {
            this.name = name;
        }

        @Override
        public void update(String coupon) {
            notificationReceived = true;
            lastCoupon = coupon;
            notificationCount++;
        }

        public boolean hasReceivedNotification() {
            return notificationReceived;
        }

        public String getLastCoupon() {
            return lastCoupon;
        }

        public int getNotificationCount() {
            return notificationCount;
        }
    }

    @Test
    public void testCouponNotification() {
        CouponSystem couponSystem = new CouponSystem();
        TestRider rider1 = new TestRider("John");
        TestRider rider2 = new TestRider("Alice");

        couponSystem.subscribe(rider1);
        couponSystem.subscribe(rider2);

        couponSystem.generateCoupon("Test Promotion");

        assertTrue("Rider1 should receive notification", rider1.hasReceivedNotification());
        assertTrue("Rider2 should receive notification", rider2.hasReceivedNotification());
        assertTrue("Coupon code should be stored", rider1.getLastCoupon().contains("Test Promotion"));
    }

    @Test
    public void testUnsubscribe() {
        CouponSystem couponSystem = new CouponSystem();
        TestRider rider = new TestRider("John");

        couponSystem.subscribe(rider);
        couponSystem.unsubscribe(rider);
        couponSystem.generateCoupon("Test Promotion");

        assertFalse("Unsubscribed rider should not receive notification",
                rider.hasReceivedNotification());
    }

    @Test
    public void testMultipleSubscriptions() {
        CouponSystem couponSystem = new CouponSystem();
        TestRider rider = new TestRider("John");

        couponSystem.subscribe(rider);
        couponSystem.subscribe(rider); // Try to subscribe again

        couponSystem.generateCoupon("Test Promotion");
        assertEquals("Rider should receive only one notification",
                1, rider.getNotificationCount());
    }

    @Test
    public void testEmptySubscriberList() {
        CouponSystem couponSystem = new CouponSystem();
        couponSystem.generateCoupon("Test Promotion");
        // Should not throw any exceptions
    }
}