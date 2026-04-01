interface Dashboard{
    void displaySpeed();

    default void batterPercent(){
        System.out.println("No battery percent for normal vehicle");
    }
}

class Car implements Dashboard{
    @Override
    public void displaySpeed(){
        System.out.println("60km/hr");
    }
}

class Bike implements Dashboard{
    @Override
    public void displaySpeed(){
        System.out.println("40km/hr");
    }
}

class ElectricScooty implements Dashboard{
    @Override
    public void displaySpeed(){
        System.out.println("50km/hr");
    }

    @Override
    public void batterPercent(){
        System.out.println("82% charged.");
    }
}

public class VehicleDashboard {
    public static void main(String[] args){
        Dashboard car = new Car();
        Dashboard bike = new Bike();
        Dashboard electric = new ElectricScooty();

        car.displaySpeed();
        bike.displaySpeed();
        bike.batterPercent();

        electric.displaySpeed();
        electric.batterPercent();
    }
}
