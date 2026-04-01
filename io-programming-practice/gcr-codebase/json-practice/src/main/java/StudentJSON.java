import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON{
    public static void main(String[] args){
        JSONObject json = new JSONObject();
        json.put("name", "Alankrati");
        json.put("age", 21);

        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Science");
        subjects.put("English");

        json.put("subjects", subjects);

        System.out.println(json.toString(2));
    }
}