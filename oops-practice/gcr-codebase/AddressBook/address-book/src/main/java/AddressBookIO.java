import java.util.List;

public interface AddressBookIO {

    void write(List<Contact> persons) throws Exception;

    List<Contact> read() throws Exception;
}