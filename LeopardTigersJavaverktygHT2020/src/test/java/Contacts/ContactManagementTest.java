package Contacts;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ContactManagementTest {

    @Test
    @DisplayName("Show contacts")
    public void showContactsTest() {
        Contact contact1 = new Contact("Jane", "Doe", "0707000070");
        Contact contact2 = new Contact("Joe", "Jenkins", "0123456789");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1, false);
        contactManagement.addContact(contact2, false);

        int foundContacts = contactManagement.showContacts();

        assertEquals(2, foundContacts);
    }

    @Test
    @DisplayName("Add contacts")
    public void addContactTest() {
        Contact contact1 = new Contact("Jane", "Doe", "0707000070");
        Contact contact2 = new Contact("Joe", "Jenkins", "0123456789");
        Contact contact3 = new Contact("Youssef", "Al Shadidi", "0734567890");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1, false);
        contactManagement.addContact(contact2, false);
        contactManagement.addContact(contact3, false);

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
        Contact contact1 = new Contact("Jane", "Doe", "0707000070");
        Contact contact2 = new Contact("Joe", "Jenkins", "0123456789");
        Contact contact3 = new Contact("Youssef", "Al Shadidi", "0734567890");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1, false);
        contactManagement.addContact(contact2, false);
        contactManagement.addContact(contact3, false);

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
        Contact contact1 = new Contact("Jane", "Doe", "0707000070");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1, false);

        assertTrue(contact1.getFirstName().equals("Jane"));
        assertNotEquals("Joe", contact1.getFirstName());
        assertNotNull(contact1);
    }

    @Test
    @DisplayName("Search Last Name")
    public void searchLastNameTest() {
        Contact contact1 = new Contact("Jane", "Doe", "0707000070");

        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addContact(contact1, false);

        assertTrue(contact1.getLastName().equals("Doe"));
        assertNotEquals("Jenkins", contact1.getLastName());
        assertNotNull(contact1);
    }
}
