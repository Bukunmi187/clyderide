package clyderide;

// Demonstration program only
// This class shows example usage of the coursework classes.

public class Main {

    public static void main(String[] args) {

        System.out.println("=== ClydeRide Fare Demonstration ===");

        // Create vehicle
        Vehicle vehicle = new Vehicle("Ford","Capri",5,2020);

        System.out.println("\nVehicle created:");
        System.out.println("Vehicle rating: " + vehicle.vehicleRating());

        // Add drivers
        System.out.println("\nAdding drivers...");

        vehicle.addDriver(new Driver("Bob",43,1));
        vehicle.addDriver(new Driver("Alice",39,0));

        System.out.println("Driver experience score: " + vehicle.driverExperience());

        // Quote calculation
        RideQuote quote = new RideQuote(vehicle,500);

        System.out.println("\nQuote calculation:");
        System.out.println("Fare = £" + quote.calculateFare());

        System.out.println("\n--- Scenario 2: young driver added ---");

        vehicle.addDriver(new Driver("Junior",19,1));

        quote = new RideQuote(vehicle,500);

        System.out.println("Driver experience score: " + vehicle.driverExperience());
        System.out.println("Fare = £" + quote.calculateFare());

        System.out.println("\n--- Scenario 3: removing driver ---");

        vehicle.removeDriverByName("Junior");

        quote = new RideQuote(vehicle,500);

        System.out.println("Driver experience score: " + vehicle.driverExperience());
        System.out.println("Fare = £" + quote.calculateFare());

        System.out.println("\n=== End Demonstration ===");

    }
}