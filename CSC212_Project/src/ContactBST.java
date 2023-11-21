
public class ContactBST {
	BSTNode root, current;

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
		Boolean removed = new Boolean(false);
		BSTNode p;
		p = remove_aux(tkey, root, removed);
		current = root = p;
		return removed;
	}

	private BSTNode remove_aux(String key, BSTNode p, Boolean flag) {
		BSTNode q, child = null;
		if (p == null)
			return null;
		if (key.compareTo(p.key) > 0)
			p.left = remove_aux(key, p.left, flag); // go left
		else if (key.compareTo(p.key) < 0)
			p.right = remove_aux(key, p.right, flag); // go right
		else { // key is found
			flag = true;
			if (p.left != null && p.right != null) { // two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
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

	public void inOrderTraversal(BSTNode root2) {
		if (root2 != null) {
			// Traverse the left subtree
			inOrderTraversal(root2.left);

			// Visit the current node and display its data
			System.out.println(root2.data.toString() + " ");

			// Traverse the right subtree
			inOrderTraversal(root2.right);
		}
	}
}
