
public class Phonebook 	
{
	LinkedList<Contact> listC;
	LinkedList<Event> listE;
	
	public Phonebook(LinkedList<Contact> c,LinkedList<Event> e) 
	{
		listC = c;
		listE = e;
	}
	public boolean addContact(Contact c) 	//This method will return true if contact added successfully, otherwise false.
	{
		if(listC.searchContact(c.getName(),1) == null && listC.searchContact(c.getPhoneNumber(),2) == null) 
		{
			listC.insert(c);
			return true;
		}
		return false;
	}
	public boolean addEvent(Event e) 	//This method will return true if Event added successfully, otherwise false.
	{
		Node<Event> current = listE.getHead();
		while(current!=null) 
		{
			if(current.getData().getDate_time().equals(e.getDate_time())) 
			{
				System.out.println("There is a conflict with another Event");
				return false;
			}
			current = current.getNext();
		}
		listE.insert(e);
		return true;
	}
	public String printEvent(String val,int i) 	//This method will search for an Event and return it as a String if founded successfully. 
	{	
		Event e = (Event)listE.searchEvent(val, i);
		if(e==null)
			return "Event not found!";
		else 
			return e.toString();
	}
	
	public void printAllEvents() 	//This method will print all the Events.
	{
		Node<Event> current = listE.getHead();
		while(current!=null) 
		{
			System.out.println(current.getData().toString()+"\n");
			current = current.getNext();
		}
	}
	
	public void searchForContact(String val , int i) //This method will print the contact if founded in the list.
	{
		if(i==3|i==4|i==5) 
		{
			if(listC.searchContact(val,i)==null)
				System.out.println("Contact not found!");
		}
		else 
		{
		Contact c = listC.searchContact(val,i);
		if(c==null)
			System.out.println("Contact not found!");
		else
			System.out.println(c.toString());
		}
	}
	public void printByFirstName(String name) 	//This method will print all contacts with the same FirstName.
	{
		Node<Contact> current = listC.getHead();
		while(current!=null) 
		{
			String tmp = current.getData().getName();
			tmp = tmp.substring(0, name.length());
			if(tmp.equalsIgnoreCase(name))
				System.out.println(current.getData().toString());
			current=current.getNext();
		}
	}
	public void printSameEvent(String title) 	//This method should print all contacts that share an event.
	{
		Event event = listE.searchEvent(title, 1);
		if(event==null)
			System.out.println("Event not found!");
		else 
		{
			for(Contact c : event.getContacts())
				System.out.println(c.toString());
		}
	}
	public void deleteContact(String name) 
	{
		Contact del = listC.searchContact(name, 1);
		listC.remove(del);
		Node<Event> current = listE.getHead();
		while(current!=null) 
		{
			Contact[] contacts = current.getData().getContacts();
			for(Contact c : contacts)
				if(c==del)
					listE.remove(current.getData());
			current=current.getNext();
		}
	}
}
