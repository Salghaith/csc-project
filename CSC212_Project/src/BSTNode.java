/****************************
 * CLASS: BSTNode.java 
 * CSC212 Data structures - Project phase II Fall 2023 
 * EDIT DATE:
 * 11/15/2023 
 * TEAM: 
 * HERMANOS 
 * AUTHORS: 
 * Khaled Abdulrahman AlHarbi, (443102249)
 * Saud Nasser AlKatheeri, (443100710) 
 * Saleh Bader AlGhaith, (443101007)
 ***********************************/
public class BSTNode {
	public String key;
	public Contact data;
	public BSTNode left, right;

	public BSTNode(Contact val) {
		key = val.getName();
		data = val;
		left = right = null;
	}

	public BSTNode(Contact val, BSTNode le, BSTNode ri) {
		key = val.getName();
		data = val;
		left = le;
		right = ri;
	}

}