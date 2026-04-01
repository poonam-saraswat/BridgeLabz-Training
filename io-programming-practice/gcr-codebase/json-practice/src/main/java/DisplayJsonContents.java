import java.nio.file.*;
import java.util.Iterator;

import org.json.*;

public class DisplayJsonContents{
    public static void main(String[] args) throws Exception{
        String content = new String(Files.readAllBytes(Paths.get("data/mergedData.json")));
        JSONArray arr = new JSONArray(content);

        for(int i = 0; i < arr.length(); i++){
            JSONObject json = arr.getJSONObject(i);
            Iterator<String> keyNames = json.keys();

            while(keyNames.hasNext()){
                String k = keyNames.next();
                Object value = json.get(k);

                System.out.println("key: " + k + " value: " + value);
            }
        }
    }
}