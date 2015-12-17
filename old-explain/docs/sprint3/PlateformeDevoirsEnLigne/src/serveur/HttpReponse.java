import java.io.*;
import java.util.*;
import java.text.*;

public class HttpReponse {

    private static String getServerTime() {
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
	dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	return dateFormat.format(calendar.getTime());
    }

    public static void Ok(OutputStream os, String res) {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
	String envoi = "HTTP/1.1 200 OK\n" +
	    "Date: " + getServerTime() + "\n" +
	    "Content-Type: " + "application/x-www-form-urlencoded; charset=UTF-8" + "\n" +
	    "Content-Length: " + res.length() + "\n" +
	    "\n" +
	    res;
	try {
	    bw.write(envoi, 0, envoi.length());
	    bw.flush();
	    bw.close();
	} catch (IOException ioe) {
	    System.out.println(ioe.toString());
	} finally {
	    return;
	}
    }
}
