import java.util.*;

public class ListClients {

    private ArrayList< LinkedList<ElementList> > list =
	new ArrayList< LinkedList<ElementList> >();
    private static final long expire = 10000;
    private static final int len = 16;

    // basic constructor
    public ListClients() {
	for (int i=0; i<this.len; i++) {
	    this.list.add(new LinkedList<ElementList>());
	}
    }

    /*----------------------------Methods-----------------------------*/
    
    /* method to add a client to the list or update timer if already in
     * return 0 if success, -1 if not.
     */

    public synchronized void addClient(String hash) {
	// verify if the client is already in the list.
	// if it is the case, we just change the timer.
	ElementList tmp = 
	    new ElementList(hash, System.currentTimeMillis());
	for (ElementList e : (this.list.get(Integer.parseInt(""+hash.charAt(0), 
							     16)))) {
	    if (tmp.equalsNoTime(e)) {
		e.setTime(System.currentTimeMillis());
		return;
	    }
	}
	//here only if client not in hashtable.
	//we add it.
	this.list.get(Integer.parseInt(""+hash.charAt(0), 16)).add(tmp);
	return;
    }

    public synchronized void addClient(ElementList el) {
	String hash = el.getHash();
	for (ElementList e : (this.list.get(Integer.parseInt(""+hash.charAt(0), 
							     16)))) {
	    if (el.equalsNoTime(e)) {
		e.setTime(System.currentTimeMillis());
		return;
	    }
	}
	//here only if client not in hashtable.
	//we add it.
	this.list.get(Integer.parseInt(""+hash.charAt(0),16)).add(el);
	return;
    }

    public synchronized boolean containsUpdate(ElementList tmp, boolean b) {
	String hash = tmp.getHash();
	for (ElementList e : (this.list.get(Integer.parseInt(""+hash.charAt(0), 
							     16)))) {
	    if (tmp.equalsNoTime(e)) {
		if (b)
		    e.setTime(System.currentTimeMillis());
		return true;
	    }
	}
	return false;
    }

    //method to clean the list ( timer < 0 )
    public synchronized void clean() {
	Set<ElementList> tmpC = new HashSet<ElementList>();
	long l;
	for (int i=0; i<this.list.size(); i++) {	    
	    tmpC.clear();
	    l = System.currentTimeMillis();
	    for (ElementList e : list.get(i)) {
		if (e.isExpire(l, this.expire)) {
		    //on ajoute a la collec et on retire tout a la fin...
		    tmpC.add(e);
		}
	    }
	    list.get(i).removeAll(tmpC);
	}
    }

    public synchronized boolean isEmpty() {
	for (int i=0; i<this.list.size(); i++) {
	    if (!this.list.get(i).isEmpty())
		return false;
	}
	return true;
    }
    
    public synchronized String toString() {
	String w = "";
	for (int i=0; i<this.len; i++) {
	    for (ElementList e : this.list.get(i)) {
		w += e.toString();
	    }
	}
	return w;
    }
}

