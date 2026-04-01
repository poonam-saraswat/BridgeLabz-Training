import java.util.*;
public class volumeOfEarth {
    public static void main(String[] args) {
        double radius = 6378; //radius of Earth in kilometers
        double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3); //volume calculation formula
        System.out.println("Volume of the Earth in cubic kilometeres is " + volume + " and cubic miles is " + (volume * 0.239913)); //conversion to cubic miles
    }
    
}
