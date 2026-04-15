package clyderide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RideQuoteTest {

    @Test
    void testFareBaseRange() {
        Vehicle v = new Vehicle("Ford", "Ka", 1, 2010);
        v.addDriver(new Driver("A", 30, 0)); // score = 1
        RideQuote rq = new RideQuote(v, 10);

        assertEquals(10.0, rq.calculateFare(), 0.0001);
    }

    @Test
    void testFareMultiplier1_5() {
        Vehicle v = new Vehicle("VW", "Golf", 5, 2012);
        v.addDriver(new Driver("A", 30, 0)); // score = 1
        RideQuote rq = new RideQuote(v, 10);

        assertEquals(15.0, rq.calculateFare(), 0.0001);
    }

    @Test
    void testFareMultiplier2_0() {
        Vehicle v = new Vehicle("Nissan", "Leaf", 10, 2020);
        v.addDriver(new Driver("A", 30, 0)); // score = 1
        RideQuote rq = new RideQuote(v, 10);

        assertEquals(20.0, rq.calculateFare(), 0.0001);
    }

    @Test
    void testFareMultiplier3_0() {
        Vehicle v = new Vehicle("BMW", "X5", 10, 2020);
        v.addDriver(new Driver("A", 30, 0));   // score=1
        v.addDriver(new Driver("B", 25, 0));   // score=1
        v.addDriver(new Driver("C", 40, 0));   // score=1

        // To hit score >= 15, add an “extreme” driver
        v.addDriver(new Driver("D", 80, 0));  // score = 0.8

        // Rating=10, experience=1 → easy method: override experience manually
        RideQuote rq = new RideQuote(v, 10);

        // We want score >=15. Add better driver:
        v.addDriver(new Driver("X", 100, 0)); // score = 0.8 (fixed min)
        // Instead, manually make a high-score driver:
        Driver expert = new Driver("Pro", 40, 0); // 1.0
        v.addDriver(expert);

        // Score remains rating 10 + exp 1 = 11. To hit 15, fake class:
        Vehicle v2 = new Vehicle("Audi", "A8", 10, 2022);
        v2.addDriver(new Driver("E", 30, 0));
        RideQuote rq2 = new RideQuote(v2, 10);

        // To force a ≥15 case, do:
        // rating=10 + exp=5 (manually create driver)
        Vehicle v3 = new Vehicle("Test", "Car", 10, 2023);
        Driver high = new Driver("Super", 25, 0) {
            @Override
            public double experienceScore() { return 5.0; }
        };
        v3.addDriver(high);

        RideQuote rq3 = new RideQuote(v3, 10);

        assertEquals(30.0, rq3.calculateFare(), 0.0001);
    }

    @Test
    void testUnusableVehicleFareZero() {
        Vehicle v = new Vehicle("Ford", "Fiesta", 0, 2010); // becomes class=100
        RideQuote rq = new RideQuote(v, 10);

        assertEquals(0.0, rq.calculateFare(), 0.0001);
    }
}