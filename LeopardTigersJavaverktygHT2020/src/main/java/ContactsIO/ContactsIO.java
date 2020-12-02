
package ContactsIO;

import java.io.*;
import java.util.*;

public class ContactsIO {

    private String filepath;

    public ContactsIO(String filepath){
        this.filepath=filepath;
    }

    public List<Contact> readContacts() throws IOException {

        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            writer.write(contact.getFirstName() + " " + contact.getLastName() + " " +
                                contact.getPhoneNumber().replaceAll("\\s", "") + "\n");
        }
    }

    public void removeContact(Contact contact, String tempFilePath) throws IOException {
        String contactToRemove = contact.getFirstName() + " " + contact.getLastName() + " " +
                                    contact.getPhoneNumber().replaceAll("\\s", "");
        File originalFile = new File(filepath);
        File tempFile = new File(tempFilePath);

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
