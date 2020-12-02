
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
        MainClass main = new MainClass();

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
        Contact contact = new Contact("Testperson1", "12345");
        Contact contact2 = new Contact("Testperson2", "23456");
        Contactmanagement.addContact(contact);
        Contactmanagement.addContact(contact2);
        assertEquals(2, Contactmanagement.showContacts());
    }

    @Test
    void testDelete() {

        String deleteContact = "12345";
        Contactmanagement.deleteContact(deleteContact);

        assertEquals(1, Contactmanagement.showContacts());
    }

    @Test
    void testSearch() {
        Contact contact = new Contact("Testperson2", "23456");

        Contactmanagement.addContact(contact);

        assertEquals("Testperson2", contact.getName());
    }
}



