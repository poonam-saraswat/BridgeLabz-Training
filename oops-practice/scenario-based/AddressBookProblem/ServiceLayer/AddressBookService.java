package service;

import dao.AddressBookDAO;
import model.Contact;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookService {
    // UC6: Multiple Address Books
    private Map<String, AddressBookDAO> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {
        addressBooks.put(name, new AddressBookDAO());
    }

    public AddressBookDAO getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // UC7: Add contact with duplicate check
    public void addContact(String bookName, Contact contact) {
        AddressBookDAO dao = addressBooks.get(bookName);
        if (dao.findByName(contact.getFirstName()) == null) {
            dao.addContact(contact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Duplicate entry found!");
        }
    }

    public void editContact(String bookName, String name, String newPhone) {
        AddressBookDAO dao = addressBooks.get(bookName);
        Contact c = dao.findByName(name);
        if (c != null) {
            c.setPhone(newPhone);
            System.out.println("Contact updated!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void deleteContact(String bookName, String name) {
        AddressBookDAO dao = addressBooks.get(bookName);
        dao.deleteContact(name);
        System.out.println("Contact deleted!");
    }

    public List<Contact> getAllContacts(String bookName) {
        return addressBooks.get(bookName).getAllContacts();
    }

    // UC8: Search across books
    public List<Contact> searchByCity(String city) {
        return addressBooks.values().stream()
                .flatMap(dao -> dao.getAllContacts().stream())
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchByState(String state) {
        return addressBooks.values().stream()
                .flatMap(dao -> dao.getAllContacts().stream())
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC9 & UC10: View and count persons by city/state
    public Map<String, List<Contact>> groupByCity() {
        return addressBooks.values().stream()
                .flatMap(dao -> dao.getAllContacts().stream())
                .collect(Collectors.groupingBy(Contact::getCity));
    }

    public Map<String, List<Contact>> groupByState() {
        return addressBooks.values().stream()
                .flatMap(dao -> dao.getAllContacts().stream())
                .collect(Collectors.groupingBy(Contact::getState));
    }

    // UC11 & UC12: Sorting
    public List<Contact> sortByName(String bookName) {
        List<Contact> list = addressBooks.get(bookName).getAllContacts();
        list.sort(Comparator.comparing(Contact::getFirstName));
        return list;
    }

    public List<Contact> sortByCity(String bookName) {
        List<Contact> list = addressBooks.get(bookName).getAllContacts();
        list.sort(Comparator.comparing(Contact::getCity));
        return list;
    }

    public List<Contact> sortByState(String bookName) {
        List<Contact> list = addressBooks.get(bookName).getAllContacts();
        list.sort(Comparator.comparing(Contact::getState));
        return list;
    }

    public List<Contact> sortByZip(String bookName) {
        List<Contact> list = addressBooks.get(bookName).getAllContacts();
        list.sort(Comparator.comparing(Contact::getZip));
        return list;
    }
}