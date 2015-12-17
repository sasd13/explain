import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class main {
    

    public static void main(String args[]) {
	int port = -1;
	Socket s = null;
	ServerSocket ssock = null;
	InetAddress inetAddr;
	ListClients listC = new ListClients();
	ThreadClean tc = new ThreadClean(listC);
	BddAcc bdd;
	
	try {
	    bdd = new BddAcc();
	} catch (Exception e) {
	    System.out.println("Error :" + e);
	    return;
	}

	/* Need 1 arg to create server: the port number */	
	if (args.length != 1) {
	    System.out.println("Exemple Utilisation: java main numeroDePort");
	    return;
	}


	/* Recupération du port */
	port = Integer.parseInt(args[0]);
	

	/* create the server socket */
	try {
	    System.out.println(port);
	    ssock = new ServerSocket(port);
	} catch (Exception e) {
	    System.out.println("Error creating serversocket");
	    return;
	}

	/* cleaning thread */
	tc.start();
	
	/* Inf loop to accept connexions from clients */
	while (true) {
	    try {
		/* creating Thread to Communicate with client */
		s = ssock.accept();
		new ThreadComm(s, listC, bdd).start();
	    } catch (Exception ex) {
		System.out.println("Error : " + ex.toString());
	    }
	}
    }
}
