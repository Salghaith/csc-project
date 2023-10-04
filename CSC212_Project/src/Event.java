
public class Event 
{
	public String title;
	public String date_time;
	public String location;
	public String contactName;
	
	
	public Event(Event val) 
	{
		this.title = val.title;
		this.date_time = val.date_time;
		this.location = val.location;
		this.contactName = val.contactName;
	}
	public Event(String title, String date_time, String location, String contactName) 
	{
		this.title = title;
		this.date_time = date_time;
		this.location = location;
		this.contactName = contactName;
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
