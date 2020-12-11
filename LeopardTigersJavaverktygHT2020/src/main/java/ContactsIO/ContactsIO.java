
package ContactsIO;

import Contacts.Contact;
import Contacts.ContactManagement;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.*;

public class ContactsIO {

    private File contactsFile;

    public ContactsIO(String filepath) {

        this.contactsFile = findJarPath(filepath);
        try {
            this.contactsFile.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        /*String absolutePath = new File(filepath).getAbsolutePath();
        this.contactsFile=new File(absolutePath);*/

    }

    public Set<Contact> readContacts() {

        Set<Contact> contacts = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(contactsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] records = line.split(", ");
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactsFile, true))){
            writer.write(contact.getFirstName() + ", " + contact.getLastName() + ", " +
                                contact.getNumber().replaceAll("\\s", "") + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void reWriteContacts() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactsFile))){
            for (Contact contact : ContactManagement.getContacts()) {
                writer.write(contact.getFirstName() + ", " + contact.getLastName() + ", " +
                        contact.getNumber().replaceAll("\\s", "") + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void clearContacts(){
        try {
            if (contactsFile.delete()) {
                contactsFile.createNewFile();
            } else {
                System.out.println("File deletion failed.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public File findResourcePath(String filepath){
        URL resource = getClass().getClassLoader().getResource(filepath);
        if (resource==null){
            throw new IllegalArgumentException("File " + filepath + " not found!");
        }
        File contactFile=null;
        try {
            contactFile = new File(resource.toURI());
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return contactFile;
    }

    public File findJarPath(String filepath){
        File jarFile = null;
        CodeSource codeSource = ContactsIO.class.getProtectionDomain().getCodeSource();
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        String jarDir = jarFile.getParentFile().getPath();
        return new File(jarDir + "/" + filepath);
    }

}
