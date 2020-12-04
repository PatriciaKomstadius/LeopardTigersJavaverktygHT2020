package ContactsTest;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import Contacts.Contact;

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
    @DisplayName("Set First Name")
    public void setFirstNameTest() {
        Contact contact = new Contact("Lisa", "Nilsson", "0765435261");

        contact.setFirstName("Nika");
        assertTrue(contact.getFirstName().equalsIgnoreCase("Nika"));

        assertNotEquals("Lisa", contact.getFirstName());
    }

    @Test
    @DisplayName("Get Last Name")
    public void getLastNameTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567891");

        assertTrue(contact.getLastName().equals("Arya"));
    }

    @Test
    @DisplayName("Set Last Name")
    public void setLastNameTest() {
        Contact contact = new Contact("Lisa", "Nilsson", "0765435261");

        contact.setLastName("Andersson");
        assertEquals("Andersson", contact.getLastName());

        assertNotEquals("Nilsson", contact.getLastName());

    }

    @Test
    @DisplayName("Get Number")
    public void getNumberTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567890");

        assertTrue(contact.getNumber().equals("0734567890"));
    }

    @Test
    @DisplayName("Set Number")
    public void setNumberTest() {
        Contact contact = new Contact("Lisa", "Nilsson", "0765435261");

        contact.setNumber("0734567890");
        assertEquals("0734567890", contact.getNumber());

        assertNotEquals("0765435261", contact.getNumber());

    }


    @Test
    @DisplayName("To String")
    public void toStringTest() {
        Contact contact = new Contact("Nika", "Arya", "0734567890");

        assertTrue(contact.toString().equals("\nName: " + contact.getFirstName() +
                " " + contact.getLastName() + " | Number: " + contact.getNumber()));

        assertNotNull(contact.toString());
    }
}


