
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class JSONFile implements AddressBookIO {

    private static final String FILE_NAME = "addressbook.json";
    private Gson gson = new Gson();

    @Override
    public void write(List<Contact> persons) throws Exception {
        FileWriter writer = new FileWriter(FILE_NAME);
        gson.toJson(persons, writer);
        writer.flush();
        writer.close();
    }

    @Override
    public List<Contact> read() throws Exception {
        FileReader reader = new FileReader(FILE_NAME);
        Type listType = new TypeToken<List<Contact>>(){}.getType();
        return gson.fromJson(reader, listType);
    }
}