package Contacts;

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

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "\n" + firstName + " " + lastName + "  |Number|: " + number;
    }
}
