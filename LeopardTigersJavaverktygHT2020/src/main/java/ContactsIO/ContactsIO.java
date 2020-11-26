package ContactsIO;

import java.io.*;

public class ContactsIO {

    public void readContacts() throws IOException {

        //private List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("ContactBook.txt"))) {
            String input = reader.readLine();
            while (input != null) {
                String[] records = input.split(" ");
                String firstName = records[0];
                String lastName = records[1];
                String phoneNumber = records[2];
                Contact contact = new Contact(firstName, lastName, phoneNumber);
                contacts.add(contact);
            }
        }
    }

    public void writeContact(Contact contact) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ContactBook.txt"))){
            writer.write(contact.getFirstName() + " " + contact.getLastName() + " " + contact.getPhoneNumber);
        }
    }

    public void removeContact(Contact contact){
        File originalFile = new File("ContactBook.txt");
    }

}
