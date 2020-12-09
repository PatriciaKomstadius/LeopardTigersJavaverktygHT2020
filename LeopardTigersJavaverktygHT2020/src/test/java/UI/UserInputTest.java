package UI;

import Contacts.ContactManagement;
import Contacts.Contact;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputTest {

    @BeforeAll
    static void init(){
        System.out.println("Running tests..");
    }

    @DisplayName("Adding contact")
    @Test
    void testAdd()  {
        Contact contact = new Contact("Elena", "Mandela", "12345");
        ContactManagement.addContact(contact,  true);

        assertEquals(1, ContactManagement.showContacts());
    }

    @DisplayName("Removing contact from contactbook")
    @Test
    void testDelete() {
        String deleteContact1 = "12345";
        ContactManagement.removeContact(deleteContact1, true);
        assertEquals(0, ContactManagement.showContacts());
    }

    @DisplayName("Searching by first name")
    @Test
    void testSearchByFirstName() {
        Contact contact = new Contact("Femman", "Johansson", "5555");

        assertEquals("Femman", contact.getFirstName());
    }

    @DisplayName("Searching by last name")
    @Test
    void testSearchByLastName() {
        Contact contact = new Contact("Johan", "Fyrson", "4444");

        assertEquals("Fyrson", contact.getLastName());
    }

    @DisplayName("Verifying throws of InputMisMatchException")
    @Test
    void testReadInt() {
        UserInput ui = new UserInput();

        String input = "input string instead of Integer";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () ->
            ui.readInt()
        );
    }

}


