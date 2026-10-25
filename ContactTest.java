package cs320_ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact sample() { return new Contact("1", "Jane", "Doe", "1234567890", "Main St"); }
    @Test void validContactAndUpdates() {
        Contact c = sample();
        assertEquals("1", c.getContactId());
        assertEquals("Jane", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("Main St", c.getAddress());
        c.setFirstName("Amy"); c.setLastName("Smith"); c.setPhone("0987654321"); c.setAddress("Oak St");
        assertEquals("Amy", c.getFirstName()); assertEquals("Smith", c.getLastName());
        assertEquals("0987654321", c.getPhone()); assertEquals("Oak St", c.getAddress());
    }
    @Test void invalidIds() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null,"A","B","1234567890","C"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901","A","B","1234567890","C"));
    }
    @Test void invalidNames() {
        Contact c = sample();
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("12345678901"));
    }
    @Test void invalidPhoneAndAddress() {
        Contact c = sample();
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("abcdefghij"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("1234567890123456789012345678901"));
    }
}
