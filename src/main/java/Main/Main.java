package Main;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {

        showMenu();

        while (loop) {
            menu();
        }

    }

    public static void showMenu() {

        System.out.println();
        System.out.println("========ContactBook========");
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Search for contact");
        System.out.println("4. Show all contacts in contactbook");
        System.out.println("0. Exit");
    }

    public static void menu() {

        int choice = readInt("Enter your choice:");

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
                break;
            default:
                System.out.println("Please chose one of the options listed above.");
                break;
        }
    }

    public static int readInt(String question) {
        int num = 0;
        boolean loop1 = true;

        while (loop1) {
            System.out.println(question);
            try {
                num = scan.nextInt();
                loop1 = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
            }

            scan.nextLine();
        }
        return num;
    }

    public static void add() {
        System.out.println("Enter name of contact: ");
        String name = scan.nextLine();

        System.out.println("Enter phonenumber: ");
        String number = scan.nextLine();

        System.out.println("New contact added successfully.");

        //Contact contact = new Contact(name, number);
        //ContactManagement.addContact(contact);

    }

    public static String add(String name, String number){
        return name+number;
    }

    public static void delete() {
        System.out.print("Enter phonenumber of contact to delete: ");
        String contactToDelete = scan.nextLine();

        //ContactManagement.deleteContact(contact);

        System.out.println("Contact removed.");
    }

    public static void search() {
        System.out.println("Enter name of contact to search for: ");
        String contact = scan.nextLine();

        // ContactManagement.search(contact);
    }
}


