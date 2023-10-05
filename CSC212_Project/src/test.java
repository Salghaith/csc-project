
public class test 
{
	static LinkedList<Event> listE = new LinkedList<Event>();
	
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	
	static LinkedList List = new LinkedList();
	
	public static void main(String[] args) 
	{
		Contact e = new Contact("Saud", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e1 = new Contact("Khaled", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e2 = new Contact("Ahmed ", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e3 = new Contact("Bader", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e4 = new Contact("Zeyad", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e5 = new Contact("Talal", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e6 = new Contact("Abdullah", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e7 = new Contact("Saleh", "10/04/2023", "MAC", "Ahmed 7sn", "S", "S");
		Contact e8 = new Contact("XSDFA", "10das", "gC", "gre", "fd", "dfs");
		Contact e9 = new Contact("THHF", "10das", "gC", "gre", "fd", "dfs");
		Contact e10 = new Contact("PWEO", "10das", "gC", "gre", "fd", "dfs");
		
	
		listC.insert(e);
		listC.insert(e1);
		listC.insert(e2);
		listC.insert(e3);
		listC.insert(e4);
		/*listC.insert(e5);
		listC.insert(e6);
		listC.insert(e7);
		listC.insert(e8);
		listC.insert(e8);
		listC.insert(e9);
		listC.insert(e10);*/
		listC.print();
		listC.remove(e4);
		System.out.println("************");
		listC.print();
		System.out.println("khaled");
		

	}
}

