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
    private Contact contact1 = new Contact("Jane", "Doe", "0707000070");
    private Contact contact2 = new Contact("Joe", "Jenkins", "0123456789");
    private Contact contact3 = new Contact("Youssef", "Al Shadidi", "0734567890");

    @Test
    @DisplayName("Show contacts")
    public void showContactsTest() {

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1);
        contactManagement.addContact(contact2);

        int foundContacts = contactManagement.showContacts();

        assertEquals(2, foundContacts);
    }

    @Test
    @DisplayName("Add contacts")
    public void addContactTest() {
        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1);
        contactManagement.addContact(contact2);
        contactManagement.addContact(contact3);

        List<Contact> addedContacts = new ArrayList<>();
        addedContacts.add(contact1);
        addedContacts.add(contact2);
        addedContacts.add(contact3);

        int foundContacts = contactManagement.showContacts();

        assertEquals(3, foundContacts);
        assertNotEquals(2, foundContacts);
        assertEquals(foundContacts, addedContacts.size());
    }

    @Test
    @DisplayName("Remove contacts")
    public void removeContactTest() {
        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1);
        contactManagement.addContact(contact2);
        contactManagement.addContact(contact3);

        contactManagement.removeContact("0734567890");

        int foundContacts = contactManagement.showContacts();

        List<Contact> addedContacts = new ArrayList<>();
        addedContacts.add(contact1);
        addedContacts.add(contact2);
        addedContacts.add(contact3);

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
