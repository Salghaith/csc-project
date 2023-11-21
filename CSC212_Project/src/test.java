
public class test {
	static LinkedList<Event> listE = new LinkedList<Event>();
	static LinkedList<Contact> listC = new LinkedList<Contact>();
	static ContactBST bst = new ContactBST();
	static Phonebook p = new Phonebook(bst, listE);
	public static void main(String[] args) {
		Contact c1 = new Contact("Saleh","0533456622","SA@g.com","Alhamra","10/03/2004","Siiiu");
		Contact c2 = new Contact("Ahmed","053345662","SA@g.com","Alhamra","10/03/2004","Siiiu");
		

		if(p.addContactBST(c1))
			System.out.println("Added");
		else
			System.out.println("Not added");
		
		if(p.addContactBST(c2))
			System.out.println("Added");
		else
			System.out.println("Not added");
		listC.insert(c2);
	}
}
