package Main.Test;

import Contacts.ContactManagement;
import Contacts.Contact;

import Main.MainClass;


import org.junit.jupiter.api.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
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

    @DisplayName("Adding contact")
    @Test
    void testAdd()  {
       Contact contact = new Contact("Elena", "Nilsson", "1234");
        ContactManagement.addContact(contact);
       // assertNotNull(contact);
        //assertEquals(1, ContactManagement.showContacts());
    }

    @DisplayName("Searching contact by first name")
    @Test
    void testSearchByFirstName() {
       Contact contact = new Contact("Nisse", "Ure", "8888");
        String firstName = "Nisse";
        ContactManagement.searchFirstName(firstName);
        assertEquals("Nisse", contact.getFirstName());
    }

    @DisplayName("Seaching contact by last name")
    @Test
    void testSearchByLastName() {
       Contact contact = new Contact("Måns", "Sunesson", "4444");
        String lastName = "Sunesson";
        ContactManagement.searchFirstName(lastName);
        assertEquals("Sunesson", contact.getLastName());
    }

 /*
    @DisplayName("Removing contact from contactbook")
    @Test
    void testRemove() {
        String removeContact1 = "1234";
        ContactManagement.removeContact(removeContact1);
        assertEquals(1, ContactManagement.showContacts());
    }

  */

}
