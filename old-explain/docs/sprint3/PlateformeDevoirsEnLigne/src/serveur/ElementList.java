public class ElementList {
    

    //private String pseudo;
    private String hash;
    private long time;
    private int id;
    
    public ElementList(String h, long t) {
	//this.pseudo = p;
	this.hash = h;
	this.time = t;
    }

    public ElementList(String h, long t, int id) {
	this.id = id;
	this.hash = h;
	this.time = t;
    }
    
    //setters getters
    
    public void setTime(long l) {
	this.time = l;
    }
    
    public long getTime() {
	return this.time;
    }
    
    /*public String getPseudo() {
	return this.pseudo;
	}*/
    
    public String getHash() {
	return this.hash;
    }
    
    public boolean isExpire(long t, long expire) {
	if (t - this.time > expire) {
	    return true;
	}
	return false;
    }

    public boolean equalsNoTime(ElementList e) {
	if (e == null) return false;
	return (this.hash == e.getHash());
    }
    
    public String toString() {
	if (this.hash != null)
	    return "\nHash: " + this.hash + "\n"+
		"-------------------------------------------------------\n";
	else 
	    return "";
    }
}