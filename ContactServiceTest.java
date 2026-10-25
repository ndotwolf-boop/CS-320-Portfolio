package cs320_ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private Contact contact() { return new Contact("c1", "Jane", "Doe", "1234567890", "Street"); }
    @Test void addAndRejectDuplicates() {
        ContactService service = new ContactService(); service.addContact(contact());
        assertNotNull(service.getContact("c1"));
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact()));
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }
    @Test void delete() {
        ContactService service = new ContactService(); service.addContact(contact());
        service.deleteContact("c1"); assertNull(service.getContact("c1"));
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("missing"));
    }
    @Test void update() {
        ContactService service = new ContactService(); service.addContact(contact());
        service.updateFirstName("c1", "Amy"); service.updateLastName("c1", "Smith");
        service.updatePhone("c1", "0987654321"); service.updateAddress("c1", "New Road");
        Contact c = service.getContact("c1");
        assertEquals("Amy", c.getFirstName()); assertEquals("Smith", c.getLastName());
        assertEquals("0987654321", c.getPhone()); assertEquals("New Road", c.getAddress());
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("missing", "A"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("missing", "A"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("missing", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("missing", "A"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("c1", "bad"));
    }
}
