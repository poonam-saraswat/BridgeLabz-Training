import org.json.JSONObject;

class Car{
    String brand;
    String licenseNumber;
    String color;
    String fuelType;

    public Car(String brand, String licenseNumber, String color, String fuelType){
        this.brand = brand;
        this.licenseNumber = licenseNumber;
        this.color = color;
        this.fuelType = fuelType;
    }
}

public class ObjectToJson{
    public static void main(String[] args){
        Car car = new Car("BMW", "AB1234", "Blue", "Petrol");

        JSONObject json = new JSONObject();
        json.put("brand", car.brand);
        json.put("licenseNumber", car.licenseNumber);
        json.put("color", car.color);
        json.put("FuelType", car.fuelType);

        System.out.println(json.toString(2));
    }
}