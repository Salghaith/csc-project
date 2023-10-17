/****************************
CLASS: Node.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE: 10/17/2023
TEAM: HERMANOS
AUTHORS:
Khaled Abdulrahman AlHarbi, (443102249)
Saud Nasser AlKatheeri, 	(443100710)
Saleh Bader AlGhaith, 		(443101007)
***********************************/
public class Node<T>
{
	private T data;
	public Node<T> next;
	
	public Node() 
	{
		data = null;
		next = null;
	}
	
	public Node(T val) 
	{
		data = val;
		next = null;
	}

	public T getData() 
	{
		return data;
	}

	public Node<T> getNext() 
	{
		return next;
	}

}
