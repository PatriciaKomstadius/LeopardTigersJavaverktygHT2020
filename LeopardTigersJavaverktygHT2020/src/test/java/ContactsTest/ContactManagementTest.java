package ContactsTest;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import Contacts.Contact;
import Contacts.ContactManagement;

import java.util.ArrayList;
import java.util.List;

public class ContactManagementTest {

    @Test
    @DisplayName("Show contacts")
    public void showContactsTest() {
        Contact contact1 = new Contact("Jane", "Doe", "0707000070");
        Contact contact2 = new Contact("Joe", "Jenkins", "0123456789");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1);
        contactManagement.addContact(contact2);

        int foundContacts = contactManagement.showContacts();

        assertEquals(2, foundContacts);
    }

    @Test
    @DisplayName("Add contacts")
    public void addContactTest() {
        Contact contact3 = new Contact("Jane", "Doe", "0707000070");
        Contact contact4 = new Contact("Joe", "Jenkins", "0123456789");
        Contact contact5 = new Contact("Youssef", "Al Shadidi", "0734567890");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact3);
        contactManagement.addContact(contact4);
        contactManagement.addContact(contact5);

        List<Contact> addedContacts = new ArrayList<>();
        addedContacts.add(contact3);
        addedContacts.add(contact4);
        addedContacts.add(contact5);

        int foundContacts = contactManagement.showContacts();

        assertEquals(3, foundContacts);
        assertNotEquals(2, foundContacts);
        assertEquals(foundContacts, addedContacts.size());
    }

    @Test
    @DisplayName("Remove contacts")
    public void removeContactTest() {
        Contact contact6 = new Contact("Jane", "Doe", "0707000070");
        Contact contact7 = new Contact("Joe", "Jenkins", "0123456789");
        Contact contact8 = new Contact("Youssef", "Al Shadidi", "0734567890");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact6);
        contactManagement.addContact(contact7);
        contactManagement.addContact(contact8);

        contactManagement.removeContact("0734567890");

        int foundContacts = contactManagement.showContacts();

        List<Contact> addedContacts = new ArrayList<>();
        addedContacts.add(contact6);
        addedContacts.add(contact7);
        addedContacts.add(contact8);

        assertEquals(2, foundContacts);
        assertNotEquals(3, foundContacts);
        assertNotEquals(addedContacts, foundContacts);

    }

    @Test
    @DisplayName("Search First Name")
    public void searchFirstNameTest() {
        Contact contact = new Contact("Jane", "Doe", "0707000070");
        ContactManagement.addContact(contact);

        assertTrue(contact.getFirstName().equals("Jane"));
        assertNotEquals("Joe", contact.getFirstName());
        assertNotNull(contact);
    }

    @Test
    @DisplayName("Search Last Name")
    public void searchLastNameTest() {
        Contact contact = new Contact("Jane", "Doe", "0707000070");
        ContactManagement.addContact(contact);

        assertTrue(contact.getLastName().equals("Doe"));
        assertNotEquals("Jenkins", contact.getLastName());
        assertNotNull(contact);
    }
}
