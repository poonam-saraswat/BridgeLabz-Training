interface Convert{
    static double kmToMiles(double km){
        return km*0.621371;
    }

    static double kgToLbs(double kg){
        return kg * 2.20462;
    }
}
public class UnitConversion {
    public static void main(String[] args){
        System.out.println(Convert.kmToMiles(17.5));
        System.out.println(Convert.kgToLbs(57));
    }
}
