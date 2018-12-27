package DiGraph_A5;

import java.util.HashSet;
import java.util.Hashtable;

public class DiGraph implements DiGraph_Interface {

	  // in here go all your data and methods for the graph
	private Hashtable <String, Long> nodes;
	private HashSet<Long> nodeIDs;
	private HashSet<Long> edgeIDs;
	
	

	  public DiGraph ( ) { // default constructor
	    // explicitly include this
	    // we need to have the default constructor
	    // if you then write others, this one will still be there
		  nodes = new Hashtable <String, Long>();
		  nodeIDs = new HashSet <Long>();
		  edgeIDs = new HashSet <Long>();
		  
	  }

	@Override
	public boolean addNode(long idNum, String label) {
		if(idNum < 0 || nodes.contains(label) || nodeIDs.contains(idNum) || label == null) {
			return false;
		} else {
			nodes.put(label, idNum);
			nodeIDs.add(idNum);
			return true;
		}
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if(idNum < 0 || edgeIDs.contains(idNum)) {
			return false;
		}
		if(!edgeIDs.contains(idNum) && idNum >= 0) {
			if(nodes.containsKey(sLabel) && nodes.containsKey(dLabel)) {
				//if()
			}
		}
		return false;
	}

	@Override
	public boolean delNode(String label) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long numNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}
	  
	  // rest of your code to implement the various operations
	}
