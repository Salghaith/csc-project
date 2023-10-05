
public class test 
{
	static LinkedList<Event> listE = new LinkedList<Event>();
	
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	static Phonebook p = new Phonebook(listC,listE);
	
	static LinkedList List = new LinkedList();
	
	public static void main(String[] args) 
	{
		Contact c = new Contact("Saad", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact c1 = new Contact("Khaled", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact c2 = new Contact("Ahmed ", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact c3 = new Contact("Bader", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		listC.insert(c);
		listC.insert(c1);
		listC.insert(c2);
		listC.insert(c3);
		Event e = new Event("Dinner with saad","10/07/2023 23:32","MAc",c);
		Event e1 = new Event("Lunch with saad","10/07/2023 23:32","MAc",c);
		Event e2 = new Event("Breakfast with saad","10/07/2023 23:32","MAc",c);
		Event e3 = new Event("Aid saad","10/07/2023 23:32","MAc",c);

		listE.insert(e);
		listE.insert(e1);
		listE.insert(e2);
		listE.insert(e3);
		p.printAllEvents();
		

	}
}

