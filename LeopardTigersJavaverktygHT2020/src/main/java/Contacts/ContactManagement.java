package Contacts;

import ContactsIO.ContactsIO;

import java.util.ArrayList;

public class ContactManagement {

    private static ContactsIO io = new ContactsIO("Contactbook.txt");
    private static final ArrayList<Contact> contacts = new ArrayList<>(io.readContacts());

    public static void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void addContact(Contact c) {
        contacts.add(c);
        saveContact(c);
    }

    public static void removeContact(String number) {
        contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number));
    }

    public static void searchFirstName(String firstName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(c);
            }
        }
    }

    public static void searchLastName(String lastName) {
        for (Contact c : contacts) {
            if (c.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(c);
            }
        }
    }


    public static void saveContact(Contact c){
        io.writeContact(c);
    }

}
