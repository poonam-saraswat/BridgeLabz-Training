public class CreatorStats{
    private String creatorName;
    private double[] weeklyLikes;

    public CreatorStats(String creatorName, double[] weeklyLikes){
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }

    public String getCreatorName(){ return creatorName; }
    public double[] getWeeklyLikes(){ return weeklyLikes; }
}