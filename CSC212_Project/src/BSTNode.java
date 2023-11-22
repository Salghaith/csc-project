
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