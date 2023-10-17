/****************************
CLASS: Event.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE: 10/17/2023
TEAM: HERMANOS
AUTHORS:
Khaled Abdulrahman AlHarbi, (443102249)
Saud Nasser AlKatheeri, 	(443100710)
Saleh Bader AlGhaith, 		(443101007)
***********************************/
public class Event implements Comparable<Event> 
{
	private String title;
	private String date_time;
	private String location;
	private Contact contact;
	
	@Override
	public String toString() 
	{
		return "\nEvent title: " + title + "\nContact Name: " + contact.getName() + "\nEvent date and time (MM/DD/YYYY HH:MM): " + date_time +"\nEvent location:"
				+ location+"\n";
	}
	public Event(Event val) 
	{
		this.title = val.title;
		this.date_time = val.date_time;
		this.location = val.location;
		this.contact=val.contact;
	}
	public Event(String title, String date_time, String location, Contact c) 
	{
		this.title = title;
		this.date_time = date_time;
		this.location = location;
		contact = c;
	}
	
	public Event() 
	{
		this.title = null;
		this.date_time = null;
		this.location = null;
		this.contact=null;	
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public String getDate_time() 
	{
		return date_time;
	}
	
	public String getLocation() 
	{
		return location;
	}
	
	public Contact getContact() 
	{
		return contact;
	}
	public int compareTo(Event o) {
        return this.title.toUpperCase().compareTo(o.title.toUpperCase());
    }
}
