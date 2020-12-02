
package ContactsIO;

import Contacts.Contact;

import java.io.*;
import java.util.*;

public class ContactsIO {

    private String filepath;

    public ContactsIO(String filepath){
        this.filepath=filepath;
    }

    public List<Contact> readContacts() {

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
        } catch (IOException e){
            e.printStackTrace();
        }
        return contacts;
    }

    public void writeContact(Contact contact) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))){
            writer.write(contact.getFirstName() + " " + contact.getLastName() + " " +
                                contact.getNumber().replaceAll("\\s", "") + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void removeContact(Contact contact, String tempFilePath) {
        String contactToRemove = contact.getFirstName() + " " + contact.getLastName() + " " +
                                    contact.getNumber().replaceAll("\\s", "");
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
