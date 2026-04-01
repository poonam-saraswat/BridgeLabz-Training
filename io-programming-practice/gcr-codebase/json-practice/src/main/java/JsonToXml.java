import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml{
    public static void main(String[] args) throws Exception{
        JSONObject json = new JSONObject(new String(Files.readAllBytes(Paths.get("data/merged.json"))));
        String xml = XML.toString(json, "Student");

        System.out.println(xml);
    }
}