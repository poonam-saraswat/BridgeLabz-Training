import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.json.JSONArray;

public class MergeJson{
    public static void main(String[] args) throws Exception{
        String content1 = new String(Files.readAllBytes(Paths.get("data/Student.json")));
        String content2 = new String(Files.readAllBytes(Paths.get("data/Student1.json")));

        JSONArray students1 = new JSONArray(content1);
        JSONArray students2 = new JSONArray(content2);

        for(int i = 0; i < students2.length(); i++){
            JSONObject json = students2.getJSONObject(i);
            students1.put(json);
        }

        try(FileWriter writer = new FileWriter("data/mergedData.json")){
            writer.write(students1.toString(2));
            System.out.println("Merged file successfully!");
        }
        catch(IOException e){
            System.out.println("Error!");
        }
    }
}