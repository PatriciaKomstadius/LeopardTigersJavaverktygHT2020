
package ContactsIO;

import Contacts.Contact;
import Contacts.ContactManagement;

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

    public void reWriteContacts() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            for (Contact contact : ContactManagement.getContacts()){
                    writer.write(contact.getFirstName() + " " + contact.getLastName() + " " +
                            contact.getNumber().replaceAll("\\s", "") + "\n");
                }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void clearContacts(){
        try {
            File contacts = new File(filepath);
            if (contacts.delete()) {
                contacts.createNewFile();
            } else {
                System.out.println("File deletion failed.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
