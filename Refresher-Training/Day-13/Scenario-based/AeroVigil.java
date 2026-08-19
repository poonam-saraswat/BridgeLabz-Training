import java.util.*;

//CustomException
class InvalidFlightException extends Exception{
    public InvalidFlightException(String message){
        super(message);
    }
}
//UtilityclassForFlightValidationndFeulCalculation

class FlightUtil {
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (flightNumber == null || !flightNumber.matches("^FL-[1-9][0-9]{3}$")) {
            throw new InvalidFlightException(" The Flight Number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (flightName != null && (
                flightName.equalsIgnoreCase("SpiceJet") ||
                        flightName.equalsIgnoreCase("Vistara") ||
                        flightName.equalsIgnoreCase("IndiGo") ||
                        flightName.equalsIgnoreCase("Air Arabia")
        )) {
            return true;
        }
        throw new InvalidFlightException("The Flight name " + flightName + "is invalid");
    }

    //Helper to get maxCapacity of flight
    private int getMaxCapacity(String flightName) {
        if (flightName.equalsIgnoreCase("SpiceJet")) return 396;
        if (flightName.equalsIgnoreCase("Vistara")) return 615;
        if (flightName.equalsIgnoreCase("IndiGo")) return 230;
        if (flightName.equalsIgnoreCase("Air Arabia")) return 130;
        return 0;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int maxCapacity = getMaxCapacity(flightName);
        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException("The passenger Count " + passengerCount + "is invalid for" + flightName);

        }
        return true;
    }

    //Helper to get fuel tank capacity
    private double getFuelCapacity(String flightName) {
        if (flightName.equalsIgnoreCase("SpiceJet")) return 200000.0;
        if (flightName.equalsIgnoreCase("Vistara")) return 300000.0;
        if (flightName.equalsIgnoreCase("IndiGo")) return 250000.0;
        if (flightName.equalsIgnoreCase("Air Arabia")) return 150000.0;
        return 0.0;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxFuelCapacity = getFuelCapacity(flightName);
        if (currentFuelLevel < 0 || currentFuelLevel > maxFuelCapacity) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        return maxFuelCapacity - currentFuelLevel;
    }
}

public class Aerovigil{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try{
            //Split input string
            String[] details = input.split(":");
            if(details.length < 4){
                System.out.println("Invlid input format");
                return;
            }
            String flightNumber = details[0].trim();
            String flightName = details[1].trim();
            int passengerCount = Integer.parseInt(details[2].trim());
            double currentFuelLevel = Double.parseDouble(details[3].trim());

            FlightUtil flightUtil = new FlightUtil();

            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double fuelRequired = flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);
            System.out.println("Fuel required to fill the tank : " + fuelRequired + " litres");
        }catch (InvalidFlightException e){
            System.out.println(e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Invalid numeric input encountered.");
        }finally{
            sc.close();
        }
    }

}



