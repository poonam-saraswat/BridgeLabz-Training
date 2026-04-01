import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    public void RegisterCreator(CreatorStats record){
        engagementBoard.add(record);
    }

    public Map<String, Integer> GetTopPostCounts(double likeThreshold){
        Map<String, Integer> map = new HashMap<>();

        for(CreatorStats record : engagementBoard){
            int count = 0;
            for(double d : record.getWeeklyLikes()){
                if(d >= likeThreshold){
                    count++;
                }
            }

            if(count > 0){
                map.put(record.getCreatorName(), count);
            }
        }

        return map;
    }

    public double CalculateAverageLikes(){
        double totalLikes = 0.0;
        int total = 0;

        for(CreatorStats creator : engagementBoard){
            for(double likes : creator.getWeeklyLikes()){
                totalLikes += likes;
                total++;
            }
        }

        if(total == 0) { return 0.0; }

        return totalLikes/total;
    }
}
