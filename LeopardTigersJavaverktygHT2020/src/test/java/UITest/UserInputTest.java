package UITest;

import Contacts.ContactManagement;
import Contacts.Contact;

import UI.UserInput;


import org.junit.jupiter.api.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputTest {

    /*
    @BeforeAll
    void setUp() {
        System.out.println("Setting up tests");
    }
     */

    @DisplayName("Adding contact")
    @Test
    void testAdd()  {
        Contact contact = new Contact("Elena", "Nilsson", "1234");
        ContactManagement.addContact(contact);
        // assertNotNull(contact);
        assertEquals(1, ContactManagement.showContacts());
    }

    @DisplayName("Removing contact from contactbook")
    @Test
    void testDelete() {
        String deleteContact1 = "1234";
        ContactManagement.removeContact(deleteContact1);
        assertEquals(0, ContactManagement.showContacts());
    }

    @DisplayName("Search contact by first name")
    @Test
    void testSearchByFirstName() {
        Contact contact = new Contact("Nisse", "Aro", "4444");

        assertEquals("Nisse", contact.getFirstName());
    }

    @DisplayName("Seach contact by last name")
    @Test
    void testSearchByLastName() {
        Contact contact = new Contact("Johanna", "Femma", "5555");

        assertEquals("Femma", contact.getLastName());
    }
    @DisplayName("Verifying throws of InputMisMatchException")
    @Test
    void testReadInt() {
        UserInput ui = new UserInput();

        String input = "sending a textmessage instead of Integer input";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> {
            ui.readInt();
        });
    }

}
