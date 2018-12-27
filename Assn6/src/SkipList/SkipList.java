package SkipList;
public class SkipList implements SkipList_Interface {
	  SkipList_Node head;
	  SkipList_Node tail;
	  int level;
	  int size;
	  static final int levelSize = 100;
	  double probability = 0.5;
	  
	  SkipList() {
	    head = new SkipList_Node("", levelSize);
	    tail = new SkipList_Node("", levelSize);

	    for (int i = 1; i <= levelSize; i++) {
	      head.setForward(i, tail);
	    }

	    level = 0;
	    size = 0;
	  }
	  
	  @Override
	  //used for testing, please leave as is
	  public SkipList_Node getHead() {
	    if (size == 0)
	    		return null;
	    
	    return head;
	  }

	  //use this when creaing a new node, please leave as is
	  public int randomLevel() {
	    int level = 1;

	    while (Math.random() < probability)
	      level++;

	    return level;
	  }

	@Override
	public boolean insert(String s) {
		if (contains(s)) {
			return false;
		} else  {
			
			SkipList_Node current = head;  
	         SkipList_Node[] update = new SkipList_Node[levelSize + 1];
	  
	        for (int i = level; i >= 0; i--) {
	        		while (current.forward[i] != null && current.forward[i].data.compareTo(s) < 0) {
	        			current = current.forward[i];
	        		}
	        		update[i] = current; 
	        }
	        current = current.forward[0];
	  
	  
	         if (current == null || !current.data.equals(s)) {        
	             int lvl = randomLevel();
	       
	             if (lvl > level) {
	 	        for (int i = level + 1; i <= lvl; i++) {
	 	            update[i] = head;
	 	        }
	 	        level = lvl;
	 	    }
	 
	             SkipList_Node inserting = new SkipList_Node(s, lvl);
		    for (int i = 0; i <= lvl; i++) {
	 	        inserting.forward[i] = update[i].forward[i];
	 	        update[i].forward[i] = inserting; 	    }

	         }
	      size++;
	      return true;
		}
	}

	@Override
	public boolean remove(String s) {
		if(contains(s) == true) {
			SkipList_Node current = head;
			SkipList_Node[] update = new SkipList_Node[levelSize+1];
			for(int i = level; i >= 0; i--) {
				while(current.forward[i] != null && current.forward[i].data.compareTo(s) < 0) current = current.forward[i];
					
				update[i] = current;
			}
			current = current.forward[0];
			if(current != null && current.data == s) {
				for(int i = 0; i <= level; i++) {
					if(update[i].forward[i] != current) break;
					update[i].forward[i] = current.forward[i];
				}
				while(level > 0 && head.forward[level] == null) {
					level--;
				}
			}
			size--;
			return true;
		}
		return false;
	}

	@Override
	public String findMin() {
		return head.forward[0].data;
	}

	@Override
	public String findMax() {
		if (empty()) return null;
		SkipList_Node current = getHead();
		int i = size;
		if (size == 1) {
			return current.forward[1].data;
		}
		while (i > 0) {
			current = current.getForward(1);
			i--;
		}
		return current.data;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public boolean contains(String s) {
		SkipList_Node current = getHead();
		for (int i = 0; i < size; i++) {
			if(current.data != s && current.forward[1] != null) {
				current = current.forward[1];
			}
		}
		if(current != null) {
			if(current.data == s) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int level() {
		return level;
	}


}
