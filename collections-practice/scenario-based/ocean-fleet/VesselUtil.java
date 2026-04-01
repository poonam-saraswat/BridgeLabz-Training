import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId){
        for(Vessel  v : vesselList){
            if(v.getVesselId().equalsIgnoreCase(vesselId)){
                return v;
            }
        }

        return null;
    }

    public List<Vessel> getHighPerformanceVessels(){
        List<Vessel> vessels = new ArrayList<>();
        double max = Double.MIN_VALUE;

        for(Vessel v : vesselList){
            if(v.getAverageSpeed() > max){
                max = v.getAverageSpeed();
            }
        }

        for(Vessel v : vesselList){
            if(max == v.getAverageSpeed()){
                vessels.add(v);
            }
        }

        return vessels;
    }
}
