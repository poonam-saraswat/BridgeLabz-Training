// Data handling and object layer

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class AddressBook {

    private String name;
    private List<Contact> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public boolean addContact(Contact contact) {
        if(contacts.contains(contact)){
            return false;
        }

        contacts.add(contact);
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact findContactByName(String firstname, String lastname){
        for(Contact c : contacts){
            if(c.getFirstName().equalsIgnoreCase(firstname) && c.getLastName().equalsIgnoreCase(lastname)){
                return c;
            } 
        }
        return null;
    }

    public void removeContact(String firstname, String lastname){
        boolean b = false;
        for(Contact c : contacts){
            if(c.getFirstName().equalsIgnoreCase(firstname) && c.getLastName().equalsIgnoreCase(lastname)){
                contacts.remove(c);
                b = true;
            } 
        }

        if(b) System.out.println("Removed successfully!");
        else System.out.println("Contact not found!");
    }

    public void sortContactsByName() {
        Collections.sort(contacts);
    }

    public void sortByCity() {
        Collections.sort(contacts,
            Comparator.comparing(Contact::getCity, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortByState() {
        Collections.sort(contacts,
            Comparator.comparing(Contact::getState, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortByZip() {
        Collections.sort(contacts,
            Comparator.comparing(Contact::getZip));
    }
}
