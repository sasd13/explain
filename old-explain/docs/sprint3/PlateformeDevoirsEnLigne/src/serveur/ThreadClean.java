

/* thread to clean the list of connected clients */
public class ThreadClean extends Thread {

    private ListClients listC;

    public ThreadClean(ListClients lc) {
	this.listC = lc;
    }

    public void run() {
	while (true) {
	    if (this.listC != null)
		System.out.println("Cleaning...");
		this.listC.clean();
		System.out.println("end cleaning...");
	    try {
		sleep(600000);
	    } catch (Exception e) {
		System.out.println("Exception : " + e);
	    }
	}
    }
}