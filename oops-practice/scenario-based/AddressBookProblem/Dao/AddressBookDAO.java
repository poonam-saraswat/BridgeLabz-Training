package dao;

import model.Contact;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDAO {
    private List<Contact> contacts = new ArrayList<>();

    // UC2: Add new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // UC5: Get all contacts
    public List<Contact> getAllContacts() {
        return contacts;
    }

    // UC3: Find contact by name
    public Contact findByName(String name) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(name) || c.getLastName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // UC4: Delete contact
    public void deleteContact(String name) {
        contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(name) || c.getLastName().equalsIgnoreCase(name));
    }
}