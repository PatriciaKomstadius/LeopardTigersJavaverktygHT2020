package UI;

import Contacts.ContactManagement;
import Contacts.Contact;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Contacts.ContactManagement.showContacts;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class UserInputTest {

    @BeforeAll
    static void init() {
        System.out.println("Running tests..");
    }

    @DisplayName("Adding contact")
    @Test
    void testAdd() {
        Contact contact = new Contact("Elena", "Mandela", "0105588");

        ContactManagement.addContact(contact);

        assertEquals(1, ContactManagement.showContacts());
    }

    @DisplayName("Deleting contact, checking contactlist")
    @Test
    void testSearchAndDelete() {

        Contact testContact = new Contact("Evert", "Gustavsson", "0708899245");

        ContactManagement.addContact(testContact);
        ContactManagement.removeContact(testContact.getNumber(), true);

        assertEquals(0, showContacts());

    }

    @DisplayName("Searching for contacts")
    @Test
    void testConsoleSearch() {
        Contact testContact = new Contact("Ebba", "Grön", "0812345678");
        ContactManagement.addContact(testContact);

        String value = "Ebba";

        List<Contact> testResult = new ArrayList<>();
        testResult.add(testContact);

        assertEquals(testResult, ContactManagement.search(value));
    }


    @DisplayName("Verifying throws of InputMisMatchException in menu")
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
    void testAddThrows() {
        UserInput ui = new UserInput();

        String input = "5";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(Exception.class, () -> ui.add());

    }

    @Disabled
    @Test
    void verifyingAdd() {

        UserInput ui = new UserInput();
        Contact input = new Contact("Ebba", "Grön", "4004");

        String number = "5";

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


