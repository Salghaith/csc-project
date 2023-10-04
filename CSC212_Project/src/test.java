
public class test 
{
	static LinkedList<Event> listE = new LinkedList<Event>();
	
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	
	static LinkedList List = new LinkedList();
	
	public static void main(String[] args) 
	{
		Contact e = new Contact("E", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e1 = new Contact("C", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e2 = new Contact("A ", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e3 = new Contact("B", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e4 = new Contact("Zyad", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");

		listC.insert(e);

		listC.insert(e1);
		listC.insert(e2);
		listC.insert(e3);
		listC.insert(e4);
		listC.print();
		System.out.println("Khaled");
		

	}
}

