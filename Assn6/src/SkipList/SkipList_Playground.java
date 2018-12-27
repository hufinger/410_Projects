package SkipList;

public class SkipList_Playground {
	/*
	 * you will test your own skiplist implementation in here
	 *
	 * we will replace this with our own when grading, and will
	 * do what you should do in here... create SkipList objects,
	 * put data into them, take data out, look for values stored
	 * in it, checking size and level, and looking at if they
	 * are all linked up correctly for a SkipList
	 * 
	*/
	  
	  public static void main(String[]args){

	  SkipList x = new SkipList();
	  x.insert("h");
	  x.insert("g");
	  x.remove("g");
	  x.insert("d");
	  x.insert("s");
	  x.insert("e");
	  x.insert("t");
	  x.insert("r");
	  x.insert("b");
	  
	  //System.out.println(x.getHead().getData());
	  //System.out.println(x.findMax());
	  printSkipList(x);
	  }

	  public static void printSkipList(SkipList sl) {
	    SkipList_Node x = sl.getHead();
	    for (int i = 0; i < sl.size(); i++) {
	      System.out.print(x.forward[1].getData() + " ");
	      x = x.forward[1];
	    }
	    System.out.println();
	  }
}
