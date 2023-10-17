import java.util.InputMismatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhonebookApp 
{
	static LinkedList<Event> listE = new LinkedList<Event>();
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	static Phonebook p = new Phonebook(listC, listE);
	static Scanner sc = new Scanner(System.in);
	
	    public static boolean isValidDate(String inputDate) 
	    {
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

	                if (month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >= 1900 &&
	                    hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
	                    return true;
	                }
	            }
	        } catch (ParseException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
	            // Parsing or validation failed
	        }
	        return false;
	    }
	    
	public static void main(String[] args) 
	{
		int choice;
		boolean bflag,dflag;
		System.out.println("Welcome to the Linked Tree Phonebook!");

		do 
		{
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

			try 
			{
				choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) 
			  {
				case 1: //Add a contact.
					bflag = true;
					String birthday = "";
					System.out.print("\nEnter the contact's name: ");
					String contactName = sc.nextLine();
					System.out.print("Enter the contact's phone number: ");
					String phoneNumber = sc.nextLine();
					System.out.print("Enter the contact's email address: ");
					String emailAddress = sc.nextLine();
					System.out.print("Enter the contact's address: ");
					String address = sc.nextLine();
					while(bflag) 
					{
					System.out.print("Enter the contact's birthday (MM/DD/YYYY): ");
		            birthday = sc.nextLine();
					if(isValidDate(birthday))
						bflag = false;
					else
						System.out.println("Invalid birthday, Try again!");
					}
					System.out.print("Enter any notes for the contact: ");
					String notes = sc.nextLine();

					Contact c = new Contact(contactName, phoneNumber, emailAddress, address, birthday, notes);
					if (p.addContact(c))
						System.out.println("\nContact added successfully!");
					else
						System.out.println("\n\nContact is already in the contact list!\n");
					break;
				case 2: //Search for a contact.
					int choice2 = 0;
					boolean flag = true;
					while (flag) 
					{
						try 
						{
							System.out.print(
									"\nEnter search criteria: \n1.Name\n2.Phone Number\n3.Email Address\n4.Address\n5.Birthday\n\nEnter your choice: ");
							choice2 = sc.nextInt();
							sc.nextLine();
							flag = false;
							System.out.println();
							switch (choice2) {
							case 1: //Search by name
								System.out.print("Enter the contact's name: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 2: //Search by phone number
								System.out.print("Enter the contact's phone number: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 3: //Search by email address
								System.out.print("Enter the contact's email Address: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 4: //Search by address
								System.out.print("Enter the contact's address: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							case 5: //Search by birthday
								System.out.print("Enter the contact's birthday: ");
								p.searchForContact(sc.next() + sc.nextLine(), choice2);
								break;
							default:
								System.out.println("Invalid choice!, Please enter a valid choice (1-5).");
								flag = true;
							}
						} catch (InputMismatchException e) 
						{
							System.out.println("\nInvalid input!, Please enter a valid choice (1-5).");
							sc.nextLine();
						}
					}
					break;
				case 3: //Delete a contact.
					System.out.print("\nEnter the contact's name to be deleted: ");
					p.deleteContact(sc.nextLine());
					break;
				case 4: //Schedule an event.
					dflag = true;
					String date_time = "";
					System.out.print("Enter event title: ");
					String eventTitle = sc.nextLine();
					System.out.print("Enter contact name: ");
					String contName = sc.nextLine();
					while(dflag)
					{
					System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
					date_time = sc.nextLine();
					if(isValidDateTime(date_time))
						dflag = false;
					else
						System.out.println("Invalid date and time, Try again!");
					}
					System.out.print("Enter event location: ");
					String location = sc.nextLine();
					Contact contact = listC.searchContact(contName, 1);
					if (contact == null)
						System.out.println("\nContact is not in the contact list!");
					else 
					{
						Event e = new Event(eventTitle, date_time, location, contact);
						if (p.addEvent(e))
							System.out.println("\nEvent scheduled successfully!");
						else
							System.out.println("\nThere is a conflict in time with another Event.\n");
					}
					break;
				case 5: //Print event details.
					boolean check = true;
					while (check) 
					{
						try 
						{
							System.out.print(
									"\nEnter search criteria: \n1.Contact name\n2.Event title\n\nEnter your choice: ");
							int choice5 = sc.nextInt();
							sc.nextLine();
							check = false;
							if (choice5 == 1) //Search by contact name.
							{ 
								System.out.print("\nEnter the contact name: ");
								p.printEvent(sc.next() + sc.nextLine(), choice5);
							} else if (choice5 == 2) //Search by event title.
							{
								System.out.print("\nEnter the event title: ");
								p.printEvent(sc.next() + sc.nextLine(), choice5);
							} else 
							{
								System.out.println("\nInvalid choice!, Please enter a valid choice (1-2).");
								check = true;
							}
						} catch (InputMismatchException e) 
						  {
							System.out.println("\nInvalid input!, Please enter a valid choice (1-2).");
							sc.nextLine();
						  }
					}
					break;
				case 6: //Print contacts by first name.
					System.out.print("\nEnter the first name: ");
					p.printByFirstName(sc.next());
					break;
				case 7: //Print all events alphabetically.
					p.printAllEventsAlphabetically();
					break;
				case 8: //Exit.
					System.out.println("Exiting the Phonebook. Goodbye!");
					break;
				default:
					System.out.println("\nInvalid choice, Please enter a valid choice (1-8).");
			  }
			}catch(InputMismatchException e) {
				System.out.println("\nInvalid input, Please enter a valid choice (1-8).");
				sc.nextLine();
				choice = 0; //Reset choice
			}
			catch ( Exception ex) //Handle input mismatch exception
			  { 
				//System.out.println("\nInvalid input, Please enter a valid choice (1-8).");
				sc.nextLine();
				choice = 0; //Reset choice
			  }
		} while (choice != 8);
	}

}
