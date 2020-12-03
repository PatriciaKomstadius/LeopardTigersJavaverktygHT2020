//Hej Patricia! Om du ser detta, har du senaste versionen.

<<<<<<< HEAD
package Main;

package Main;

import Contacts.Contact;
import ContactsIO.ContactsIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan = new Scanner(System.in);
    static boolean loop = true;
    private static ContactsIO io = new ContactsIO("Contactbook.txt");

    public static void main(String[] args) {

        while (loop) {
            System.out.println();
            System.out.println("========ContactBook========");
            System.out.println("1. Add contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Search contact by last name");
            System.out.println("4. Search contact by first name");
            System.out.println(".5. Show all contacts in contactbook");
            System.out.println("0. Exit");

            menu();
        }
    }

    public static void menu() {
        int choice = 0;

        while (loop) {
            System.out.println("Enter your choice:");

            try {
                choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {

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
                        Contacts.ContactManagement.showContacts();
                        break;
                    default:
                        System.out.println("Please chose one of the options listed above.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
                scan.nextLine();
            }
        }

    }

    public static void add() {
        System.out.println("Enter first name of contact: ");
        String firstName = scan.nextLine();

        System.out.println("Enter last name of contact: ");
        String lastName = scan.nextLine();

        System.out.println("Enter phone number: ");
        String number = scan.nextLine();


        Contacts.Contact c = new Contacts.Contact(firstName, lastName, number);
        Contacts.ContactManagement.addContact(c);

        Contact c = new Contact(name, number);
        ContactManagement.addContact(c);

        Contacts.Contact c = new Contacts.Contact(firstName, lastName, number);
        Contacts.ContactManagement.addContact(c);
        saveContact(c);


    }

    public static void delete() {
        System.out.print("Enter phone number of contact to delete: ");
        String number = scan.nextLine();

        Contacts.ContactManagement.removeContact(number);

    }

    public static void searchByFirstName() {
        System.out.println("Enter first name of contact to search for: ");
        String firstName = scan.nextLine();

        Contacts.ContactManagement.searchFirstName(firstName);
    }
 
    public static void searchByLastName() {
        System.out.println("Enter last name of contact to search for: ");
        String lastName = scan.nextLine();

        Contacts.ContactManagement.searchLastName(lastName);
    }

    public static void saveContact(Contact c){
        io.writeContact(c);
    }

}

