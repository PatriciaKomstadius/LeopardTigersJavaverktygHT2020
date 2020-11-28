package ContactsIOTest;

import ContactsIO.ContactsIO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactsIOTest {

    private ContactsIO cIO;

    @BeforeAll
    public static void message(){
        System.out.println("Running ContactsIO tests...");
    }

    @BeforeEach
    public void instantiate(){
        cIO=new ContactsIO();
    }

    @Test
    public void test_readContacts(){
        //testa att contacts-listan är samma som readContacts-listan
    }

    @Test
    public void test_removeContact_exception(){
        Contact contact = new Contact("a", "b", "0701234567")
        File tempFile = new File("TempFile.txt");
        try{
        if (!tempFile.createNewFile()){
            System.out.println("File creation failed.");
        }} catch (IOException e){
        }
        assertThrows(IOException.class, () -> cIO.removeContact(contact));
        //Testa om det funkar med bara en felaktig kontakt
    }
}
