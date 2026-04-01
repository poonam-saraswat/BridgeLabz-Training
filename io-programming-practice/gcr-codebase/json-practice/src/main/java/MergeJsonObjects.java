import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;

public class MergeJsonObjects{
    public static void main(String[] args) throws Exception {
        JSONObject content = new JSONObject(new String(Files.readAllBytes(Paths.get("data/file1.json"))));
        JSONObject content1 = new JSONObject (new String(Files.readAllBytes(Paths.get("data/file2.json"))));

        JSONArray arr = new JSONArray();

        for(String key : content1.keySet()){
            content.put(key, content1.get(key));
        }

        arr.put(content);

        try(FileWriter writer = new FileWriter("data/merged.json")){
            writer.write(arr.toString(2));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}