
public class Phonebook 	
{
	LinkedList<Contact> listC;
	LinkedList<Event> listE;
	
	public Phonebook(LinkedList<Contact> c,LinkedList<Event> e) 
	{
		listC = c;
		listE = e;
	}
	public boolean addContact(Contact c) 
	{
		if(!listC.searchContact(c.getName(),1) && !listC.searchContact(c.getPhoneNumber(),2)) 
		{
			listC.insert(c);
			return true;
		}
		return false;
	}
	
	public String printEvent(String val,int i) 
	{	
		Event e = (Event)listE.searchEvent(val, i);
		if(e==null)
			return "Event not found!";
		else 
			return e.toString();
	}
	public void printAllEvents() 
	{
		Node<Event> n = listE.getHead();
		while(n!=null) 
		{
			System.out.println(n.getData().toString()+"\n");
			n = n.getNext();
		}
	}
}
