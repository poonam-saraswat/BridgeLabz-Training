
public interface AddressBookInterface {

    Contact createContact();

    void addContact(Contact contact);

    void addMultipleContacts();

    void editContact();

    void deleteContacts();

    void sortContacts();

    void searchPersonByCityOrState();

    void viewPersonByCityOrState();

    void countPersonByCityOrState();

    void sortContactsByCityStateOrZip();

    void writeAddressBookToFile();

    void readAddressBookFromFile();

    void readAddressBookFromCSV();

    void writeAddressBookToCSV();
}
