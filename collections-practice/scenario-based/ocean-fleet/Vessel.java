public class Vessel{
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    public Vessel(){
        System.out.println("Vessel class has been called.");
    }

    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType){
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    public String getVesselId(){ return vesselId; }
    public String getVesselName(){ return vesselName; }
    public double getAverageSpeed(){ return averageSpeed; }
    public String getVesselType(){ return vesselType; }

    public String toString(){
        return vesselId + " | " + vesselName + " | " + vesselType + " | " + averageSpeed + " knots";
    }
}