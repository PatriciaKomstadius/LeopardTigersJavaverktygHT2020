
package ContactsIO;

import Contacts.Contact;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.NullSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class ContactsIOTest {

    private ContactsIO io;
    private Contact testContact;

    @BeforeAll
    public static void message() {
        System.out.println("Running ContactsIO tests...");
    }

    @BeforeEach
    public void instantiateAndWrite() {
        io = new ContactsIO("TestContacts.txt");
        testContact = new Contact("John", "Doe", "0701234567");
        io.writeContact(testContact);
    }

    @AfterEach
    public void resetTestContacts() {
        io.clearContacts();
    }

    @Test
    public void test_readContacts() throws IOException {
        Contact contactOnFile = io.readContacts().iterator().next();
        assertEquals(testContact.getFirstName() + testContact.getLastName() + testContact.getNumber(),
                contactOnFile.getFirstName() + contactOnFile.getLastName() + contactOnFile.getNumber());
    }

    @Test
    public void test_writeContact() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(io.findJarPath("TestContacts.txt")))) {
            assertEquals("John, Doe, 0701234567", reader.readLine());
        }
    }

    @Test
    public void test_clearContacts() {
        assertEquals(1, io.readContacts().size());
        io.clearContacts();
        assertTrue(io.readContacts().isEmpty());
    }

    @Test
    public void test_findResourcePath_illegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            io.findResourcePath("badFile.txt");
        });
    }

    @ParameterizedTest
    @NullSource
    public void test_findResourcePath_nullSource(String filepath) {
        assertThrows(NullPointerException.class, () ->
                io.findResourcePath(filepath)
        );
    }

    @ParameterizedTest
    @NullSource
    public void test_writeContact_nullSource(Contact contact) {
        assertThrows(NullPointerException.class, () -> io.writeContact(contact));
    }

    @AfterAll
    public static void endMessage(){
        System.out.println("ContactsIO tests completed.");
    }

}
