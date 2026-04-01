// The main class - presentation layer

import java.util.Scanner;

public class Main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("--------------- Welcome to Address Book Program ---------------");

        boolean b = true;

        AddressBookInterface  manager = new AddressBookManager();

        while(b){
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // Usecase - 1
                case 1:
                    Contact c = manager.createContact();
                    System.out.println(c);
                    System.out.println("Created Successfully!");
                    break;
                
                // Usecase - 2
                case 2:
                    Contact contact = manager.createContact();
                    manager.addContact(contact);
                    break;

                // Usecase - 5
                case 3:
                    manager.addMultipleContacts();
                    break;
                
                // Usecase - 3
                case 4:
                    manager.editContact();
                    break;
                
                // Usecase - 4
                case 5:
                    manager.deleteContacts();
                    break;

                // Usecase - 8
                case 6:
                    manager.searchPersonByCityOrState();
                    break;

                // Usecase - 9
                case 7: 
                    manager.viewPersonByCityOrState();
                    break;
                
                // Usecase - 10
                case 8:
                    manager.countPersonByCityOrState();
                    break;
                
                // Usecase - 11
                case 9:
                    manager.sortContacts();
                    break;

                // Usecase - 12
                case 10:
                    manager.sortContactsByCityStateOrZip();
                    break;
                
                // Usecase - 13
                case 11:
                    manager.writeAddressBookToFile();
                    break;
                
                case 12:
                    manager.readAddressBookFromFile();
                    break;

                // Usecase - 14
                case 13:
                    manager.readAddressBookFromCSV();
                    break;
                
                case 14:
                    manager.writeAddressBookToCSV();
                    break;

                case 15:
                    b = false;
                    break;

                default:
                    break;
            
            }
        }

        AddressBookIO fileService = new JSONFile();
        AsyncAddressBook async = new AsyncAddressBook(fileService);

        async.writeAsync(addressBook.getPersonList());

    } 

    private static void displayMenu(){
        System.out.println("\n---------- MENU ----------");
        System.out.println("1. Create Contact");
        System.out.println("2. Add a Contact");
        System.out.println("3. Add multiple Contacts");
        System.out.println("4. Edit a Contact");
        System.out.println("5. Delete a Contact");
        System.out.println("6. Search Person by a city or state.");
        System.out.println("7. View Persons by a city or state.");
        System.out.println("8. Count Persons by city or state.");
        System.out.println("9. Sort Contacts Alphabetically by names.");
        System.out.println("10. Sort Contacts by city/state/zip.");
        System.out.println("11. Write addressbook to file.");
        System.out.println("12. Read addressbook from file.");
        System.out.println("13. Write addressbook to CSV.");
        System.out.println("14. Read addressbook from CSV.");
        System.out.println("15. Exit.");
    }
}
