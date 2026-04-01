import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;

public class ExtractByAge{
    public static void main(String[] args) throws Exception{
        String content = new String(Files.readAllBytes(Paths.get("data/mergedData.json")));
        JSONArray data = new JSONArray(content);

        for(int i = 0; i < data.length(); i++){
            JSONObject json = data.getJSONObject(i);
            if(json.getInt("age") > 18){
                String name = json.getString("name");
                int age = json.getInt("age");
                System.out.println("Student: " + name + " age: " + age);
            }
            else {
                continue;
            }
        }
    }
}