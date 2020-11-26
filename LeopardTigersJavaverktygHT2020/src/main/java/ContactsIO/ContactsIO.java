
public class ContactsIO {

    public void readContacts() throws IOException {

    try(
    BufferedReader reader = new BufferedReader(new FileReader("ContactBook.txt")))

    }

    public void writeContact(Contact contact) throws IOException {

        try (BufferedWriter writer =new BufferedWriter(new FileWriter("ContactBook.txt")))


    }
}
