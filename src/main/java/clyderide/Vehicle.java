package clyderide;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private String make;
    private String model;
    private int vehicleClass;
    private int year;
    private List<Driver> drivers;

    public Vehicle(String make, String model, int vehicleClass, int year) {

        this.make = make;
        this.model = model;

        // FIX 1: Set invalid class to 100 (unusable vehicle)
        this.vehicleClass = (vehicleClass < 1 || vehicleClass > 10) ? 100 : vehicleClass;

        this.year = year;

        drivers = new ArrayList<>();
    }

    public int addDriver(Driver driver){
        drivers.add(driver);
        return drivers.size();
    }

    public boolean removeDriverByName(String name){

        int before = drivers.size();

        // FIX 2: Use equals(), not ==
        drivers.removeIf(d -> d.getName().equals(name));

        return drivers.size() < before;
    }

    public double driverExperience(){

        // FIX 3: If no drivers, return 0
        double max = 0;

        for(Driver d : drivers){
            double score = d.experienceScore();
            if(score > max){
                max = score;
            }
        }

        return max;
    }

    public int vehicleRating(){
        return vehicleClass;
    }

}