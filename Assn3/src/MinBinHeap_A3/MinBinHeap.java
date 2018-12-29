package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	  private EntryPair[] array; //load this array
	  private int size;
	  private static final int arraySize = 10000; //Everything in the array will initially 
	                                              //be null. This is ok! Just build out 
	                                              //from array[1]
	
	  public MinBinHeap() {
	    this.array = new EntryPair[arraySize];
	    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
	                                             //of child/parent computations...
	                                             //the book/animation page both do this.
	  }
	    
	  //Please do not remove or modify this method! Used to test your entire Heap.
	  @Override
	  public EntryPair[] getHeap() { 
	    return this.array;
	  }

	public void insert(EntryPair entry) {
		array[size + 1] = entry;  //input in next available spot in array
		size++; // increment size 
		int i = size; // variable for movement
		while(i > 1) {
			if (array[i/2].getPriority() > array[i].getPriority()){ // if bigger swap
			EntryPair temp = array[i/2]; 
			array[i/2] = array[i];
			array[i] = temp;
			}
			i--;
		}
	}

	public void delMin() {
		if(size == 0) {
			return;
		} else if(size == 1) {
			array[size] = null;
			size--;
		} else if(size > 1) {
			array[1] = array[size];
			array[size] = null;
			bubbleDown(1);
			size--;
		}
	}

	public EntryPair getMin() {
		if(array[1] == null) {
			return null;
		}
		return array[1];
	}

	public int size() {
		return size;
	}

	public void build(EntryPair[] entries) {
		size = entries.length;
		for(int j = 1; j <= size; j++) {
			array[j] = entries[j-1];
		}
		for(int i = size / 2; i > 0; i--) {
			bubbleDown(i);
		}
		
	}
	private void bubbleDown(int i) {
		EntryPair rchild, lchild;
		if(i * 2  > arraySize) {
			return;
		}
		
		rchild = array[i*2+1];
		lchild = array[i*2];
		
		if(rchild == null && lchild == null) {
			return;
		}else if(rchild == null && lchild.getPriority() < array[i].getPriority()) {
			EntryPair temp = array[i];
			array[i] = lchild;
			array[2*i] = temp;
		} else if(lchild == null && rchild.getPriority() < array[i].getPriority()) {
			EntryPair temp = array[i];
			array[i] = rchild;
			array[2*i+1] = temp;
		} else if(rchild != null && lchild != null && lchild.getPriority() > rchild.getPriority() && rchild.getPriority() < array[i].getPriority()) {
			EntryPair temp = array[i];
			array[i] = rchild;
			array[2*i+ 1] = temp;
			bubbleDown(2*i + 1);
		} else if(rchild != null && lchild != null && lchild.getPriority() < rchild.getPriority() && lchild.getPriority() < array[i].getPriority() ) {
			EntryPair temp = array[i];
			array[i] = lchild;
			array[2*i] = temp;
			bubbleDown(2*i);
		} else {
			return;
		}
	}
}
