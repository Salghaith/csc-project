
/****************************
 * CLASS: PhonebookApp.java 
 * CSC212 Data structures - Project phase II Fall 2023 
 * EDIT DATE:
 * 12/2/2023 
 * TEAM: 
 * HERMANOS 
 * AUTHORS: 
 * Khaled Abdulrahman AlHarbi, (443102249)
 * Saud Nasser AlKatheeri, (443100710) 
 * Saleh Bader AlGhaith, (443101007)
 ***********************************/
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class PhonebookApp {
	static LinkedList<Event> listE = new LinkedList<Event>();
	static ContactBST bst = new ContactBST();
	static Phonebook p = new Phonebook(bst, listE);

	public static void main(String[] args) {
		int choice = 0;
		boolean bflag, dflag, pflag;
		System.out.println("Welcome to the BST Phonebook!");
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nPlease choose an option:");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event/appointment");
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
				case 1: // Add a contact.
					bflag = pflag = true;

					String birthday = "";
					String phoneNumber = "";
					System.out.print("\nEnter the contact's name: ");
					String contactName = sc.nextLine();
					while (pflag) {
						System.out.print("Enter the contact's phone number: ");
						phoneNumber = sc.nextLine();
						if (isValidPhoneNumber(phoneNumber))
							pflag = false;
						else
							System.out.println("Invalid Phone number, Try again!");
					}
					System.out.print("Enter the contact's email address: ");
					String emailAddress = sc.nextLine();
					System.out.print("Enter the contact's address: ");
					String address = sc.nextLine();
					while (bflag) {
						System.out.print("Enter the contact's birthday (MM/DD/YYYY): ");
						birthday = sc.nextLine();
						if (isValidDate(birthday))
							bflag = false;
						else
							System.out.println("Invalid birthday, Try again!");
					}
					System.out.print("Enter any notes for the contact: ");
					String notes = sc.nextLine();

					Contact c = new Contact(contactName.trim(), phoneNumber, emailAddress, address, birthday, notes);
					if (p.addContactBST(c)) {
						System.out.println("\nContact added successfully!");
					} else
						System.out.println("\n\nContact is already in the contact list!\n");
					break;
				case 2: // Search for a contact.
					int choice2 = 0;
					bflag = pflag = true;
					boolean flag = true;
					while (flag) {
						try {
							System.out.print(
									"\nEnter search criteria: \n1.Name\n2.Phone Number\n3.Email Address\n4.Address\n5.Birthday\n\nEnter your choice: ");
							choice2 = sc.nextInt();
							sc.nextLine();
							flag = false;
							System.out.println();
							switch (choice2) {
							case 1: // Search by name
								System.out.print("Enter the contact's name: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 2: // Search by phone number
								String sPhoneNumber = "";
								while (pflag) {
									System.out.print("Enter the contact's phone number: ");
									sPhoneNumber = sc.nextLine();
									if (isValidPhoneNumber(sPhoneNumber))
										pflag = false;
									else
										System.out.println("Invalid Phone number, Try again!");
								}
								p.searchForContact(sPhoneNumber, choice2);
								break;
							case 3: // Search by email address
								System.out.print("Enter the contact's email address: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 4: // Search by address
								System.out.print("Enter the contact's address: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 5: // Search by birthday
								String sBirthday = "";
								while (bflag) {
									System.out.print("Enter the contact's birthday (MM/DD/YYYY): ");
									sBirthday = sc.nextLine();
									if (isValidDate(sBirthday))
										bflag = false;
									else
										System.out.println("Invalid birthday, Try again!");
								}
								p.searchForContact(sBirthday, choice2);
								break;
							default:
								System.out.println("Invalid choice!, Please enter a valid choice (1-5).");
								flag = true;
							}
						} catch (InputMismatchException e) {
							System.out.println("\nInvalid input!, Please enter a valid choice (1-5).");
							sc.nextLine();
						}
					}
					break;
				case 3: // Delete a contact.
					System.out.print("\nEnter the contact's name to be deleted: ");
					p.deleteContact(sc.nextLine());
					break;
				case 4: // Schedule an event.
					dflag = true;
					String date_time = "";
					boolean check = true;
					int choice4 = 0;
					while (check) {
						try {
							System.out.print("\nEnter type:\n1.event\n2.appointment\n\nEnter your choice: ");
							choice4 = sc.nextInt();
							sc.nextLine();
							if (choice4 == 1 | choice4 == 2)
								check = false;
							else {
								System.out.println("\nInvalid choice!, Please enter a valid choice (1-2).");
								check = true;
							}
						} catch (InputMismatchException e) {
							System.out.println("\nInvalid input!, Please enter a valid choice (1-2).");
							sc.nextLine();
						}
					}
					System.out.print("\nEnter event title: ");
					String eventTitle = sc.nextLine();
					String[] stringArray = null;
					ContactBST bstE = new ContactBST();
					if (choice4 == 1) { // Event
						System.out.print("Enter contacts name separated by a comma: ");
						String contName = sc.nextLine();
						stringArray = contName.split(",");
						for (int i = 0; i < stringArray.length; i++) {
							stringArray[i] = stringArray[i].trim();
						}
						boolean flag4 = true;
						String ContactNotFound = null;
						for (int i = 0; i < stringArray.length; i++) {
							flag4 = bst.findkey(stringArray[i]);
							if (!flag4) {
								ContactNotFound = stringArray[i];
								break;
							} else
								bstE.insert(bst.searchName(stringArray[i]));
						}
						if (!flag4) {
							System.out.println();
							System.out.println(ContactNotFound + " not found in the Contact list!");
							continue;
						}
					} else // Appointment
					{
						System.out.print("Enter contact name: ");
						String contName = sc.nextLine();
						contName = contName.trim();
						if (!bst.findkey(contName)) {
							System.out.println();
							System.out.println(contName + " not found in the Contact list!");
							break;
						} else
							bstE.insert(bst.searchName(contName));

					}
					while (dflag) {
						System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
						date_time = sc.nextLine();
						if (isValidDateTime(date_time))
							dflag = false;
						else
							System.out.println("Invalid date and time, Try again!");
					}
					System.out.print("Enter event location: ");
					String location = sc.nextLine();

					Event e = new Event(eventTitle, date_time, location, bstE);
					if (p.addEvent(e))
						System.out.println("\nEvent scheduled successfully!");
					else
						System.out.println("\nThere is a conflict in time with another Event.\n");
					break;
				case 5: // Print event details.
					check = true;
					while (check) {
						try {
							System.out.print(
									"\nEnter search criteria: \n1.Contact name\n2.Event title\n\nEnter your choice: ");
							int choice5 = sc.nextInt();
							sc.nextLine();
							check = false;
							if (choice5 == 1) // Search by contacts name.
							{
								System.out.print("\nEnter the contact name: ");
								p.printEvent(sc.next() + sc.nextLine(), choice5);
							} else if (choice5 == 2) // Search by event title.
							{
								System.out.print("\nEnter the event title: ");
								p.printEvent(sc.next() + sc.nextLine(), choice5);
							} else {
								System.out.println("\nInvalid choice!, Please enter a valid choice (1-2).");
								check = true;
							}
						} catch (InputMismatchException e1) {
							System.out.println("\nInvalid input!, Please enter a valid choice (1-2).");
							sc.nextLine();
						}
					}
					break;
				case 6: // Print contacts by first name.
					System.out.print("\nEnter the first name: ");
					p.printByFirstName(sc.next());
					break;
				case 7: // Print all events alphabetically.
					p.printAllEventsAlphabetically();
					break;
				case 8: // Exit.
					sc.close();
					System.out.println("Exiting the Phonebook. Goodbye!");
					break;
				default:
					System.out.println("\nInvalid choice, Please enter a valid choice (1-8).");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input, Please enter a valid choice (1-8).");
				sc.nextLine();
				choice = 0; // Reset choice
			} catch (NoSuchElementException e) {
				System.out.println("\n\nProgram suspended\nExiting the Phonebook, Goodbye!");
				break;
			} catch (Exception ex) // Handle exception
			{
				System.out.println("Something went wrong!");
				sc.nextLine();
				choice = 0; // Reset choice
				continue;
			}
		} while (choice != 8);
	}

	public static boolean isValidDate(String inputDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(inputDate);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isValidDateTime(String inputDateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		sdf.setLenient(false);

		try {
			Date dateTime = sdf.parse(inputDateTime);

			// Additional validation to ensure the date and time components are valid
			String[] components = inputDateTime.split(" ");
			if (components.length == 2) {
				String[] dateParts = components[0].split("/");
				String[] timeParts = components[1].split(":");

				int month = Integer.parseInt(dateParts[0]);
				int day = Integer.parseInt(dateParts[1]);
				int year = Integer.parseInt(dateParts[2]);
				int hour = Integer.parseInt(timeParts[0]);
				int minute = Integer.parseInt(timeParts[1]);

				if (month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >= 1900 && hour >= 0 && hour <= 23
						&& minute >= 0 && minute <= 59) {
					return true;
				}
			}
		} catch (ParseException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
			// Parsing or validation failed
		}
		return false;
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length(); i++)
			if (phoneNumber.charAt(i) == 43) // In case of +.
				continue;
			else if (phoneNumber.charAt(i) > 57 | phoneNumber.charAt(i) < 48)
				return false;
		return true;
	}

}