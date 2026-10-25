package cs320_ContactService;

public class Contact {
    private final String contactId;
    private String firstName, lastName, phone, address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateText(contactId, 10, "contactId");
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }
    private static void validateText(String value, int maxLength, String field) {
        if (value == null || value.length() > maxLength)
            throw new IllegalArgumentException("Invalid " + field);
    }
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public void setFirstName(String value) { validateText(value, 10, "firstName"); firstName = value; }
    public void setLastName(String value) { validateText(value, 10, "lastName"); lastName = value; }
    public void setPhone(String value) {
        if (value == null || !value.matches("[0-9]{10}")) throw new IllegalArgumentException("Invalid phone");
        phone = value;
    }
    public void setAddress(String value) { validateText(value, 30, "address"); address = value; }
}
