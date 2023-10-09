import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

    // Data structure for holding Contact objects
    private List<Contact> contactList = new ArrayList<>();

    // Random id generator exactly 10 characters long.
    private String uuid;

    public String generateId() {
        uuid = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
        return uuid;
    }


    // Add a new contact
    public void addContact(String firstName, String lastName, String phone, String address) {
        String id = generateId();

        for(int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getId() == id ) {
                throw new IllegalArgumentException("Id already exists.");
            }
        }

        Contact contact = new Contact(firstName, lastName, id, phone, address);
        contactList.add(contact);
    }

    // Delete contact by id
    public void deleteContact(String id) {

        // Check for null value provided
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id.");
        }

        // Iterate through list to find and remove contact
        for(int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getId() == id ) {
                contactList.remove(i);
            }
            else {
                throw new IllegalArgumentException("Id does not exist.");
            }
        }
    }
    // Updates the contact
    public void updateContact(String id, String firstName, String lastName, String phone, String address ) {

        // Check for null value provided
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id.");
        }

        Contact contact = new Contact(firstName, lastName, id, phone, address);

        // Iterate through list to find contact and update with new contact
        for(int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getId() == id ) {
                contactList.set(i, contact);
            }
        }
    }

    // Return contact list
    protected List<Contact> getContacts() {return contactList;}

}
