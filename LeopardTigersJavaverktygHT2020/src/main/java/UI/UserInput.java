package UI;

import Contacts.ContactManagement;
import Contacts.Contact;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    private static Scanner scan = new Scanner(System.in);

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
            // scan.nextLine();
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
                default:
                    System.out.println("Please choose one of the options listed above.");
                    break;
            }
        }
    }

    public static void menu() {
        // while (loop) {
        System.out.println();
        System.out.println("========ContactBook========");
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Search contact by last name");
        System.out.println("4. Search contact by first name");
        System.out.println(".5. Show all contacts in contactbook");
        System.out.println("0. Exit");

        //   }
    }

    public static void add() {
        System.out.println("Enter first name of contact: ");
        String firstName = scan.nextLine();

        System.out.println("Enter last name of contact: ");
        String lastName = scan.nextLine();

        System.out.println("Enter phone number: ");
        String number = scan.nextLine();

        Contact c = new Contact(firstName, lastName, number);
        ContactManagement.addContact(c);
        Contacts.ContactManagement.addContact(c, true);

    }

    public static void delete() {
        System.out.print("Enter phone number of contact to delete: ");
        String number = scan.nextLine();

        ContactManagement.removeContact(number);
        Contacts.ContactManagement.removeContact(number, true);


    }

    public static void searchByFirstName() {
        System.out.println("Enter name of contact to search for: ");
        String firstName = scan.nextLine();

        ContactManagement.searchFirstName(firstName);
    }

    public static void searchByLastName() {
        System.out.println("Enter name of contact to search for: ");
        String lastName = scan.nextLine();

        ContactManagement.searchLastName(lastName);
    }

    public static int readInt(){
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter your choice:");
            Integer input = scan.nextInt();
            return input;

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Wrong input, please try again.");
        }
    }

}
