/*Phone Contact Organizer
Focus: ArrayList, Strings, Methods, Exception

Scenario:
You are designing a contact organizer for a mobile app.
Requirements:
● Each contact includes Name and Phone Number Handling
● Store contacts in a List<Contact>.
● Allow adding, deleting, and searching.
● If the phone number is not exactly 10 digits, throw InvalidPhoneNumberException.
● Prevent duplicate contacts based on phone number.

*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
public class PhoneContactOrganizer {
    private List<Contact> contacts;

    public PhoneContactOrganizer() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact with this phone number already exists.");
                return;
            }
        }
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    public void deleteContact(String phoneNumber) {
        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
        System.out.println("Contact deleted successfully.");
    }

    public Contact searchContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PhoneContactOrganizer organizer = new PhoneContactOrganizer();
        Scanner scanner = new Scanner(System.in);

        try {
            organizer.addContact("Alice", "1234567890");
            organizer.addContact("Bob", "0987654321");
            organizer.addContact("Charlie", "12345"); // This will throw an exception
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        Contact foundContact = organizer.searchContact("1234567890");
        if (foundContact != null) {
            System.out.println("Found Contact: " + foundContact.getName() + ", " + foundContact.getPhoneNumber());
        } else {
            System.out.println("Contact not found.");
        }

        organizer.deleteContact("0987654321");
        scanner.close();
    }
}
