package presentation;

import service.AddressBookService;
import model.Contact;
import java.util.Scanner;
import java.util.Map;
import java.util.List;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();

        System.out.println("Welcome to Address Book Program!");

        // UC6: Create default Address Book
        service.addAddressBook("FriendsBook");

        while (true) {
            System.out.println("\n========= Address Book Menu =========");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View All Contacts");
            System.out.println("5. Search Persons by City");
            System.out.println("6. Search Persons by State");
            System.out.println("7. Sort Contacts by Name");
            System.out.println("8. Sort Contacts by City");
            System.out.println("9. Sort Contacts by State");
            System.out.println("10. Sort Contacts by Zip");
            System.out.println("11. Group Persons by City");
            System.out.println("12. Group Persons by State");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // UC2
                    System.out.print("Enter First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String ln = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter State: ");
                    String state = sc.nextLine();
                    System.out.print("Enter Zip: ");
                    String zip = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Contact c = new Contact(fn, ln, addr, city, state, zip, phone, email);
                    service.addContact("FriendsBook", c);
                    break;

                case 2: // UC3
                    System.out.print("Enter Name to Edit: ");
                    String nameEdit = sc.nextLine();
                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();
                    service.editContact("FriendsBook", nameEdit, newPhone);
                    break;

                case 3: // UC4
                    System.out.print("Enter Name to Delete: ");
                    String nameDel = sc.nextLine();
                    service.deleteContact("FriendsBook", nameDel);
                    break;

                case 4: // UC5
                    System.out.println("All Contacts:");
                    for (Contact contact : service.getAllContacts("FriendsBook")) {
                        System.out.println(contact);
                    }
                    break;

                case 5: // UC8
                    System.out.print("Enter City: ");
                    String citySearch = sc.nextLine();
                    List<Contact> cityResults = service.searchByCity(citySearch);
                    if (cityResults.isEmpty()) {
                        System.out.println("No contacts found in city " + citySearch);
                    } else {
                        cityResults.forEach(System.out::println);
                    }
                    break;

                case 6: // UC8
                    System.out.print("Enter State: ");
                    String stateSearch = sc.nextLine();
                    List<Contact> stateResults = service.searchByState(stateSearch);
                    if (stateResults.isEmpty()) {
                        System.out.println("No contacts found in state " + stateSearch);
                    } else {
                        stateResults.forEach(System.out::println);
                    }
                    break;

                case 7: // UC11
                    System.out.println("Sorted by Name:");
                    service.sortByName("FriendsBook").forEach(System.out::println);
                    break;

                case 8: // UC12
                    System.out.println("Sorted by City:");
                    service.sortByCity("FriendsBook").forEach(System.out::println);
                    break;

                case 9: // UC12
                    System.out.println("Sorted by State:");
                    service.sortByState("FriendsBook").forEach(System.out::println);
                    break;

                case 10: // UC12
                    System.out.println("Sorted by Zip:");
                    service.sortByZip("FriendsBook").forEach(System.out::println);
                    break;

                case 11: // UC9 & UC10
                    System.out.println("Persons grouped by City:");
                    Map<String, List<Contact>> cityGroups = service.groupByCity();
                    cityGroups.forEach((cityName, contacts) -> {
                        System.out.println(cityName + " -> Count: " + contacts.size());
                        contacts.forEach(System.out::println);
                    });
                    break;

                case 12: // UC9 & UC10
                    System.out.println("Persons grouped by State:");
                    Map<String, List<Contact>> stateGroups = service.groupByState();
                    stateGroups.forEach((stateName, contacts) -> {
                        System.out.println(stateName + " -> Count: " + contacts.size());
                        contacts.forEach(System.out::println);
                    });
                    break;

                case 13:
                    System.out.println("Exiting Address Book... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}