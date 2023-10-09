import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    @DisplayName("Basic input test.")
    void testContactClass() {
        Contact contact = new Contact("John", "Smith", "12345",
                "0123456789", "123 Sesame St." );
        Assertions.assertTrue(contact.getFirstName().equals("John"));
        Assertions.assertTrue(contact.getLastName().equals("Smith"));
        Assertions.assertTrue(contact.getPhone().equals("0123456789"));
        Assertions.assertTrue(contact.getAddress().equals("123 Sesame St."));
        Assertions.assertTrue(contact.getId().equals("12345"));
    }

    @Test
    @DisplayName("Tests if error is thrown when string is too long.")
    void testContactTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John Whick 16500", "Smithsonian 12345", "12345678910", "012345678", "123 Sesame St.fjaskdjfisdjfijasdlfjdskaflkads" );
        });
    }

    @Test
    @DisplayName("Testing that null values throw errors.")
    void testContactNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, null, null, null, null );
        });
    }
}
