import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidateJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String content = new String(Files.readAllBytes(Paths.get("data/Student.json")));
            mapper.readTree(content);  
            System.out.println("JSON is valid");

        } catch (Exception e) {
            System.out.println("Invalid JSON structure");
        }
    }
}
