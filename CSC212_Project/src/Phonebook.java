/****************************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE: 10/17/2023
TEAM: HERMANOS
AUTHORS:
Khaled Abdulrahman AlHarbi, (443102249)
Saud Nasser AlKatheeri, 	(443100710)
Saleh Bader AlGhaith, 		(443101007)
***********************************/
public class Phonebook 	
{
	LinkedList<Contact> listC;
	LinkedList<Event> listE;
	
	public Phonebook(LinkedList<Contact> c,LinkedList<Event> e) 
	{
		listC = c;
		listE = e;
	}
	public boolean addContact(Contact c) 	//This method returns true if contact added successfully, otherwise false.
	{
		if(listC.searchContact(c.getName(),1) == null && listC.searchContact(c.getPhoneNumber(),2) == null) 
		{
			listC.insert(c);
			return true;
		}
		return false;
	}
	public boolean addEvent(Event e) 	//This method returns true if Event added successfully, otherwise false.
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
	public void printEvent(String val,int i) 	//This method searches for an Event and print it, if founded successfully,,. 
	{	
		Event e = null;
		if(i==1) 
		{
			e = listE.searchEvent(val,i);
			if(e==null)
				System.out.println("\nEvent not found!");
		}
		else
			printSameEvent(val);
		 
	}
	
	public void printAllEventsAlphabetically() 	 //This method prints all the Events sorted alphabetically.
	{
		Node<Event> current = listE.getHead();
		boolean flag = false;
		while(current!=null) 
		{
			System.out.println(current.getData().toString()+"\n");
			flag=true;
			current = current.getNext();
		}
		if(!flag)
			System.out.println("No event scheduled!.");
	}
	
	public void searchForContact(String val , int i) //This method prints the contact if founded in the list.
	{
		if(i==3|i==4|i==5) 
		{
			if(listC.searchContact(val,i)==null)
				System.out.println("\nContact not found!");
		}
		else 
		{
			Contact c = listC.searchContact(val,i);
			if(c==null)
				System.out.println("\nContact not found!");
			else
				System.out.println(c.toString());
		}
	}
	public void printByFirstName(String name) 	//This method prints all contacts that share the FirstName.
	{
		Node<Contact> current = listC.getHead();
		boolean flag = false;
		while(current!=null) 
		{
			String tmp = current.getData().getName();
			
			if (tmp.length() < name.length() || tmp.length() != name.length() && tmp.charAt(name.length()) != ' ') 
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
			System.out.println("\nNo contact with first name: "+name);
	}
	public void printSameEvent(String title)  //This method prints all contacts that share an event.
	{
		Event event = listE.searchEvent(title, 2);
		if(event==null)
			System.out.println("\nEvent not found!");
		else 
		{
			Node<Event> current = listE.getHead();
			while(current!=null) 
			{
				if(((Event)current.getData()).getTitle().equalsIgnoreCase(title))
					System.out.println(current.getData().toString());
				current=current.getNext();
			}
		}
	}
	public void deleteContact(String name) 	   //This method deletes the contact and all their events.
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
