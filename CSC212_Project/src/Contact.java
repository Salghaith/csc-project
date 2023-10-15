
public class Contact implements Comparable<Contact>
{

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String notes;
	private Event event;
	
	@Override
	public String toString() 
	{
		return "\nName: " + name + "\nPhoneNumber: " + phoneNumber + "\nEmail Address: " + email + "\nAddress: " + address
				+ "\nBirthday: " + birthday + "\nNotes: " + notes;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public void setBirthday(String birthday) 
	{
		this.birthday = birthday;
	}

	public void setNotes(String notes) 
	{
		this.notes = notes;
	}

	public void setEvent(Event event) 
	{
		this.event = event;
	}

	public Contact(Contact val) 
	{
		this.name = val.name;
		this.phoneNumber = val.phoneNumber;
		this.email = val.email;
		this.address = val.address;
		this.birthday = val.birthday;
		this.notes = val.notes;
	}
	
	public Contact() 
	{
		this.name = null;
		this.phoneNumber = null;
		this.email = null;
		this.address = null;
		this.birthday = null;
		this.notes = null;
	}
	
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) 
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
	}

	public Event getEvent() 
	{
		return event;
	}

	public String getName() 
	{
		return name;
	}
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public String getEmail() 
	{
		return email;
	}

	public String getAddress() 
	{
		return address;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public String getNotes() 
	{
		return notes;
	}

	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
