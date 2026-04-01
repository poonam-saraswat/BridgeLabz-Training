import java.util.function.*;

public class AlertSystem {
    public static void main(String[] args){
        double threshold = 29.5;

        Predicate<Double> alert = temp -> temp > threshold;

        double currTemp = 40;

        if(alert.test(currTemp)){
            System.err.println("Temperature is above threshold.");
        }
        else{
            System.out.println("Temperature is normal.");
        }
    }
}
