import java.util.Arrays;

/****************************
 * CLASS: Event.java CSC212 Data structures - Project phase II Fall 2023 EDIT
 * DATE: 10/17/2023 TEAM: HERMANOS AUTHORS: Khaled Abdulrahman AlHarbi,
 * (443102249) Saud Nasser AlKatheeri, (443100710) Saleh Bader AlGhaith,
 * (443101007)
 ***********************************/
public class Event implements Comparable<Event> {
	private String title;
	private String date_time;
	private String location;
	private ContactBST contacts;

	public void display() {
		System.out.print("Event title: " + title + "\nContact Name(s): ");
		contacts.display(contacts.root);
		System.out.println(
				"\nEvent date and time (MM/DD/YYYY HH:MM): " + date_time + "\nEvent location:" + location + "\n");
	}

	public Event(Event val) {
		this.title = val.title;
		this.date_time = val.date_time;
		this.location = val.location;
		this.contacts = val.contacts;
	}

	public Event(String title, String date_time, String location, ContactBST c) {
		this.title = title;
		this.date_time = date_time;
		this.location = location;
		contacts = c;
	}

	public Event() {
		this.title = null;
		this.date_time = null;
		this.location = null;
		this.contacts = null;
	}

	public String getTitle() {
		return title;
	}

	public String getDate_time() {
		return date_time;
	}

	public String getLocation() {
		return location;
	}

	public ContactBST getContact() {
		return contacts;
	}

	public int compareTo(Event o) {
		return this.title.toUpperCase().compareTo(o.title.toUpperCase());
	}

}
