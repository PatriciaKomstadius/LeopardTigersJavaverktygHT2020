package Contacts;

import java.util.ArrayList;

public class ContactManagement {

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void addContact(Contact c) {
        contacts.add(c);
    }

    public static void removeContact(String number) {
        contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number));
        System.out.println("\n---------");
        System.out.println("\nKONTAKT BORTTAGEN!");
    }

    public static void searchFirstName(String firstName) {
        System.out.println("\n| SÖKT |");
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(c);
            }
        }
    }

    public static void searchLastName(String lastName) {
        System.out.println("\n| SÖKT |");
        for (Contact c : contacts) {
            if (c.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(c);
            }
        }
    }

}