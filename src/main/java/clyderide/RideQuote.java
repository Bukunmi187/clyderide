package clyderide;

public class RideQuote {

    private static final double LOW = 1.0;
    private static final double MED = 1.5;
    private static final double HIGH = 2.0;
    private static final double VERY_HIGH = 3.0;

    private double baseFare;
    private Vehicle vehicle;

    public RideQuote(Vehicle vehicle, double baseFare) {
        this.vehicle = vehicle;
        this.baseFare = baseFare;
    }

    public double calculateFare(){

        int vehicleRating = vehicle.vehicleRating();

        // FIX: explicitly return 0.0 for unusable vehicle
        if(vehicleRating == 100){
            return 0.0;
        }

        double experience = vehicle.driverExperience();
        double totalScore = vehicleRating + experience;

        if(totalScore < 5){
            return baseFare * LOW;
        }
        else if(totalScore < 10){
            return baseFare * MED;
        }
        else if(totalScore < 15){
            return baseFare * HIGH;
        }
        else{
            return baseFare * VERY_HIGH;
        }
    }
}