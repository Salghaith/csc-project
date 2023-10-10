import java.util.InputMismatchException;
import java.util.Scanner;

public class PhonebookApp {
	static LinkedList<Event> listE = new LinkedList<Event>();
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	static Phonebook p = new Phonebook(listC, listE);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		//////////////////////////////////////////////////
		int choice;
		System.out.println("Welcome to the Linked Tree Phonebook!");

		do {
			System.out.println("\nPlease choose an option:");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event");
			System.out.println("5. Print event details");
			System.out.println("6. Print contacts by first name");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit");
			System.out.println();
			System.out.print("Enter your choice: ");

			try {
				choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					// addContact();
					System.out.print("\nEnter the contact's name: ");
					String contactName = sc.nextLine();
					System.out.print("Enter the contact's phone number: ");
					String phoneNumber = sc.nextLine();
					System.out.print("Enter the contact's email address: ");
					String emailAddress = sc.nextLine();
					System.out.print("Enter the contact's address: ");
					String address = sc.nextLine();
					System.out.print("Enter the contact's birthday (MM/DD/YYYY): ");
					String birthday = sc.nextLine();
					System.out.print("Enter any notes for the contact: ");
					String notes = sc.nextLine();
					
					Contact c = new Contact(contactName,phoneNumber,emailAddress,address,birthday,notes);
					if(p.addContact(c))
						System.out.println("\n\nContact added successfully!\n");
					else
						System.out.println("\n\nContact is already in the contact list!\n");
					break;
				case 2:
					// searchContact();
					System.out.print("Enter search criteria: \n1.Name\n2.Phone Number\n3.Email Address\n4.Address\n5.Birthday\n\nEnter your choice: ");
					int j = sc.nextInt();
					sc.nextLine();
					System.out.println();
					switch(j) 
					{
					case 1:
						System.out.println("Enter the Contact's name: ");
						p.searchForContact(sc.next()+sc.nextLine(), j);
						break;
					case 2:
						System.out.println("Enter the Contact's Phone number: ");
						p.searchForContact(sc.next()+sc.nextLine(), j);
						break;
					case 3:
						System.out.println("Enter the Contact's Email Address: ");
						p.searchForContact(sc.next()+sc.nextLine(), j);
						break;
					case 4:
						System.out.println("Enter the Contact's Address: ");
						p.searchForContact(sc.next()+sc.nextLine(), j);
						break;
					case 5:
						System.out.println("Enter the Contact's Birthday: ");
						p.searchForContact(sc.next()+sc.nextLine(), j);
						break;
					default:
						System.out.println("Wrong input!\n");
					}
					break;
				case 3:
					// deleteContact();
					System.out.print("Enter the contact name to be deleted: ");
					p.deleteContact(sc.nextLine());
					break;
				case 4:
					System.out.print("Enter event title: ");
					String eventTitle = sc.nextLine();
					System.out.print("Enter contact name: ");
					String contName = sc.nextLine();
					System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
					String date_time = sc.nextLine();
					System.out.print("Enter event location: ");
					String location = sc.nextLine();
					Contact co = listC.searchContact(contName, 1);
					if(co==null)
						System.out.println("Contact is not in the contact list!\n");
					else 
					{
						Event e = new Event(eventTitle,date_time,location,co);
						if(p.addEvent(e))
							System.out.println("\nEvent added successfully!\n");
						else
							System.out.println("\nThere is a conflict in time with another Event.\n");
					}
					break;
				case 5:
					System.out.print("Enter search criteria: \n1.Contact Name\n2.Event title\n\nEnter your choice: ");
					int i = sc.nextInt();
					sc.nextLine();
					if(i==1) 
					{
						System.out.print("\nEnter the contact name: ");
						p.printEvent(sc.next()+sc.nextLine(), i);
					}else if(i==2) 
					{
						System.out.print("\nEnter the event title: ");
						p.printEvent(sc.next()+sc.nextLine(), i);
					}else
						System.out.println("\nPlease enter a valid choice (1-2).");
					break;
				case 6:
					System.out.print("\nEnter the first name: ");
					p.printByFirstName(sc.next());
					break;
				case 7:
					p.printAllEventsAlphabetically();
					break;
				case 8:
					System.out.println("Exiting the program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.\n");
				}
			} catch (InputMismatchException e) { // Handle input mismatch exception
				System.out.println("Invalid input. Please enter a valid choice (1-8).");
				sc.nextLine();
				choice = 0; // Reset choice
			}
		} while (choice != 8);
	}

}
