package UI;

import Contacts.ContactManagement;
import Contacts.Contact;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class UserInputTest {

    private ContactManagement contactManagement;
    Contact contact;
    Contact contact2;

    @BeforeAll
    static void init() {
        System.out.println("Running tests..");
    }

    @BeforeEach
    void instantiate(){
        this.contactManagement= new ContactManagement();
    }

    @AfterAll
    static void finish(){
        System.out.println("Tests completed.");
    }

    @DisplayName("Adding contact")
    @Test
    void testAdd() {
       contact = new Contact("Ebba", "Grön", "0812345678");
        contact2 = new Contact("Evert", "Sivers", "07012345689");

        contactManagement.addContact(contact2);
        contactManagement.addContact(contact);

        assertEquals(2, contactManagement.showContacts());
    }

    @DisplayName("Searching for contacts")
    @Test
    void testConsoleSearch() {

        contact = new Contact("Ebba", "Grön", "0812345678");

        contactManagement.addContact(contact);

        String value = "Ebba";

        List<Contact> testResult = new ArrayList<>();
        testResult.add(contact);

        assertEquals(testResult, contactManagement.search(value));

    }

    @DisplayName("Deleting contact")
    @Test
    void testSearchAndDelete() {
        contact = new Contact("Ebba", "Grön", "0812345678");
        contactManagement.addContact(contact);

        contactManagement.removeContact(contact.getNumber());

        assertEquals(0, contactManagement.showContacts());

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

    @DisplayName("Checking if number to contact is more than 8 digits")
    @Test
    void testCheckNumber() {

        UserInput ui = new UserInput();

        String number = "12345678";

        assertTrue(ui.checkNumber(number) == true);
    }

    @DisplayName("Verifying throws of null numbers")
    @Test
    void testVerifyExceptionThrows() {
        UserInput ui = new UserInput();

        String input = null;

        assertThrows(Exception.class, () -> ui.checkNumber(input));
    }

}


