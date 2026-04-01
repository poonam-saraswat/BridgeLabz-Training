import java.util.List;
import java.util.concurrent.*;

public class AsyncAddressBook {

    private AddressBookIO service;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public AsyncAddressBook(AddressBookIO service) {
        this.service = service;
    }

    public void writeAsync(List<Contact> persons) {
        executor.submit(() -> {
            try {
                service.write(persons);
                System.out.println("Saved in background thread");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Future<List<Contact>> readAsync() {
        return executor.submit(() -> service.read());
    }
}