import java.util.Stack;

public class ContactBST {
	BSTNode root, current;
	Boolean removed =false;


	/** Creates a new instance of BST */
	public ContactBST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public Contact retrieve() {
		return current.data;
	}

	public boolean findkey(String tkey) {
		BSTNode p = root, q = root;
		
		if (empty())
			return false;

		while (p != null) {
			q = p;
			if (tkey.compareTo(p.key) == 0) {
				current = p;
				return true;
			} else if (tkey.compareTo(p.key) > 0)
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return false;
	}
	

	public boolean insert(Contact val) {
		BSTNode p, q = current;

		if (findkey(val.getName())) {
			current = q;
			return false; // key already in the BST
		}

		p = new BSTNode(val);
		if (empty()) {
			root = current = p;
			return true;
		} else {
			if (val.compareTo(current.data) > 0)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}

	public boolean remove_key(String tkey) {
		BSTNode p;
		p = remove_aux(tkey, root);
		current = root = p;
		return removed;
	}

	private BSTNode remove_aux(String key, BSTNode p) {
		BSTNode q, child = null;
		if (p == null)
			return null;
		if (key.compareTo(p.key) > 0)
			p.left = remove_aux(key, p.left); // go left
		else if (key.compareTo(p.key) < 0)
			p.right = remove_aux(key, p.right); // go right
		else { // key is found
			removed = true;
			if (p.left != null && p.right != null) { // two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right);
			} else {
				if (p.right == null)
					child = p.left;
				else if (p.left == null)
					child = p.right;
				return child;
			}
		}
		return p;
	}

	private BSTNode find_min(BSTNode p) {
		if (p == null)
			return null;

		while (p.left != null)
			p = p.left;

		return p;
	}

	public boolean checkPN(BSTNode node, String condition) {	//Check if num is already exist
        if (node != null) {
            if (checkPN(node.left, condition)) 
                return true;
            if (node.data.getPhoneNumber().equals(condition)) {
                return true; 
                }
            if (checkPN(node.right, condition)) 
                return true; 
        }
        return false;
    }
	
	public Contact searchName(String tkey) {
		BSTNode p = root, q = root;
		
		if (empty())
			return null;

		while (p != null) {
			q = p;
			if (tkey.compareTo(p.key) == 0) {
				current = p;
				return current.data;
			} else if (tkey.compareTo(p.key) > 0)
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return null;
	}
	
	public boolean searchPhoneNumber(BSTNode node, String condition) {	
        if (node != null) {
            if (searchPhoneNumber(node.left, condition)) 
                return true;
            if (node.data.getPhoneNumber().equals(condition)) {
            	System.out.println(node.data.toString());
                return true; 
                }
            if (searchPhoneNumber(node.right, condition)) 
                return true; 
        }
        return false;
    }
	
	public boolean searchEmail(BSTNode root2, String Email) {
		if (root2 == null) 
			return false;
		
		Stack<BSTNode> stack = new Stack<>();
		stack.push(root2);

		while (!stack.isEmpty()) {
			BSTNode current = stack.pop();
			if (Email.equals(current.data.getEmail())) 
				System.out.println(current.data.toString());
			
			if (current.left != null) 
				stack.push(current.left);
			 
			if (current.right != null) 
				stack.push(current.right);
		}
		return false;
	}
	public boolean searchAddress(BSTNode root2, String Address) {
		if (root2 == null) 
			return false;
		
		Stack<BSTNode> stack = new Stack<>();
		stack.push(root2);

		while (!stack.isEmpty()) {
			BSTNode current = stack.pop();
			if (Address.equals(current.data.getAddress())) 
				System.out.println(current.data.toString());
			
			if (current.left != null) 
				stack.push(current.left);
			 
			if (current.right != null) 
				stack.push(current.right);
		}
		return false;
	}
	public boolean searchBirthday(BSTNode root2, String birthday) {
		if (root2 == null) 
			return false;
		
		Stack<BSTNode> stack = new Stack<>();
		stack.push(root2);

		while (!stack.isEmpty()) {
			BSTNode current = stack.pop();
			if (birthday.equals(current.data.getBirthday())) 
				System.out.println(current.data.toString());
			
			if (current.left != null) 
				stack.push(current.left);
			 
			if (current.right != null) 
				stack.push(current.right);
		}
		return false;
	}

}
