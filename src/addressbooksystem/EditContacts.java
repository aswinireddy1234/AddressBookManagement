package addressbooksystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditContacts {
    private List<Contact> contacts;
    public EditContacts() {
            contacts = new ArrayList<Contact>();
        }
        public void addContact(Contact contact) {
            contacts.add(contact);
        }
        public List<Contact> getContacts() {
            return contacts;
        }
        public Contact getContactByName(String firstName, String lastName) {
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                    return contact;
                }
            }
            return null;
        }
        public static void main(String[] args) {
           EditContacts addressBook = new EditContacts();
           // create scanner for console input
            Scanner scanner = new Scanner(System.in);
            // loop to add/edit contacts
            while (true) {
                System.out.print("Enter 'add' to add a new contact, 'edit' to edit an existing contact, or 'quit' to exit: ");
                String action = scanner.nextLine();
                if (action.equals("quit")) {
                    break;
                }
                if (action.equals("add")) {
                    // prompt user for new contact information
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();

                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();

                    System.out.print("Enter zip code: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();

                    // create new contact and add to address book
                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(contact);

                    System.out.println("Contact added:\n" + contact);
                } else if (action.equals("edit")) {
                    // prompt user for contact to edit
                    System.out.print("Enter first name of contact to edit: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter last name of contact to edit: ");
                    String lastName = scanner.nextLine();

                    // find contact by name
                    Contact contact = addressBook.getContactByName(firstName, lastName);
                    if (contact == null) {
                        System.out.println("Contact not found.");
                    } else {
                        // prompt user for updated contact information
                        System.out.print("Enter updated address: ");
                        String address = scanner.nextLine();

                        System.out.print("Enter updated city: ");
                        String city = scanner.nextLine();

                        System.out.print("Enter updated state: ");
                        String state = scanner.nextLine();

                        System.out.print("Enter updated zip code: ");
                        String zip = scanner.nextLine();

                        System.out.print("Enter updated phone number: ");
                        String phone = scanner.nextLine();

                        System.out.print("Enter updated email address: ");
                        String email = scanner.nextLine();

                        // update contact information
                        EditContact.setAddress(address);
                        EditContact.setCity(city);
                        EditContact.setState(state);
                        EditContact.setZip(zip);
                        EditContact.setPhone(phone);
                        EditContact.setEmail(email);

                        System.out.println("Contact updated :\n" + contact);
                    }
                }
            }

            scanner.close();
        }
    }

    class EditContact {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phone;
        private String email;
        public static void setCity(String city) {
        }
        public static void setState(String state) {
        }
        public static void setZip(String zip) {
        }
        public static void setPhone(String phone) {
        }
        public static void setEmail(String email) {
        }
        public static void setAddress(String address) {
        }
        public void EditContact(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
            this.email = email;
        }
        @Override
        public String toString() {
            return firstName + " " + lastName + "\n" +
                    address + "\n" +
                    city + ", " + state + " " + zip + "\n" +
                    "Phone: " + phone + "\n" +
                    "Email: " + email + "\n";
        }
    }


