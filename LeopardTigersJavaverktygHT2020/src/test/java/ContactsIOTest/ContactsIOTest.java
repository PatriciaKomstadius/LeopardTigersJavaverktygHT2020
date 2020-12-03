
package ContactsIOTest;

import Contacts.Contact;
import ContactsIO.ContactsIO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    public void instantiate(){
        io=new ContactsIO("TestContacts.txt");
        testContact = new Contact("John", "Doe", "0701234567");
    }

    @Test
    public void test_writeContact(){
        io.writeContact(testContact);
        try (BufferedReader reader = new BufferedReader(new FileReader(io.findResourcePath("TestContacts.txt")))){
            assertEquals("John Doe 0701234567", reader.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    @Test
    public void test_readContacts() throws IOException{
        cIO.writeContact(testContact);
        assertEquals((testContact.getFirstName() + " " + testContact.getLastName() + " " +
                testContact.getNumber()), cIO.readContacts());
    }

    @Test
    public void test_removeContact_exception(){
        Contact contact = new Contact("a", "b", "0701234567");
        File tempFile = new File("TempFile.txt");
        try{
        if (!tempFile.createNewFile()){
            System.out.println("File creation failed.");
        }} catch (IOException e){
        }
        assertThrows(IOException.class, () -> cIO.removeContact(contact, "Tempfile.txt"));
        //Testa om det funkar med bara en felaktig kontakt
    }

 */
}
