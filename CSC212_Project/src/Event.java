
public class Event 
{
	public String title;
	public String contactName;
	public String date_time;
	public String location;
	public Contact contact;
	
	
	@Override
	public String toString() {
		return "Event title=" + title +"\n" + ", Contact Name=" + contactName + "\n" + ", date_time=" + date_time + "\n" +", location="
				+ location;
	}
	public Event(Event val) 
	{
		this.title = val.title;
		this.date_time = val.date_time;
		this.location = val.location;
		this.contactName = val.contactName;
	}
	public Event(String title, String date_time, String location, Contact c) 
	{
		this.title = title;
		this.date_time = date_time;
		this.location = location;
		Contact contact = c;
		this.contactName = c.getName();
	}
	
	public Event() 
	{
		this.title = null;
		this.date_time = null;
		this.location = null;
		this.contactName = null;
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
	
	public String getContactName() 
	{
		return contactName;
	}
	
}
