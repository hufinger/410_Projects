package MinBinHeap_A3;

public class MinBinHeap_Playground {
	 public static void main(String[] args){   
		    //Add more tests as methods and call them here!!
		 //TestInsert();
		    TestBuild();
		  }
	 
	 	public static void TestInsert() {
	 		MinBinHeap mbh = new MinBinHeap();
	 		//EntryPair[] collection_small = new EntryPair[2];
	 		//collection_small[0] = new EntryPair("g", 3);
	 		//collection_small[1] = new EntryPair("h", 8);
	 		//mbh.build(collection_small);
	 		mbh.insert(new EntryPair("a", 4));
	 		mbh.insert(new EntryPair("b", 1));
	 		mbh.insert(new EntryPair("c", 2)); 
		   	mbh.delMin();
	 		//mbh.insert(new EntryPair("d", 0));
	 		//mbh.insert(new EntryPair("e", 3));
	 		//mbh.insert(new EntryPair("f", 7));
		   	//mbh.delMin(); 
		    //mbh.insert(new EntryPair("g", 0)); 
	 		printHeap(mbh.getHeap(), mbh.size());
		    System.out.println(mbh.size());
		    System.out.println(mbh.getMin().getValue());
	 	}
	 
		  public static void TestBuild(){ 
		    // constructs a new minbinheap, constructs an array of EntryPair, 
		    // passes it into build function. Then print collection and heap.
		    MinBinHeap mbh= new MinBinHeap();
		    EntryPair[] collection= new EntryPair[5];
		    collection[0]=new EntryPair("i",5);
		    collection[1]=new EntryPair("b",4);
		    collection[2]=new EntryPair("c",3);
		    collection[3]=new EntryPair("d",2);
		    collection[4]=new EntryPair("e",1);
		    //collection[5]=new EntryPair("f",5);
		    //collection[6]=new EntryPair("g",6);
		    //collection[7]=new EntryPair("h",17);
		    mbh.build(collection);
		    printHeapCollection(collection);
		    printHeap(mbh.getHeap(), mbh.size());
		  }
		  
		  public static void printHeapCollection(EntryPair[] e) { 
		    //this will print the entirety of an array of entry pairs you will pass 
		    //to your build function.
		    System.out.println("Printing Collection to pass in to build function:");
		    for(int i=0;i < e.length;i++){
		      System.out.print("("+e[i].value+","+e[i].priority+")\t");
		    }
		    System.out.print("\n");
		  }
		  
		  public static void printHeap(EntryPair[] e,int len) { 
		    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
		    System.out.println("Printing Heap");
		    for(int i=1;i < len+1;i++){
		      System.out.print("("+e[i].value+","+e[i].priority+")\t");
		    }
		    System.out.print("\n");
		  }
}
