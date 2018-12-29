package BST_A2;

public class BST_Node {
	String data;
	  BST_Node left;
	  BST_Node right;
	  BST_Node root;
	  BST_Node parent;
	  int size;
	  BST_Node(String data){ this.data=data; }

	  // --- used for testing  ----------------------------------------------
	  //
	  // leave these 3 methods in, as is

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  // --- end used for testing -------------------------------------------

	  
	  // --- fill in these methods ------------------------------------------
	  //
	  // at the moment, they are stubs returning false 
	  // or some appropriate "fake" value
	  //
	  // you make them work properly
	  // add the meat of correct implementation logic to them

	  // you MAY change the signatures if you wish...
	  // make the take more or different parameters
	  // have them return different types
	  //
	  // you may use recursive or iterative implementations

	  

	  public boolean insert(BST_Node inserting) {
		  if(left == null && right == null) {
			  if(inserting.getData().compareTo(data) < 0 ) {
				  inserting.parent = this;
				  left = inserting;
				  return true;
			  } else {
				  inserting.parent = this;
				  right = inserting;
				  return true;
			  }
		  } else if (left == null) {
			  if(inserting.getData().compareTo(data) < 0) {
				  inserting.parent = this;
				  left = inserting;
				  return true;
			  } else {
				  return right.insert(inserting);
			  }
		  } else if(right == null) {
			  if (inserting.getData().compareTo(data) > 0) {
				  inserting.parent = this;
				  right = inserting;
				  return true;
			  } else {
				  return left.insert(inserting);
			  }
		  } else {
			  if(inserting.getData().compareTo(data) < 0) {
				  return left.insert(inserting);
			  } else {
				  return right.insert(inserting);
			  }
		  }
			
		}

		public boolean remove(String s) {
			if(this.getData().compareTo(s) != 0) {
				if (left == null && right == null) {
					return false;
				} else if (s.compareTo(data) > 0) {
					if(right == null) {
						return false;
					}
					return right.remove(s);
				} else {
					if(left == null) {
						return false;
					}
					return left.remove(s);
				}
			} else {
				if (right == null && left == null) {
					if (parent.left != null && parent.left.equals(this)) {
						parent.left = null;
						return true;
					} else {
						parent.right = null;
						return true;
					}
				} 
				if (right != null && left != null) {
					BST_Node max;
					max = new BST_Node(left.findMax());
					this.data = max.data;
					left.remove(data);
					return true;
				} 
				if (left != null) {
					if (parent.left != null && parent.left.equals(this)) {
						parent.left = left;
						left.parent = parent;
						return true;
					} else {
						parent.right = left;
						left.parent = parent;
						return true;
					}
				} else {
					if (parent.left != null && parent.left.equals(this)) {
						parent.left = right;
						right.parent = parent;
						return true;
					} else {
						parent.right = right;
						right.parent = parent;
						return true;
					}
				}

			}
			}

		public String findMin() {
			if(left != null) {
				return left.findMin();
			} else
				return this.getData();
		}

		public String findMax() {
			if(right != null) {
				return right.findMax();
			} else
				return this.getData();
		}

		
		public boolean contains(String s) {
			if(data == s) {
				return true;
			} else if (left == null && right == null) {
				return false;
			} else if (left == null) {
				return right.contains(s);
			} else if (right == null) {
				return left.contains(s);
			} else if(s.compareTo(data) > 0) {
				return right.contains(s);
			} else if(s.compareTo(data) < 0) {
				return left.contains(s);
			}
			return false;
		}

		public int getHeight() {
			if(left == null && right == null) {
				return 0;
			} else if (left == null) {
				return right.getHeight() + 1;
			} else if (right == null) {
				return left.getHeight() + 1;
			} else{
			 if (left.getHeight() >= right.getHeight()) {
				 return left.getHeight() + 1;
			 } else 
				 return right.getHeight() + 1;
			}
		}

	  // --- end fill in these methods --------------------------------------


	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
	  
	  public String toString(){
	    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
	            +",Right: "+((this.right!=null)?right.data:"null");
	  }
}
