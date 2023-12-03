/****************************
 * CLASS: Phonebook.java 
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
public class Phonebook {
	LinkedList<Event> listE;
	ContactBST bst;

	public Phonebook(ContactBST bst, LinkedList<Event> e) {
		this.bst = bst;
		listE = e;
	}

	public boolean addContactBST(Contact c) { // This method returns true if Contact added successfully, otherwise
												// false.
		if (!bst.checkPN(bst.root, c.getPhoneNumber()) && bst.insert(c))
			return true;
		return false;
	}

	public boolean addEvent(Event e) // This method returns true if Event added successfully, otherwise false.
	{
		Node<Event> current = listE.getHead();
		while (current != null) {
			if (current.getData().getDate_time().equals(e.getDate_time())) {
				return false;
			}
			current = current.getNext();
		}
		listE.insert(e);
		return true;
	}

	public void printEvent(String val, int i) // This method searches for an Event and print it, if founded
												// successfully.
	{
		Event e = null;
		if (i == 1) {
			e = listE.searchEvent(val, i);
			if (e == null)
				System.out.println("\nEvent not found!");
		} else
			printSameEvent(val);

	}

	public void printAllEventsAlphabetically() // This method prints all the Events sorted alphabetically.
	{
		Node<Event> current = listE.getHead();
		boolean flag = false;
		while (current != null) {
			current.getData().display();
			flag = true;
			current = current.getNext();
		}
		if (!flag)
			System.out.println("\nNo event scheduled!.");
	}

	public void searchForContact(String val, int i) // This method prints the contact if founded in the list.
	{
		switch (i) {
		case 1: // Name
			Contact c = bst.searchName(val);
			if (c == null)
				System.out.println("\nContact not found!");
			else {
				System.out.println("\nContact found!");
				System.out.println(c.toString());
			}
			break;
		case 2: // PhoneNumber
			if (!bst.searchPhoneNumber(bst.root, val))
				System.out.println("\nContact not found!");
			break;
		case 3: // Email
			if (bst.searchEmail(val) == 0)
				System.out.println("\nContact not found!");
			break;
		case 4: // Address
			if (bst.searchAddress(val) == 0)
				System.out.println("\nContact not found!");
			break;
		case 5: // Birthday
			if (bst.searchBirthday(val) == 0)
				System.out.println("\nContact not found!");
			break;
		default:
			System.out.println("\nContact not found!");
			break;
		}
	}

	public void printByFirstName(String name) // This method prints all contacts that share the FirstName.
	{
		if (bst.printFirstName(name) == 0)
			System.out.println("\nNo contact with first name: " + name);
	}

	public void printSameEvent(String title) {
		Event event = listE.searchEvent(title, 2);
		if (event == null)
			System.out.println("\nEvent not found!");
		else {
			Node<Event> current = listE.getHead();
			while (current != null) {
				if (((Event) current.getData()).getTitle().equalsIgnoreCase(title))
					current.getData().display();
				current = current.getNext();
			}
		}
	}

	public void deleteContact(String name) // This method deletes the contact and all their events.
	{
		if (!bst.remove_key(name)) {
			System.out.println("\nContact not found to be deleted!");
			return;
		}
			
		else {
			Node<Event> current = listE.getHead();
			while (current != null) {
				ContactBST bstE = ((Event) current.getData()).getContact();
				if (bstE.findkey(name))
					bstE.remove_key(name);
				if (bstE.empty()) {
					listE.remove(current.getData());
					System.out.println("\nAppointment " + current.getData().getTitle() + " deleted!");
				}

				current = current.getNext();
			}
		}
		System.out.println("\nContact deleted successfully!");
	}
}