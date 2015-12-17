import java.util.*;
import java.io.*;

public class RequestReader {
    String requete;
    BufferedReader bufRead;
    int lengthRequest = -1;
    String[][] param = null;

    public RequestReader(InputStream is) {
	this.bufRead = new BufferedReader(new InputStreamReader(is));
	this.requete = null;
    }

    public void retreiveInfos() {
	String tmp;
	String[] tmpSplit;
	String[][] ret;
	try {
	    while(this.bufRead.ready()) {
		tmp = this.bufRead.readLine();
		System.out.println(tmp);
		if (tmp.equals("")) 
		    break;
		tmpSplit = tmp.split(": ", 2);
		if (tmpSplit[0].equals("Content-Length"))
		    this.lengthRequest = Integer.parseInt(tmpSplit[1]);
	    }
	
	    if (lengthRequest == -1) {
	        this.param = new String[1][2];
	        this.param[0][0] = "Error";
	        this.param[0][1] = "404";
		return;
	    } else {
		char[] cbuf = new char[this.lengthRequest];
		this.bufRead.read(cbuf, 0, this.lengthRequest);
		tmp = new String(cbuf);
		System.out.println(tmp);
		tmpSplit = tmp.split("&");
		this.param = new String[tmpSplit.length+1][2];
		for(int i = 0; i < tmpSplit.length+1; i++) {
		    if (i == 0) {
			if ((tmpSplit[i].split("="))[0].equals("request"))
			    this.requete = (tmpSplit[i].split("="))[1];
			else {
			    this.param = new String[1][2];
			    this.param[0][0] = "Error";
			    this.param[0][1] = "404";
			    return;
			}

		    } else {
			this.param[i-1][0] = new String((tmpSplit[i].split("="))[0]);
			this.param[i-1][1] = new String((tmpSplit[i].split("="))[1]);
			System.out.println(i-1 + " " + this.param[i-1][0] + ": " +this.param[i-1][1]);
		    }
		}
		return;
	    }
	} catch (IOException ioe) {
	    System.out.println(ioe.toString());
	} finally {
	    //xthis.param = null;
	    return;
	}
    }

    public String getRequete() {
	return this.requete;
    }

    public String[][] getParams() {
	return this.param;
    }
}
