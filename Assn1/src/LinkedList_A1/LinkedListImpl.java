package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	  Node sentinel; //this will be the entry point to your linked list (the head)
	  int size = 0;
	  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
	    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
	    
	  }
	 
	  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
	    return sentinel;
	  }

	public boolean insert(double elt, int index) {
		if (index < 0 || index > size) {
			return false;
		} else if (index == 0 && size == 0) {
			Node created = new Node(elt);
			created.next = sentinel;
			created.prev = sentinel;
			sentinel.next = created;
			sentinel.prev = created;
			size++;
			return true;
		} 
		Node current = sentinel;
		for (int i = -1; i < index - 1; i++) {
			current = current.next;
		}
		Node created = new Node(elt);
		Node follower = current.next;
		current.next = created;
		created.prev = current;
		created.next = follower;
		follower.prev = created;
		size++;
		return true;
	}

	public boolean remove(int index) {
		if (index < 0 || index > size) {
			return false;
		}
		Node current = sentinel;
		for (int i = -1; i < index; i++) {
			current = current.next;
		}
		Node prev = current.prev;
		Node next = current.next;
		prev.next = next;
		next.prev = prev;
		size--;
		return true;
	}

	public double get(int index) {
		if (index < 0 || index > size) {
			return Double.NaN;
		}
		if (size == 0 && index == 0) {
			return Double.NaN;
		}
		Node current = sentinel;
		for (int i = -1; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void clear() {
		sentinel.next = null;
		sentinel.prev = null;
		size = 0;
		
	}

}
