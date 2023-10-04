
public class Contact
{

	public String name;
	public String phoneNumber;
	public String email;
	public String address;
	public String birthday;
	public String notes;
	
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
}
