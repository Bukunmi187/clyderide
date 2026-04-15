package clyderide;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Driver {

    private String name;
    private int age;
    private int complaints;

    public double experienceScore(){

        double score = 1.0;

        // Young driver
        if(age < 25){
            score *= 0.6;
        }

        // Elderly driver (>= instead of >)
        if(age >= 75){
            score *= 0.8;
        }

        // Complaint reduction
        score -= complaints * 0.2;

        // Minimum score = 0
        if(score < 0){
            score = 0;
        }

        return score;
    }
}