package UI;

import Contacts.ContactManagement;
import Contacts.Contact;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Contacts.ContactManagement.search;
import static Contacts.ContactManagement.showContacts;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputTest {

    @BeforeAll
    static void init() {
        System.out.println("Running tests..");
    }

    @DisplayName("Adding contact")
    @Test
    void testAdd() {
        Contact contact = new Contact("Elena", "Mandela", "12345");

        ContactManagement.addContact(contact);

        assertEquals(1, ContactManagement.showContacts());
    }

/*
    @DisplayName("Removing contact from contactbook")
    @Test
    void testDelete() {
        String deleteContact1 = "12345";
        ContactManagement.removeContact(deleteContact1);
        assertEquals(0, ContactManagement.showContacts());
    }
*/

    @DisplayName("Deleting contact, checking contactlist")
    @Test
    void testSearchAndDelete() {

        Contact testContact = new Contact("Evert", "Gustavsson", "008888");

        ContactManagement.addContact(testContact);
        ContactManagement.removeContact(testContact.getNumber(), true);

        assertEquals(0, showContacts());

    }

    @Test
    void testConsoleSearch() {
        Contact testContact = new Contact("Ebba", "Grön", "800");

        String value = "Ebba";

         List<Contact> result = search(value);

//        assertTrue(testContact.getFirstName().equals("Ebba"));
   assertEquals(value, ContactManagement.search(value));

    }

    /*
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

     */

    @DisplayName("Verifying throws of InputMisMatchException menu-choices")
    @Test
    void testReadInt() {
        UserInput ui = new UserInput();

        String input = "Input string instead of Integer";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () ->
                ui.readInt()
        );
    }

    @DisplayName("Veryfying throws of InputMismatchException search/delete-method")
    @Test
    void testReadIntForSearchAndDelete() {
        UserInput ui = new UserInput();

        String input = "Input string instead of Integer";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () ->
                ui.readIntForSearchAndDelete()
        );
    }


    @Test
    void verifyingAdd() {

        UserInput ui = new UserInput();

        Contact input = new Contact("Ebba", "Grön", "4004");



        assertThrows(Exception.class, () -> ui.add());


    }

    @Disabled
    @Test
    void testVerifyExceptionThrows() {

        UserInput ui = new UserInput();

        String input = null;

        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        assertThrows(Exception.class, () -> ui.add());

    }

}


