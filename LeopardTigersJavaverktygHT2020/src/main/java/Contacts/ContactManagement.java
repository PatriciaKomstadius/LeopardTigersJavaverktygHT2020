package Contacts;

import ContactsIO.ContactsIO;

import java.util.*;

public class ContactManagement {

    private ContactsIO io = new ContactsIO("ContactBook.txt");
    private final Set<Contact> contacts = new HashSet<>(io.readContacts());

    public Set<Contact> getContacts() {

        return contacts;
    }


    public int showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
        return this.contacts.size();
    }

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void addContact(Contact c, boolean writeToFile) {
        if (contacts.add(c)) {
            if (writeToFile) {
                io.writeContact(c);
            }
        }
    }


    public void removeContact(String number) {
        contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number));
    }

    public void removeContact(String number, boolean removeFromFile) {
        if (contacts.removeIf(c -> c.getNumber().equalsIgnoreCase(number))) {
            if (removeFromFile) {
                for (Contact contact : contacts) {
                    io.writeContact(contact);
                }
            }
        }
    }


    public void searchFirstName(String firstName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(c);
            }
        }
    }

    public void searchLastName(String lastName) {
        for (Contact c : contacts) {
            if (c.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(c);
            }
        }
    }

    //TEST JUNIT
    public List<Contact> search(String value) {

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