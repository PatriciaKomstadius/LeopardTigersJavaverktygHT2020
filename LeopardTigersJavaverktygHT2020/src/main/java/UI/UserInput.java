package UI;

import Contacts.ContactManagement;
import Contacts.Contact;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Contacts.ContactManagement.search;


public class UserInput {

    private static Scanner scan = new Scanner(System.in);


    public static void menu() {

        System.out.println();
        System.out.println("========ContactBook========");
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Search contact by forname");
        System.out.println("4. Search contact by last name");
        System.out.println("5. Show all contacts in contactbook");
        System.out.println("0. Exit");

    }

    public static void menuChoice() {

        Integer number = 0;
        boolean loop = true;

        while (loop) {
            UserInput ui = new UserInput();

            try {
                number = readInt();

                loop=false;

            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
            }

            switch (number) {
                case 0:
                    loop = false;
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    searchByFirstName();
                    break;
                case 4:
                    searchByLastName();
                    break;
                case 5:
                    ContactManagement.showContacts();
                    break;
                case 6:
                    consoleSearch();
                    break;
                case 7:
                    searchAndDelete();
                    break;
                default:
                    System.out.println("Please choose one of the options listed above.");
                    break;
            }
        }
    }

    public static void add() {

           System.out.println("Enter first name: ");
           String firstName = scan.nextLine();

           System.out.println("Enter last name: ");
           String lastName = scan.nextLine();

           System.out.println("Enter phone number: ");
           String number = scan.nextLine();

           Contact c = null;

           try {

               c = new Contact(firstName, lastName, number);

           } catch (Exception e) {
               System.out.println("Could not instantiate this contact. Details: " +e);
           }

           try {

               if (c != null) {
                   Contacts.ContactManagement.addContact(c, true);

               } else {
                   System.out.println("There is no contact to save");
               }

       } catch (Exception e) {

           System.out.println("Sorry, could not save the contact. Details: " +e);

       }
    }

    public static void delete() {


        System.out.print("Enter phone number to delete contact: ");
        String number = scan.nextLine();


        Contacts.ContactManagement.removeContact(number, true);

    }

    public static void consoleSearch() {

        System.out.println("Enter your search term: ");
        Scanner scan = new Scanner(System.in);

        String value = scan.nextLine();

        List<Contact> result = search(value);

        for (int i = 0; i < result.size(); i++) {
            Contact c = result.get(i);
            System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getNumber());
        }
    }

    //TEST JUNIT
    public static void searchAndDelete() {

        System.out.println("Search for the contact you want to delete: ");
        Scanner scan = new Scanner(System.in);

        String value = scan.nextLine();


        List<Contact> result = search(value);

        if (result.size() != 0) {

            for (int i = 0; i < result.size(); i++) {
                Contact c = result.get(i);
                System.out.println(i + " " + c.getFirstName() + " " + c.getLastName() + " " + c.getNumber());
            }
            System.out.println("Select the index of the contact you want to delete: ");

            int indexNr = scan.nextInt();
            scan.nextLine();
            Contact selectedContact = result.get(indexNr);
            System.out.println("Selected contact:" + selectedContact.getFirstName() + selectedContact.getLastName());
            System.out.println("Would you like to delete this contact? (y/n)");

            String input = scan.nextLine();

            switch (input) {

                case "y":
                    try {
                        ContactManagement.removeContact(selectedContact.getNumber());
                        System.out.println("Contact has been deleted");
                    } catch (Exception e) {
                        System.out.println("Error: Contact was not deleted. Details: " + e);
                    }

                    break;
                case "n":
                    System.out.println("Contact deletion was cancelled.");
                    break;
                default:
                    break;
            }

        } else {

            System.out.println("No contacts found.");

        }

    }



    public static void searchByFirstName() {
        System.out.println("Enter first name: ");
        String firstName = scan.nextLine();

        ContactManagement.searchFirstName(firstName);
    }

    public static void searchByLastName() {
        System.out.println("Enter last name: ");
        String lastName = scan.nextLine();

        ContactManagement.searchLastName(lastName);
    }

    public static int readInt(){
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter your choice (Press 0 to quit):");
            Integer input = scan.nextInt();
            if (input == 0) {
                System.exit(0);
            }
            return input;

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Wrong input, please try again.");
        }
    }

}
