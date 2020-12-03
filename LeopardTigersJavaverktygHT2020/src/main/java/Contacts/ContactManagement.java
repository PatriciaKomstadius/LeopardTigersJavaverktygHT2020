package Contacts;

import ContactsIO.ContactsIO;

import java.util.ArrayList;

public class ContactManagement {

    private static ContactsIO io = new ContactsIO("Contactbook.txt");
    private static final ArrayList<Contact> contacts = new ArrayList<>(io.readContacts());

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void addContact(Contact c) {
        contacts.add(c);
        io.writeContact(c);
    }

    public static void removeContact(String number) {
        contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number));
        io.reWriteContacts();
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

<<<<<<< HEAD

    public static void saveContact(Contact c){

        io.writeContact(c);
    }

=======
>>>>>>> 4e968bfdf95990439cb275d5f3bdb14efffd3f26
}
