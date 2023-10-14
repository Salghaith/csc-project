
public class LinkedList<T> implements Comparable<T>
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
	public boolean last() 
	{
			return current.next==null;
	}
	public void findFirst() 
	{
		current = head;
	}
	public void findnext() //no need.
	{
		current=current.next;
	}
	public T retrieve() //no need.
	{
		return current.data;
	}
	public void update(T val) //no need.
	{
		current.data=val;
	}
	public void print() //delete it.
    {
         findFirst();
            while (current != null) 
            {
                System.out.println("Title: " + ((Event)(current).data).getTitle());
                //System.out.println("Date/Time: " + current.date_time);
                //System.out.println("Location: " + current.location);
                //System.out.println("Contact Name: " + current.contactName);
                System.out.println();
                current = current.next;
            }
    }
	
	public void insert(T val) //This method should add contact and event alphabetically.
	{
		Node<T> tmp = new Node<T>(val);
		if (empty())
			current = head = tmp;
		else 
		{	
			findFirst();
			if(tmp.data instanceof Event) 				
			{
				Node<T> previous=null;
				while(current!=null) 
				{
					
					if(((Event)(tmp).data).getTitle().compareTo(((Event)(current).data).getTitle())<0) 
					{
						if(current==head) 
						{
							Node<T> x = head;
							head = tmp;
							head.next=x;
						}else 
						{
							tmp = previous.next;
							previous.next = new Node<T>(val);
							previous = previous.next;
							previous.next = tmp;
						}
						break;
					}
					else if(current.next==null) 
					{
						tmp = current.next;
						current.next = new Node<T>(val);
						current = current.next;
						current.next =null;
					}
					previous = current;
					current = current.next;
				}
			}
			else if(tmp.data instanceof Contact) 				
			{
				Node<T> previous=null;
				while(current!=null) 
				{
					
					if(((Contact)(tmp).data).getName().compareTo(((Contact)(current).data).getName())<0) 
					{
						if(current==head) 
						{
							Node<T> x = head;
							head = tmp;
							head.next=x;
						}else 
						{
							tmp = previous.next;
							previous.next = new Node<T>(val);
							previous = previous.next;
							previous.next = tmp;
						}
						break;
					}
					else if(current.next==null) 
					{
						tmp = current.next;
						current.next = new Node<T>(val);
						current = current.next;
						current.next =null;
					}
					previous = current;
					current = current.next;
				}
			}
		}
	}

	public void remove(T val) 
	{	//This method should delete the given obj.
        Node<T> temp = new Node<T>(val);
		if (head == null) 
		{
            return;
        }

        if (head.data.equals(temp.data)) 
        {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) 
        {
            if (current.data.equals(temp.data)) 
            {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
	
	public boolean search (T val) 
	{	//delete it.
        findFirst();
        while (current != null) 
        {
            if ( current.data.equals(val))
                return true;
            current = current.next;
        }
        return false ;
    }
	public Contact searchContact (String val,int i) //This method will search for a contact based on their name,phone number,email,address,or birthday.
	{
		Contact flag =null;
		findFirst();
		switch(i) 
		{
		case 1: 				// name	i=1
			while(current!=null) 
			{
				if((((Contact)(current).data).getName().equalsIgnoreCase(val)))
					return (Contact)current.getData();
				current = current.next;
			}
			return null;
		case 2:					//number i=2
			while(current!=null) 
			{
				if((((Contact)(current).data).getPhoneNumber().equalsIgnoreCase(val)))
					return (Contact)current.getData();
				current = current.next;
			}
			return null;
		case 3:					//email i=3
			while(current!=null) 
			{
				if((((Contact)(current).data).getEmail().equalsIgnoreCase(val))) 
				{
					System.out.println(((Contact)(current).data).toString());
					flag = ((Contact)(current).data);
				}
				current = current.next;
			}
			return flag == null ? null : flag;
		case 4:					//address i=4
			while(current!=null) 
			{
				if((((Contact)(current).data).getAddress().equalsIgnoreCase(val))) 
				{
					System.out.println(((Contact)(current).data).toString());
					flag = ((Contact)(current).data);
				}
				current = current.next;
			}
			return flag == null ? null : flag;
		case 5:					//birthday i=5
			while(current!=null) 
			{
				
				if((((Contact)(current).data).getBirthday().equalsIgnoreCase(val))) 
				{
					System.out.println(((Contact)(current).data).toString());
					flag = ((Contact)(current).data);
				}
				current = current.next;
			}
			return flag == null ? null : flag;
			default : return null;
		}
    }
	
	public T searchEvent(String val, int i) 	//This method will search for an event by contact name or event title and return it.
	{
		findFirst();
		switch(i) 
		{
		case 1:					//Contact name  i=1
			while(current!=null) 
			{
				Contact tmp = (((Event)(current).data).getContact());
				if(tmp.getName().equalsIgnoreCase(val))
					return current.getData();
				current = current.next;
			}
			return null;
		case 2: 				// title	i=2
			while(current!=null) 
			{
				if((((Event)(current).data).getTitle().equalsIgnoreCase(val)))
					return current.getData();
				current = current.next;
			}return null;
		default:
			return null;
		}
	}
	
	@Override
	public int compareTo(T o) 
	{
		return 0;
	}
}

