package ContactsTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class ContactTest {

    @Test
    @DisplayName("Get First Name")
    public void getFirstNameTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567891");

        assertTrue(contact.getFirstName().equals("Nika"));
    }

    @Test
    @DisplayName("Get Last Name")
    public void getLastNameTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567891");

        assertTrue(contact.getLastName().equals("Arya"));
    }

    @Test
    @DisplayName("Get Number")
    public void getNumberTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567890");

        assertTrue(contact.getNumber().equals("0734567890"));
    }

    @Test
    @DisplayName("To String")
    public void toStringTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567890");

        assertTrue(contact.toString().equals("\n" + contact.getFirstName() +
                " " + contact.getLastName() + "  |ID|: " + contact.getNumber()));

        assertNotNull(contact.toString());
    }
}
