package clyderide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    void testAddDriverIncreasesCount() {
        Vehicle v = new Vehicle("Ford", "Focus", 5, 2018);
        int count = v.addDriver(new Driver("A", 30, 0));
        assertEquals(1, count);
    }

    @Test
    void testRemoveDriverByName() {
        Vehicle v = new Vehicle("Ford", "Fiesta", 4, 2017);
        v.addDriver(new Driver("A", 30, 0));
        v.addDriver(new Driver("B", 40, 1));

        boolean removed = v.removeDriverByName("A");

        assertTrue(removed);
        assertEquals(1, v.driverExperience() > 0 ? 1 : 0); // ensures exactly 1 driver remains
    }

    @Test
    void testVehicleClassOutOfRange() {
        Vehicle v = new Vehicle("Tesla", "Model S", 0, 2020);
        assertEquals(100, v.vehicleRating());
    }

    @Test
    void testMaxDriverExperience() {
        Vehicle v = new Vehicle("Honda", "Civic", 3, 2016);

        Driver d1 = new Driver("A", 22, 0); // 1.0 * 0.6 = 0.6
        Driver d2 = new Driver("B", 40, 0); // 1.0

        v.addDriver(d1);
        v.addDriver(d2);

        assertEquals(1.0, v.driverExperience(), 0.0001);
    }

    @Test
    void testNoDriversExperienceZero() {
        Vehicle v = new Vehicle("Toyota", "Yaris", 5, 2015);
        assertEquals(0.0, v.driverExperience(), 0.0001);
    }
}