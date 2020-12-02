package Main.Test;

import Contacts.Contact;
import Contacts.ContactManagement;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainClassTest {




    @Disabled
    @Test
    void testMenuInputMismatchexception() {
        Main.MainClass main = new Main.MainClass();

        String choice = "bad input";

        InputStream in = new ByteArrayInputStream(choice.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> {
            main.menu();
        });
    }

    @Before
    void setUp() {

    }

    @Test
    void testAdd() {
        Contact contact = new Contact("Testperson1", "1Efternamn", "12345");
        Contact contact2 = new Contact("Testperson2", "2Efternamn", "23456");
        ContactManagement.addContact(contact);
        ContactManagement.addContact(contact2);
        assertEquals(2, ContactManagement.showContacts());
    }

    @Test
    void testDelete() {


        Contact contact = new Contact("Testperson1", "1Efternamn", "12345");
        Contact contact2 = new Contact("Testperson2", "2Efternamn", "23456");
        ContactManagement.addContact(contact);
        ContactManagement.addContact(contact2);

        String deleteContact = "12345";
        ContactManagement.removeContact(deleteContact);

        assertEquals(1, ContactManagement.showContacts());

    }

    @Test
    void testSearchByFirstName() {
        Contact contact = new Contact("Testperson2", "2Efternamn", "23456");

        ContactManagement.addContact(contact);

        assertEquals("Testperson2", contact.getFirstName());
    }

    @Test
    void testSearchByLastName() {
        Contact contact = new Contact("Testperson2", "2Efternamn", "23456");

        ContactManagement.addContact(contact);

        assertEquals("Testperson2", contact.getLastName());
    }
}



