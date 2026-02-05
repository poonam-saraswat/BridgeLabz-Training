public class FlightUtil{
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
        if(!flightNumber.matches("^FL-[1-9][0-9]{3}$")){
           throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }

        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException{

        if (flightName.equalsIgnoreCase("SpiceJet") ||
            flightName.equalsIgnoreCase("Vistara") ||
            flightName.equalsIgnoreCase("IndiGo") ||
            flightName.equalsIgnoreCase("Air Arabia")) {

            return true;
        }

        throw new InvalidFlightException("The flight name " + flightName + " is invalid");
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException{
        if((flightName.equalsIgnoreCase("SpiceJet") && passengerCount <= 396 && passengerCount > 0) || 
           (flightName.equalsIgnoreCase("Vistara") && passengerCount <= 615 && passengerCount > 0) ||
           (flightName.equalsIgnoreCase("IndiGo") && passengerCount <= 230 && passengerCount > 0) ||
           (flightName.equalsIgnoreCase("Air Arabia") && passengerCount <= 130 && passengerCount > 0)){

            return true;
        }

        throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
        if(flightName.equalsIgnoreCase("SpiceJet") && currentFuelLevel >= 0 && currentFuelLevel <= 200000){
            return 200000 - currentFuelLevel;
        }
        else if(flightName.equalsIgnoreCase("Vistara") && currentFuelLevel >= 0 && currentFuelLevel <= 300000){
            return 300000 - currentFuelLevel;
        }
        else if(flightName.equalsIgnoreCase("IndiGo") && currentFuelLevel >= 0 && currentFuelLevel <= 250000){
            return 250000 - currentFuelLevel;
        }
        else if(flightName.equalsIgnoreCase("Air Arabia") && currentFuelLevel >= 0 && currentFuelLevel <= 150000){
            return 150000 - currentFuelLevel;
        }

        throw new InvalidFlightException("Invalid fuel level for " + flightName);
    }

}