# Assignment 5 Problems 4-6

# Design Patterns Implementation and Tests

This project contains implementations and tests for three design patterns:
1. Proxy Pattern (Pattern 4) - Payment Processing System
2. Strategy Pattern (Pattern 5) - Dynamic Pricing System
3. Observer Pattern (Pattern 6) - Coupon Notification System

## Project Structure
```
Assignment5Problems456/
├── .idea/                  # IntelliJ IDEA configuration files
├── out/                    # Compiled output
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pattern4/
│   │       │   ├── PaymentProcessor.java
│   │       │   ├── PayPalService.java
│   │       │   └── PaymentProxy.java
│   │       ├── pattern5/
│   │       │   ├── PricingStrategy.java
│   │       │   ├── StandardPricingStrategy.java
│   │       │   ├── SurgePricingStrategy.java
│   │       │   ├── RideContext.java
│   │       │   └── PriceCalculator.java
│   │       └── pattern6/
│   │           ├── RiderObserver.java
│   │           ├── CouponPublisher.java
│   │           ├── Rider.java
│   │           └── CouponSystem.java
│   └── test/
│       └── java/
│           ├── pattern4/
│           │   └── PaymentProxyTest.java
│           ├── pattern5/
│           │   └── PricingStrategyTest.java
│           └── pattern6/
│               └── CouponSystemTest.java

```

## Prerequisites
- Java JDK 11 or higher
- IntelliJ IDEA

## Dependencies
The project uses JUnit for testing. Add this to your pom.xml if not already present:
```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Running the Project in IntelliJ IDEA

1. Open the project:
   - Open IntelliJ IDEA
   - File → Open → Navigate to `Assignment5Problems456` folder
   - Select the folder and click OK

2. Configure JDK:
   - File → Project Structure
   - Project Settings → Project
   - Set Project SDK to Java 11 or higher
   - Click Apply and OK

3. Add JUnit dependency (if not present):
   - Right-click `Assignment5Problems456` in Project Explorer
   - Add Framework Support → Maven
   - Add the JUnit dependency to pom.xml
   - Click the Maven Reload button (circular arrows in Maven tool window)

4. Build the project:
   - Build → Build Project
   - Or use shortcut Ctrl+F9 (Windows/Linux) / Cmd+F9 (Mac)

5. Run tests:
   
   For all tests:
   - Right-click on `src/test/java` folder
   - Select "Run 'All Tests'"

   For individual pattern tests:
   ```
   Pattern 4 (Proxy):
   - Navigate to src/test/java/pattern4/PaymentProxyTest.java
   - Right-click → Run 'PaymentProxyTest'

   Pattern 5 (Strategy):
   - Navigate to src/test/java/pattern5/PricingStrategyTest.java
   - Right-click → Run 'PricingStrategyTest'

   Pattern 6 (Observer):
   - Navigate to src/test/java/pattern6/CouponSystemTest.java
   - Right-click → Run 'CouponSystemTest'
   ```

## Test Descriptions

### Pattern 4 - Proxy Pattern Tests
- `testValidPayment`: Tests successful payment processing
- `testInvalidCardNumber`: Tests payment rejection for invalid card numbers
- `testInvalidCvv`: Tests payment rejection for invalid CVV
- `testCardNumberFormatting`: Tests card number formatting

### Pattern 5 - Strategy Pattern Tests
- `testStandardPricing`: Tests basic fare calculation
- `testSurgePricingHighDemand`: Tests surge pricing during high demand
- `testSurgePricingLowDemand`: Tests pricing during low demand
- `testStrategySwitch`: Tests switching between pricing strategies

### Pattern 6 - Observer Pattern Tests
- `testCouponNotification`: Tests notification delivery to multiple riders
- `testUnsubscribe`: Tests unsubscription functionality
- `testMultipleSubscriptions`: Tests handling of duplicate subscriptions
- `testEmptySubscriberList`: Tests system behavior with no subscribers


## Output Location
Compiled classes will be in the `out` folder:
- Main classes: `out/production/Assignment5Problems456`
- Test classes: `out/test/Assignment5Problems456`
