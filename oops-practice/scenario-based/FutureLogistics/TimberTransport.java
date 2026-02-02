public class TimberTransport extends GoodsTransport{
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, String transportRating, float timberLength, float timberRadius, String timberType, float timberPrice){
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public float getTimberLength(){ return timberLength; }
    public float getTimberRadius(){ return timberRadius; }
    public String getTimberType(){ return timberType; }
    public float getTimberPrice(){ return timberPrice; }

    public void setTimberLength(float len){ this.timberLength = len; }
    public void setTimberRadius(float radius) { this.timberRadius = radius; }
    public void setTimberType(String type){ this.timberType = type; }
    public void setTimberPrice(float price) { this.timberPrice = price; }

    public String VehicleSelection(){
        double area = 2 * 3.147 * timberRadius * timberLength;
        if(area < 250){
            return "Truck";
        }
        else if(area >= 250 && area <= 400){
            return "Lorry";
        }
        else{
            return "MonsterLorry";
        }
    }

    public float calculateTotalCharge(){
        double volume = 3.147 * timberRadius * timberRadius * timberLength;
        String vehicle = VehicleSelection();
        int vehicleCost = calculateVehicleCost(vehicle);
        double timberTypePrice = calculateTimberTypePrice(timberType);
        double price = volume * timberPrice * timberTypePrice;
        double tax = price * 0.3;
        double discount = calculateDiscountPercent(Double.parseDouble(getTransportRating()));
        double discountPrice = price * discount;

        double totalCharge = ((price) + vehicleCost + tax) - discountPrice;

        return (float) totalCharge;
    }

    public double calculateTimberTypePrice(String timberType){
        if(timberType.equalsIgnoreCase("premium")){
            return 0.25;
        }
        else{
            return 0.15;
        }
    }

     public int calculateVehicleCost(String vehicle){
        if(vehicle.equals("Truck")){
            return 1000;
        }
        else if(vehicle.equals("Lorry")){
            return 1700;
        }
        else{
            return 3000;
        }
    }

    public double calculateDiscountPercent(double rating){
        if(rating ==  5){
            return 0.20;
        }
        else if(rating >= 3 && rating <= 4){
            return 0.10;
        }

        return 0;
    }
}