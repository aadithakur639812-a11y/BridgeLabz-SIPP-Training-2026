import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class AddressBookApp {
    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final HashMap<String, Contact> contactsByName = new HashMap<>();
    private final HashSet<String> phoneNumbers = new HashSet<>();

    public boolean addContact(String name, String phone, String email) {
        if (contactsByName.containsKey(name)) {
            System.out.println("A contact with this name already exists.");
            return false;
        }
        if (!phoneNumbers.add(phone)) {
            System.out.println("This phone number is already registered.");
            return false;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        contactsByName.put(name, contact);
        return true;
    }

    public Contact searchContact(String name) {
        return contactsByName.get(name);
    }

    public boolean deleteContact(String name) {
        Contact contact = contactsByName.remove(name);
        if (contact == null) {
            return false;
        }
        contacts.remove(contact);
        phoneNumbers.remove(contact.phone);
        return true;
    }

    public void displayContactsSortedByName() {
        ArrayList<Contact> sortedContacts = new ArrayList<>(contacts);
        Collections.sort(sortedContacts, Comparator.comparing(contact -> contact.name));
        sortedContacts.forEach(System.out::println);
    }

    private static class Contact {
        private final String name;
        private final String phone;
        private final String email;

        private Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
        }
    }

    public static void main(String[] args) {
        AddressBookApp addressBook = new AddressBookApp();
        addressBook.addContact("Anita", "9876543210", "anita@example.com");
        addressBook.addContact("Bhavesh", "9123456780", "bhavesh@example.com");
        addressBook.addContact("Charu", "9988776655", "charu@example.com");

        System.out.println("Search result: " + addressBook.searchContact("Bhavesh"));
        addressBook.deleteContact("Charu");
        System.out.println("\nContacts sorted by name:");
        addressBook.displayContactsSortedByName();
    }
}
