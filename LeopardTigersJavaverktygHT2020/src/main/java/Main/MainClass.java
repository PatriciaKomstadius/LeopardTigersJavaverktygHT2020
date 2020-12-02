//Hej Patricia! Om du ser detta, har du senaste versionen.

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {

        while (loop) {
            System.out.println();
            System.out.println("========ContactBook========");
            System.out.println("1. Add contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Search for contact");
            System.out.println("4. Show all contacts in contactbook");
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
                        search();
                        break;
                    case 4:
                        ContactManagement.showContacts();
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
        System.out.println("Enter name of contact: ");
        String name = scan.nextLine();

        System.out.println("Enter phone number: ");
        String number = scan.nextLine();

        Contact c = new Contact(name, number);
        ContactManagement.addContact(c);

    }

    public static void delete() {
        System.out.print("Enter phone number of contact to delete: ");
        String number = scan.nextLine();

        ContactManagement.deleteContact(number);

    }

    public static void search() {
        System.out.println("Enter name of contact to search for: ");
        String contact = scan.nextLine();

        ContactManagement.findContact(contact);
    }

}

