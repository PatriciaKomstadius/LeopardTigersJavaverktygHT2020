package ContactsTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import Contacts.Contact;
import Contacts.ContactManagement;

public class ContactManagementTest {

    @Test
    @DisplayName("Show contacts")
    public void showContactsTest() {
        ContactManagement contactManagement = new ContactManagement();
        Contact contact = new Contact("Jane", "Doe", "0707000070");

        assertAll("contact",
                () -> assertEquals("Jane", contact.getFirstName()),
                () -> assertEquals("Doe", contact.getLastName()),
                () -> assertEquals("0707000070", contact.getNumber()),

                () -> assertNotEquals("Joe", contact.getFirstName()),
                () -> assertNotEquals("Jenkins", contact.getLastName()),
                () -> assertNotEquals("0123456789", contact.getNumber()),

                () -> assertNotNull(contact.getFirstName()),
                () -> assertNotNull(contact.getLastName()),
                () -> assertNotNull(contact.getNumber())
                );


    }

    @Test
    @DisplayName("Add contacts")
    public void addContactTest() {
        ContactManagement contactManagement = new ContactManagement();
        Contact contact = new Contact("Jane", "Doe", "0707000070");
        ContactManagement.addContact(contact);

        assertTrue(contact.getFirstName().equals("Jane"));
        assertTrue(contact.getLastName().equals("Doe"));
        assertTrue(contact.getNumber().equals("0707000070"));

        assertNotNull(contact);
    }

    @Test
    @DisplayName("Remove contacts")
    public void removeContactTest() {
        Contact contact = new Contact("Jane", "Doe", "0707000070");
        ContactManagement.addContact(contact);
        ContactManagement.removeContact("0707000070");

        assertNull(contact);
    }

    @Test
    @DisplayName("Search First Name")
    public void searchFirstNameTest() {
        ContactManagement contactManagement = new ContactManagement();

    }

    @Test
    @DisplayName("Search Last Name")
    public void searchLastNameTest() {
        ContactManagement contactManagement = new ContactManagement();

    }
}
