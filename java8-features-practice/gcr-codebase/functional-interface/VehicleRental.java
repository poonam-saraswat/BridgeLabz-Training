interface RentalVehichles{
    void rent();
    void returnVehicle();
}

class Bikes implements RentalVehichles{

    @Override
    public void rent(){
        System.out.println("You rented a bike.");
    }

    @Override
    public void returnVehicle(){
        System.out.println("Returning the rented bike.");
    }
}

class Cars implements RentalVehichles{

    @Override
    public void rent(){
        System.out.println("You rented a Car.");
    }

    @Override
    public void returnVehicle(){
        System.out.println("Returning the rented Car.");
    }
}

class Buses implements RentalVehichles{

    @Override
    public void rent(){
        System.out.println("You rented a Bus.");
    }

    @Override
    public void returnVehicle(){
        System.out.println("Returning the rented Bus.");
    }
}

public class VehicleRental {
    public static void main(String[] args){
        RentalVehichles bike = new Bikes();
        RentalVehichles car = new Cars();
        RentalVehichles bus = new Buses();

        bike.rent();
        bike.returnVehicle();

        car.rent();
        car.returnVehicle();

        bus.rent();
        bus.returnVehicle();
    } 
}
