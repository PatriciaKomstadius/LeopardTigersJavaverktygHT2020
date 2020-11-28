package ContactsIO;

import java.io.*;
import java.util.*;

public class ContactsIO {

    public List<Contact> readContacts() throws IOException {

        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("ContactBook.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] records = line.split(" ");
                String firstName = records[0];
                String lastName = records[1];
                String phoneNumber = records[2];
                Contact contact = new Contact(firstName, lastName, phoneNumber);
                contacts.add(contact);
            }
        }
        return contacts;
    }

    public void writeContact(Contact contact) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ContactBook.txt"))){
            writer.write(contact.getFirstName() + " " + contact.getLastName() + " " +
                                contact.getPhoneNumber().replaceAll("\\s", "") + "\n");
        }
    }

    public void removeContact(Contact contact) throws IOException {
        String contactToRemove = contact.getFirstName() + " " + contact.getLastName() + " " +
                                    contact.getPhoneNumber().replaceAll("\\s", "");
        File originalFile = new File("ContactBook.txt");
        File tempFile = new File("TempFile.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            BufferedReader reader = new BufferedReader(new FileReader(originalFile));
            ){

            if (!tempFile.createNewFile()){
                System.out.println("File creation failed.");
            }
            String line;
            while ((line = reader.readLine()) != null){
                if (!line.equals(contactToRemove)){
                    writer.write(line + "\n");
                }
            }
            if (!originalFile.delete()){
                System.out.println("File deletion failed.");
            }
            if (!tempFile.renameTo(new File("ContactBook.txt"))) {
                System.out.println("File update failed.");
            }
        }
    }

}
