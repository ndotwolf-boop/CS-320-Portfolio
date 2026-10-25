package cs320_ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Null contact or duplicate ID");
        contacts.put(contact.getContactId(), contact);
    }
    public void deleteContact(String contactId) {
        if (contacts.remove(contactId) == null) throw new IllegalArgumentException("Contact not found");
    }
    public Contact getContact(String contactId) { return contacts.get(contactId); }
    private Contact requireContact(String id) {
        Contact contact = contacts.get(id);
        if (contact == null) throw new IllegalArgumentException("Contact not found");
        return contact;
    }
    public void updateFirstName(String id, String value) { requireContact(id).setFirstName(value); }
    public void updateLastName(String id, String value) { requireContact(id).setLastName(value); }
    public void updatePhone(String id, String value) { requireContact(id).setPhone(value); }
    public void updateAddress(String id, String value) { requireContact(id).setAddress(value); }
}
