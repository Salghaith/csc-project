
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
				return false;
			}
			current = current.getNext();
		}
		listE.insert(e);
		return true;
	}
	public void printEvent(String val,int i) 	//This method will search for an Event and return it as a String if founded successfully. 
	{	
		Event e = (Event)listE.searchEvent(val, i);
		if(e==null)
			System.out.println("Event not found!"); 
		else 
			 System.out.println(e.toString());
	}
	
	public void printAllEventsAlphabetically() 	//This method will print all the Events.
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
		boolean flag = false;
		while(current!=null) 
		{
			String tmp = current.getData().getName();
			
			if (tmp.length() < name.length() || tmp.length() != name.length() && tmp.substring(name.length(), name.length() + 1).charAt(0) != ' ') 
			{
				current=current.getNext();
				continue;
			}
			tmp = tmp.substring(0, name.length());
			if(tmp.equalsIgnoreCase(name)) 
			{
				System.out.println(current.getData().toString());	
				flag=true;
			}
			current=current.getNext();
		}
		if(!flag)
			System.out.println("No contact with first name: "+name);
	}
	public void printSameEvent(String title) 	//This method should print all contacts that share an event.
	{
		Event event = listE.searchEvent(title, 1);
		if(event==null)
			System.out.println("Event not found!");
		else 
		{
			Node<Contact> current = listC.getHead();
			while(current!=null) 
			{
				if(((Contact)current.getData()).getEvent().getTitle().equalsIgnoreCase(title))
					System.out.println(current.getData().toString());
				current=current.getNext();
			}
		}
	}
	public void deleteContact(String name) 	//This method should delete the contact and his event.
	{
		Contact del = listC.searchContact(name, 1);
		if(del==null)
			System.out.println("\nContact not found to be deleted!");
		else 
		{
		listC.remove(del);
		Node<Event> current = listE.getHead();
		while(current!=null) 
			{
				if(((Event)current.getData()).getContact().getName().equalsIgnoreCase(del.getName()))
					listE.remove(current.getData());
			current=current.getNext();
			}
		System.out.println("\nContact was deleted successfully!");
		}
	}
}
