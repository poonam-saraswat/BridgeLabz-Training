import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;

public class ValidateEmail {

    public static void main(String[] args) {

        try {
            JSONObject json = new JSONObject(new JSONTokener(new FileInputStream("data/email-schema.json")));
            Schema schema = SchemaLoader.load(json);

            JSONObject jsonData = new JSONObject();
            jsonData.put("email", "student@example.com");
            schema.validate(jsonData);
            System.out.println("Email is valid");

        } catch (ValidationException e) {
            System.out.println("Invalid email format");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
