package BST_A2;

public class BST implements BST_Interface {
	  public BST_Node root;
	  int size;
	  
	  public BST(){ size=0; root=null; }
	  
	public BST_Node getRoot(){ return root; }

	public boolean insert(String s) {
		BST_Node inserted = new BST_Node(s);
		if(root == null) {
			root = inserted;
			size++;
			return true;
		} else 
			size++;
		return root.insert(inserted);
	}
	

	public boolean remove(String s) {
		if (root == null) {
			return false;
		} if (root.getData().compareTo(s) == 0) {
			BST_Node maxHolder;
			if (root.left == null && root.right == null) {
				root = null;
				size = 0;
				return true;
			} else if (root.left != null && root.right != null) {
				maxHolder = new BST_Node(root.left.findMax());
				root.data = maxHolder.getData();
				root.left.remove(maxHolder.getData());
				size--;
				return true;
			}

			else {
				if (root.left != null) {
					root = root.left;
					size--;
					return true;
				}

				else {
					root = root.right;
					size--;
					return true;
				}
			}
		}

		else {

			if (root.remove(s)) {
				size--;
				return true;
			}

			else {
				return false;
			}
		}
	}

	public String findMin() {
		if (root == null) {
			return null;
		} 
		return root.findMin();
	}

	public String findMax() {
		if (root == null) {
			return null;
		}
		return root.findMax();
	}

	public boolean empty() {
		return size == 0;
	}

	public boolean contains(String s) {
		if(root == null) {
			return false;
		}
		return root.contains(s);
	}
	

	public int size() {
		return size;
	}

	public int height() {
		if(size == 0) {
			return -1;
		} 
		return root.getHeight();
	}


}
