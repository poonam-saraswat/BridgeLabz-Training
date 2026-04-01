public class BrickTransport extends GoodsTransport {
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, String transportRating, float brickSize, int brickQuantity, float brickPrice){
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public float getBrickSize(){ return brickSize; }
    public int getBrickQuantity(){ return brickQuantity; }
    public float getBrickPrice(){ return brickPrice; }

    public void setBrickSize(float size){ this.brickSize = size; }
    public void setBrickQuantity(int quantity) { this.brickQuantity = quantity; }
    public void setbrickPrice(float price) { this.brickPrice = price; }

    @Override
    public String VehicleSelection(){
        if(brickQuantity < 300){
            return "Truck";
        }
        else if( brickQuantity >= 300 && brickQuantity <= 500){
            return "Lorry";
        }
        else{
            return "MonsterLorry";
        }
    }

    @Override
    public float calculateTotalCharge(){
        float totalBrickCost = brickQuantity * brickPrice;
        String vehicle = VehicleSelection();
        int vehicleCost = calculateVehicleCost(vehicle);
        double discount = calculateDiscountPercent(Double.parseDouble(getTransportRating()));
        double tax = (0.30 * totalBrickCost);
        double discountPrice = totalBrickCost * discount;

        double totalCharge = ((totalBrickCost) + vehicleCost + tax) - discountPrice;

        return (float) totalCharge;
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