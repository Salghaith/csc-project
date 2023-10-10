
public class Event 
{
	public String title;
	public String date_time;
	public String location;
	public Contact contact;
	
	@Override
	public String toString() {
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
	
}
