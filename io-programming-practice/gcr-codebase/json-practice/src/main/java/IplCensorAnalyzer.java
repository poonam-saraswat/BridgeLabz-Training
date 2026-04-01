import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class IplCensorAnalyzer {

    public static void main(String[] args) throws Exception {
        censorJson();
        censorCsv();
        System.out.println("IPL data censored successfully!");
    }

    private static String maskTeamName(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }

    private static String redactPlayer() {
        return "REDACTED";
    }


    private static void censorJson() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("data/IPLData.json")));

        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            obj.put("team1", maskTeamName(obj.getString("team1")));
            obj.put("team2", maskTeamName(obj.getString("team2")));
            obj.put("winner", maskTeamName(obj.getString("winner")));

            obj.put("player_of_match", redactPlayer());

            JSONObject score = obj.getJSONObject("score");
            JSONObject newScore = new JSONObject();

            Iterator<String> keys = score.keys();
            while (keys.hasNext()) {
                String team = keys.next();
                newScore.put(maskTeamName(team), score.getInt(team));
            }

            obj.put("score", newScore);
        }

        try (FileWriter writer = new FileWriter("data/matches_censored.json")) {
            writer.write(array.toString(2));
        }
    }

    private static void censorCsv() throws Exception {

    List<String> lines = Files.readAllLines(Paths.get("data/IPLData.csv"));

    FileWriter writer = new FileWriter("data/matches_censored.csv");
    writer.write(lines.get(0) + "\n");

    for (int i = 1; i < lines.size(); i++) {

        String[] parts = lines.get(i).split(",");

        if (parts.length != 7) {
            System.out.println("Skipping invalid row: " + lines.get(i));
            continue;
        }

        parts[1] = maskTeamName(parts[1]); 
        parts[2] = maskTeamName(parts[2]); 
        parts[5] = maskTeamName(parts[5]); 

       
        parts[6] = redactPlayer();

        writer.write(String.join(",", parts) + "\n");
    }

    writer.close();
}

}
