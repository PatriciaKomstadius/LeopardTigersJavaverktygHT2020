package Contacts;

import java.util.Objects;

public class Contact {
    private String firstName;
    private String lastName;
    private String number;

    public Contact(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName + " | Number: " + number;
    }

    @Override
    public boolean equals(Object o) {
        Contacts.Contact contact = (Contacts.Contact) o;
        return this.number.equals(contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}