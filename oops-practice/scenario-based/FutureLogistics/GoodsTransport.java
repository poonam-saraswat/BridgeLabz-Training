abstract class GoodsTransport{
    private String transportId;
    private String transportDate;
    private String transportRating;

    public GoodsTransport(String transportId, String transportDate, String transportRating){
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public String getTransportId(){ return transportId; }
    public String getTransportDate(){ return transportDate; }
    public String getTransportRating(){ return transportRating; }

    public void setTransportId(String id){ this.transportId = id; }
    public void setTransportDate(String date) { this.transportDate = date; }
    public void setTransportRating(String rating) { this.transportRating = rating; }

    abstract public String VehicleSelection();

    abstract public float calculateTotalCharge();

}