package Contacts;

import ContactsIO.ContactsIO;

import java.util.*;

public class ContactManagement {

    private static ContactsIO io = new ContactsIO("ContactBook.txt");
    private static final Set<Contact> contacts = new HashSet<>(io.readContacts());

    public static Set<Contact> getContacts() {

        return contacts;
    }


    public static int showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
        return Contacts.ContactManagement.contacts.size();
    }

    public static void addContact(Contact c) {
        contacts.add(c);
    }

    public static void addContact(Contact c, boolean writeToFile) {
        if (contacts.add(c)) {
            if (writeToFile) {
                io.writeContact(c);
            }
        }
    }


    public static void removeContact(String number) {
        contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number));
    }

    public static void removeContact(String number, boolean removeFromFile) {
        if (contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number))) {
            if (removeFromFile) {
                io.reWriteContacts();
            }
        }
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

    //TEST JUNIT
    public static List<Contact> search(String value) {

        List<Contact> result = new ArrayList<Contact>();

        for (Contact c : contacts) {

            String contact = c.getFirstName() + " " + c.getLastName() + " " + c.getNumber();

            if (contact.toLowerCase().contains(value.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }



}