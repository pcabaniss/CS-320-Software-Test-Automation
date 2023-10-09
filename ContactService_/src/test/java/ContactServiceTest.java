import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactServiceTest {

    // Basic variable initialization
    private static String id = "1234567890";
    private String firstName = "John";
    private String lastName = "Smith";
    private String phone = "1112223333";
    private String address = "123 Sesame st.";

    @Test
    void addContactTest() {
        ContactService service = new ContactService();
        service.addContact(firstName, lastName, phone, address);
        List<Contact> cList = service.getContacts();
        Contact tester = cList.get(0);

        Assertions.assertTrue(tester.getFirstName().equals("John"));
        Assertions.assertTrue(tester.getLastName().equals("Smith"));
        Assertions.assertTrue(tester.getPhone().equals("1112223333"));
        Assertions.assertTrue(tester.getAddress().equals("123 Sesame st."));
    }

    @Test
    @DisplayName("Deleting contact test.")
    void deleteContactTest() {
        ContactService service = new ContactService();
        service.addContact(firstName, lastName, phone, address);
        List<Contact> cList = service.getContacts();
        String testId = cList.get(0).getId();

        // Tests if exception is thrown when id is not found
        Assertions.assertThrows(Exception.class, () -> service.deleteContact("123456"));

        // Test to make sure it is deleted
        service.deleteContact(testId);
        Assertions.assertTrue(service.getContacts().isEmpty());

    }

    @Test
    @DisplayName("Updating contact test.")
    void updateContactTest() {
        ContactService service = new ContactService();
        service.addContact(firstName, lastName, phone, address);
        List<Contact> cList = service.getContacts();
        String testId = cList.get(0).getId();

        service.updateContact(testId, "Phillip", "Cabaniss", "6825215429", "200 Blue Slide Pk.");

        // Get update contact list
        cList = service.getContacts();

        Assertions.assertTrue(cList.get(0).getFirstName().equals("Phillip"));
        Assertions.assertTrue(cList.get(0).getLastName().equals("Cabaniss"));
        Assertions.assertTrue(cList.get(0).getPhone().equals("6825215429"));
        Assertions.assertTrue(cList.get(0).getAddress().equals("200 Blue Slide Pk."));

    }

}
