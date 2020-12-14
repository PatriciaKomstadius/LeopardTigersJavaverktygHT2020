package Contacts;

import ContactsIO.ContactsIO;

import java.util.*;

public class ContactManagement {

    private ContactsIO io;
    private final Set<Contact> contacts;

    public ContactManagement() {
         this.contacts = new HashSet<>();
    }

    public ContactManagement(String fileName) {
        this.io = new ContactsIO(fileName);
        this.contacts = new HashSet<>(io.readContacts());
    }

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
                io.clearContacts();
                for (Contact contact : contacts) {
                    io.writeContact(contact);
                }
            }
        }
    }

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