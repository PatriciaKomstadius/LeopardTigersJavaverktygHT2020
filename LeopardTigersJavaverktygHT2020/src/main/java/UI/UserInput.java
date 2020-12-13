package UI;

import Contacts.ContactManagement;
import Contacts.Contact;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static ContactManagement contactManagement = new ContactManagement("ContactBook.txt");
    private static Scanner scan = new Scanner(System.in);

    public static void menu() {

        System.out.println();
        System.out.println("========ContactBook========");
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Search for contact");
        System.out.println("4. Show all contacts in contactbook");
        System.out.println("0. Exit");

    }

    public static void selectFromMenu() {

        Integer number = 0;
        boolean loop = true;

        while (loop) {

            try {
                number = readInt();
                loop = false;

            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
            }

            switch (number) {
                case 0:
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    searchAndDelete();
                    break;
                case 3:
                    consoleSearch();
                    break;
                case 4:
                    contactManagement.showContacts();
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

        boolean loop = true;

        while (loop) {
            System.out.println("Enter phone number: ");
            String number = scan.nextLine();

            try {

                if (checkNumber(number) == true) {

                    loop = false;
                    Contact c = new Contact(firstName, lastName, number);
                    contactManagement.addContact(c, true);
                    System.out.println("Contact saved.");

                } else {
                        System.out.println("The number is too short. Please enter a number of minimum 8 digits");

                }
            } catch (Exception e) {
                System.out.println("Sorry, could not save the contact. Details: " + e);
            }
        }
    }

    public static boolean checkNumber(String number) {

        try {
            if (number.length() >= 8) {
                return true;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong input, try again.");
        }
        return false;
    }

    public static void consoleSearch() {

        System.out.println("Enter your search term: ");
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();

        List<Contact> result = contactManagement.search(value);

        for (int i = 0; i < result.size(); i++) {
            Contact c = result.get(i);
            System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getNumber());
        }
    }

    public static void searchAndDelete() {

        System.out.println("Search for the contact you want to delete: ");
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();

        List<Contact> result = contactManagement.search(value);

        if (result.size() != 0) {

            for (int i = 0; i < result.size(); i++) {
                Contact c = result.get(i);
                System.out.println(i + " " + c.getFirstName() + " " + c.getLastName() + " " + c.getNumber());
            }

            int indexNr = 0;
            boolean loop = true;

            while (loop) {

                try {
                    indexNr = readIntForSearchAndDelete();

                    if (indexNr > result.size()) {
                        System.out.println("Error in index input: Enter index of the contact to delete");

                    } else {
                        loop = false;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Error: You need to enter a digit");
                }
            }

            Contact selectedContact = result.get(indexNr);

            System.out.println("Selected contact:" + selectedContact.getFirstName() + " " + selectedContact.getLastName());
            System.out.println("Would you like to delete this contact? (y/n)");

            String input = scan.nextLine();

            switch (input) {

                case "y":
                    try {
                        contactManagement.removeContact(selectedContact.getNumber(), true);
                        System.out.println("Contact has been deleted.");

                    } catch (Exception e) {
                        System.out.println("Error: Contact was not deleted. Details: " + e);
                    }
                    break;
                case "n":
                    System.out.println("Contact deletion was cancelled.");
                    break;
                default:
                    System.out.println("Invalid input. You're being redirected back to the menu.");
                    break;
            }
        } else {
            System.out.println("No contacts found.");
        }
    }

    public static int readInt() {
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

    public static int readIntForSearchAndDelete() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Select the index of the contact you want to delete: ");
            Integer input = scan.nextInt();
            return input;

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Wrong input, please try again.");
        }
    }

}
