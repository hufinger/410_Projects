package SkipList;

public class SkipList_Node {
	String data;
	  int level;
	  SkipList_Node[] forward;
	  
	  SkipList_Node(String s, int level) {
	    this.data = s;
	    this.level = level;
	    this.forward = new SkipList_Node[level + 1];
	  }
	  

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

	  public SkipList_Node getForward(int level) {
		  return forward[level];
	  }
	  
	  public boolean setForward(int level, SkipList_Node forward) {
		  if (level > 100 || level < 0 || forward == null) { return false; }
		  return true; 
	  }
	  String getData() { return data; }
	  

	  // --- end fill in these methods --------------------------------------


	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
}
