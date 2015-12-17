import java.util.*;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
//import org.postgresql.Driver;

public class BddAcc {
    
    private Integer nbReaders;
    private ResultSet data;
    private Connection con = null;

    private String url = "jdbc:postgresql://localhost:5432/FUN";
    private String user = "glafun";
    private String password = "glafun";
    
    public BddAcc() throws ClassNotFoundException {
	this.nbReaders = 0;
	this.data = null;
	Class.forName("org.postgresql.Driver");
	try {
	    this.con = DriverManager.getConnection(this.url, this.user, this.password);
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery("SELECT VERSION()");
	    if (rs.next())
		System.out.println(rs.getString(1));
	} catch (SQLException e) {
	    Logger lgr = Logger.getLogger(BddAcc.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
	}
    }
    
    public ResultSet readDataPrepared(PreparedStatement pst) {
	synchronized (this.nbReaders) {
	    nbReaders++;
	}
	try {
	    this.data = pst.executeQuery();
	} catch (Exception e) {
	
	}
	synchronized (this.nbReaders) {
	    nbReaders--;
	    notify();
	}	
	return data;
    }

    public synchronized void writeData() {
	while (true) {
	    if (nbReaders == 0) {
		//Ecrire bdd
		synchronized(this.nbReaders) {
		    return;
		}
	    } else {
		try {
		    wait();
		} catch (Exception e) {
		    System.out.println("Exception: " + e);
		}
		continue;
	    }
	}
    }

    /*
      Permet de récupérer l'id d'un utilisateur grâce a son login et son hash
      Retourne :
      - L'id de l'utilisateur s'il existe et que tout match
      - 0 sinon
     */
    public synchronized int checkLoginHash(String login, String hash) {
	PreparedStatement pst = null;
	ResultSet rs = null;
	String stm = "SELECT id_utilisateur FROM utilisateurs WHERE login = ? AND auth_serial = ?";
	try {
	    pst = con.prepareStatement(stm);
	    pst.setString(1, login);
	    pst.setString(2, hash);
	    rs = this.readDataPrepared(pst);
	    if (rs.next())
		return rs.getInt(1);
	    else
		return 0;
	} catch (SQLException e) {
	    Logger lgr = Logger.getLogger(BddAcc.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
	} finally {
	    try {
		if (pst != null)
		    pst.close();
		if (rs != null)
		    rs.close();
	    } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(BddAcc.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
	}
	return 0;
    }
}
