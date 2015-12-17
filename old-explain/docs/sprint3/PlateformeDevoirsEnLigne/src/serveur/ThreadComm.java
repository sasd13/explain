import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import com.sun.net.httpserver.HttpServer;
import java.security.*;

import java.util.logging.Logger;
import java.util.logging.Level;

public class ThreadComm extends Thread {

    private ListClients listC = null;
    Socket s = null;
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    private static BddAcc bdd = null;
    private static final int maxReqLen = 10000;
    private RequestReader rr;
    private PrintWriter pr;

    public ThreadComm(Socket s, ListClients l, BddAcc bdd) {

	try {
	    this.s = s;
	    this.listC = l;
	    this.in = new BufferedInputStream(s.getInputStream());
	    this.out = new BufferedOutputStream(s.getOutputStream());
	    this.rr = new RequestReader(this.in);
	    this.bdd= new BddAcc();
	    this.pr = new PrintWriter(new OutputStreamWriter(this.out));
	    System.out.println("New Client connected --> " +
			       s.getInetAddress().getHostAddress());
	} catch (Exception e) {
	    error(e.toString());
	}
    }

    public void error(String s) {
	//TODO: ecrire
	System.out.println("MyError: " + s);
	//write a logfile
    }

    public void writeHttpRep(String s) {
	String rep = "<HTML><HEAD><TITLE> Error </TITLE></HEAD>" + 
	    "<body> <p>" + s + "</p>" + 
	    "</body> </HTML>";
	try {
	    this.out.write(rep.getBytes());
	    this.out.flush();
	} catch(Exception e) {
	    error(e.toString());
	}
    }
    
    public String shaConvert(String pass, String algo) {
	try {
	    MessageDigest md = MessageDigest.getInstance(algo);
	    byte[] passB = pass.getBytes();
	    md.update(passB);
	    byte [] hash = md.digest();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
		sb.append(Integer.toString((hash[i] & 0xff) + 
					   0x100, 16).substring(1));
	    }
	    return sb.toString();
	} catch(Exception e) {
	    error(e.toString());
	}
	return null;
    }
    
    public void run() {

	String pseudo = "";
	String hash = "";
	ElementList e = null;
	int id = 0;
	long t;
	String[][] ressource;

	try {
	    /* Reading request */
	    this.rr.retreiveInfos();
	    if (this.rr.getRequete() != null) {
		/* Requete bien forme parse */
		if (this.rr.getRequete().equals("signIn")) {
		    /* AUTHENTIFICATION CLIENT */
		    pseudo = (this.rr.getParams())[0][1];
		    hash = shaConvert(pseudo+(this.rr.getParams())[1][1], 
		    		      "SHA-512");
		    id = this.bdd.checkLoginHash(pseudo, hash);
		    if (id == 0) {
			/* error : pas dans bdd*/
			//TODO: ENVOYER CODE RETOUR ERREUR AU CLIENT
			HttpReponse.Ok(this.out, "error=0");
			this.s.close();
		    } else {
			/* dans bdd */
			t = System.currentTimeMillis();
			e = new ElementList(hash, t, id);
			this.listC.addClient(e);
			HttpReponse.Ok(this.out, "auth=" + hash + "&id=" + id);
			this.s.close();
		    }
		} else if (this.rr.getRequete().equals("signUp")) {
		    /* INSCRIPTION MOOC */
		} else {
		    System.out.println("bad request");
		    this.s.close();
		    return;
		}		    
	    } else { 
		writeHttpRep("Error: bad request");
		this.s.close();	   
		return;
	    }
	} catch (Exception ex) {
	    //error(ex.toString());
                Logger lgr = Logger.getLogger(ThreadComm.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
		ex.printStackTrace();
	}
    }
}
