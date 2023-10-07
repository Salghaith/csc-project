
public class test 
{
	static LinkedList<Event> listE = new LinkedList<Event>();
	
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	static Phonebook p = new Phonebook(listC,listE);
	
	static LinkedList List = new LinkedList();
	
	public static void main(String[] args) 
	{
		Contact c = new Contact("Saad", "10/04/2023", "MAC", "Alhamra", "S", "S");
		Contact c1 = new Contact("Khaled", "10/04/2023", "MAC", "Alhamra", "S", "S");
		Contact c2 = new Contact("Khal", "055", "MAC", "Ahmed 7sn", "S", "S");
		Contact c3 = new Contact("Bader", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		p.addContact(c);
		p.addContact(c1);
		p.addContact(c2);
		p.addContact(c3);

		Contact[] Arc = {c,c1,c3};
		Contact[] Arc1 = {c2};

		Event e = new Event("Meeting","01/18/2024 12:30","CCIS meeting room",Arc);
		Event e1 = new Event("Lunch","01/18/2024 12:30","CCIS meeting room",Arc1);
		Event e2 = new Event("Lunch","01/08/2024 12:30","CCIS meeting room",Arc1);


		p.addEvent(e);
		p.addEvent(e1);
		p.addEvent(e2);
		//listE.insert(e1);
		//listE.insert(e2);
		//listE.insert(e3);
		//p.printAllEvents();
		//p.printSameEvent("Meeting");
		p.deleteContact("Saad");
		p.printAllEvents();
	}
}

