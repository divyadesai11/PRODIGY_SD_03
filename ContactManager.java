package Task03;

import java.util.*;

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n📞 Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1: addContact(); break;
                case 2: viewContacts(); break;
                case 3: editContact(); break;
                case 4: deleteContact(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }

    public static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("✅ Contact added.");
    }

    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n📇 Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public static void editContact() {
        viewContacts();
        System.out.print("Enter contact number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("❌ Invalid contact number.");
            return;
        }

        Contact c = contacts.get(index);
        System.out.print("Enter new name (" + c.getName() + "): ");
        c.setName(sc.nextLine());
        System.out.print("Enter new phone (" + c.getPhone() + "): ");
        c.setPhone(sc.nextLine());
        System.out.print("Enter new email (" + c.getEmail() + "): ");
        c.setEmail(sc.nextLine());

        System.out.println("Contact updated.");
    }

    public static void deleteContact() {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("❌ Invalid contact number.");
            return;
        }

        contacts.remove(index);
        System.out.println("Contact deleted.");
    }
}

