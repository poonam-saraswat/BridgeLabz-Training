import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;

public class ExtractData{
    public static void main(String[] args) throws Exception{
        String content = new String(Files.readAllBytes(Paths.get("data/Student.json")));
        JSONArray students = new JSONArray(content);

        for(int i = 0; i < students.length(); i++){
            JSONObject json = students.getJSONObject(i);

            String name = json.getString("name");
            double cgpa = json.getDouble("CGPA");

            System.out.println("Student name: " + name + " and CGPA: " + cgpa);
        }
    }
}