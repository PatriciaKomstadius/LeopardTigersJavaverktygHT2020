
package ContactsIOTest;

import Contacts.Contact;
import Contacts.ContactManagement;
import ContactsIO.ContactsIO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.NullSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactsIOTest {

    private ContactsIO io;
    private Contact testContact;

    @BeforeAll
    public static void message(){
        System.out.println("Running ContactsIO tests...");
    }

    @BeforeEach
    public void instantiateAndWrite(){
        io=new ContactsIO("TestContacts.txt");
        testContact = new Contact("John", "Doe", "0701234567");
        io.writeContact(testContact);
    }

    @Test
    public void test_writeContact() throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(io.findResourcePath("TestContacts.txt")))){
            assertEquals("John Doe 0701234567", reader.readLine());
        }
    }

    @Test
    public void test_readContacts() throws IOException{
        Contact contactOnFile=io.readContacts().get(0);
        assertEquals(testContact.getFirstName()+testContact.getLastName()+testContact.getNumber(),
                contactOnFile.getFirstName()+contactOnFile.getLastName()+contactOnFile.getNumber());
    }

    @Test
    public void test_rewriteContacts(){
        io.reWriteContacts();
        assertEquals(ContactManagement.getContacts(), io.readContacts());
        }

    @Test
    public void test_writeContact_null(){
        assertThrows(NullPointerException.class, () -> {
            io.writeContact(null);
        });
    }

    @Test
    public void test_instantiate_illegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> {
            ContactsIO badFile = new ContactsIO("badFile.txt");
        });
    }

    @Test
    public void test_findResourcePath_illegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> {
            io.findResourcePath("badFile.txt");
        });
    }


    }
