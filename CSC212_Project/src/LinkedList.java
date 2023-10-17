/****************************
CLASS: LinkedList.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE: 10/17/2023
TEAM: HERMANOS
AUTHORS:
Khaled Abdulrahman AlHarbi, (443102249)
Saud Nasser AlKatheeri, 	(443100710)
Saleh Bader AlGhaith, 		(443101007)
***********************************/
public class LinkedList<T extends Comparable<T>> 
{
	private Node<T> head;
	private Node<T> current;
	
	public Node<T> getHead() 
	{
		return head;
	}

	public Node<T> getCurrent() 
	{
		return current;
	}

	public LinkedList() 
	{
		head=current=null;
	}
	
	public boolean empty() 
	{
		return head==null;
	}

	public void findFirst() 
	{
		current = head;
	}

	public void insert(T val) 	//This method adds given generic object and sorts alphabetically.
	{	
        Node<T> tmp = new Node<T>(val);
        if (empty())
            current = head = tmp;
        else 
        {
            findFirst();
            Node<T> previous = null;
            while (current != null) 
            {
                if ((tmp.getData()).compareTo(current.getData()) < 0) 
                {
                    if (current == head) 
                    {
                        Node<T> x = head;
                        head = tmp;
                        head.next = x;
                    } else 
                    {
                        tmp = previous.next;
                        previous.next = new Node<T>(val);
                        previous = previous.next;
                        previous.next = tmp;
                    }
                    break;
                } else if (current.next == null) 
                {
                    tmp = current.next;
                    current.next = new Node<T>(val);
                    current = current.next;
                    current.next = null;
                }
                previous = current;
                current = current.next;
            }
        }
    }
	public void remove(T val)  //This method deletes the given object from the linked list.
	{	
        Node<T> temp = new Node<T>(val);
		if (head == null) 
		{
            return;
        }

        if (head.getData().equals(temp.getData())) 
        {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) 
        {
            if (current.getData().equals(temp.getData())) 
            {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
	
	public Contact searchContact (String val,int i)//This method searches for a contact based on their name, phone number, email, address, or birthday and returns the contact.
	{											   //It prints contact information if they share the same email, address, or birthday.
		Contact flag =null;
		findFirst();
		switch(i) 
		{
		case 1: 				 // Name  i=1
			while(current!=null) 
			{
				if((((Contact)(current).getData()).getName().equalsIgnoreCase(val)))
					return (Contact)current.getData();
				current = current.next;
			}
			return null;
		case 2:					 // Phone number i=2
			while(current!=null) 
			{
				if((((Contact)(current).getData()).getPhoneNumber().equalsIgnoreCase(val)))
					return (Contact)current.getData();
				current = current.next;
			}
			return null;
		case 3:					 // Email  i=3
			while(current!=null) 
			{
				if((((Contact)(current).getData()).getEmail().equalsIgnoreCase(val))) 
				{
					System.out.println(((Contact)(current).getData()).toString());
					flag = ((Contact)(current).getData());
				}
				current = current.next;
			}
			return flag == null ? null : flag;
		case 4:					 // Address  i=4
			while(current!=null) 
			{
				if((((Contact)(current).getData()).getAddress().equalsIgnoreCase(val))) 
				{
					System.out.println(((Contact)(current).getData()).toString());
					flag = ((Contact)(current).getData());
				}
				current = current.next;
			}
			return flag == null ? null : flag;
		case 5:					 // Birthday  i=5
			while(current!=null) 
			{
				
				if((((Contact)(current).getData()).getBirthday().equalsIgnoreCase(val))) 
				{
					System.out.println(((Contact)(current).getData()).toString());
					flag = ((Contact)(current).getData());
				}
				current = current.next;
			}
			return flag == null ? null : flag;
			default : return null;
		}
    }
	
	public Event searchEvent(String val, int choice) 	//This method searches the event linked list by contact name or event title and returns the event.
	{													// It prints event information if they share the same contact name.
		findFirst();
		Event flag=null;
		int flag2=0;
		switch(choice) 
		{
		case 1:					// Contact name  i=1
			while(current!=null) 
			{
				Contact tmp = (((Event)(current).getData()).getContact());
				if(tmp.getName().equalsIgnoreCase(val)) 
				{
					if(flag2++==0)System.out.println("Event found!");
					System.out.println(((Event)current.getData()).toString());
					flag = (Event) current.getData();
				}
				current = current.next;
			}
			return flag == null ? null : flag;
			
		case 2: 				// Event title   i=2
			while(current!=null) 
			{
				if((((Event)(current).getData()).getTitle().equalsIgnoreCase(val)))
					return (Event)current.getData();
				current = current.next;
			}return null;
		default:
			return null;
		}
	}

	


}

