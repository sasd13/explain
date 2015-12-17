package Entites;

import java.util.Date;
import java.text.SimpleDateFormat;

public class User {
	private int id;
	private static String login;
	private String auth_serial;
	private static Autorisation autorisation;
	private String name;
	private String firstName;	
	private Date birthday;
	private static String email;
		
	
	//constructor
	public User(){}//{setAutorisation(null);}
	
	public User(int id, String name, String firstName){
		setId(id);
		setName(name);
		
	}
	
	public User(int id, String name, String firstName, Date birthday, String email){
		setId(id);
		setName(name);		
		setFirstName(firstName);
		setBirthday(birthday);
		setEmail(email);
	}
	
	public String toString(){
		return "[ "+this.getId()+","+this.getName()+" "+this.getFirstName()+","+this.getAutorisation()+","+
				new SimpleDateFormat("DD/MM/yyyy").format(this.getBirthday())+","+
				this.getEmail()+" ]";
	}
/*
	public String toString(){
		return "[ "+id+","+name+" "+firstName+","+this.getAutorisation()+","+
				new SimpleDateFormat("DD/MM/yyyy").format(birthday)+","+
				email+" ]";
	}
*/	
	//set-get
	// Autorisation getAutorisation(){}	
	
	public int getId(){
		return id;
	}
	
	public void setId(int i){
		if (i <= -1)
			throw new InvalidUserException("invalid id ["+ id+"]", 1);
		this.id = i;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String nom){
		if (nom == null || nom.trim().length() == 0)
			throw new InvalidUserException("invalid name ["+ nom+ "]", 2);
		name = nom;
	}
	
	public String getFirstName(){
		return firstName;
	}
	private void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().length() == 0)
			throw new InvalidUserException("invalid name ["+ firstName+ "]", 2);
		this.firstName = firstName;
		
	}
	public Date getBirthday(){
		return birthday;
	}
	public void setBirthday(Date birthday){
		if (birthday == null )
			throw new InvalidUserException("invalid birthday ["+birthday+" ]", 4);
		this.birthday = birthday;
	}
	public String getEmail(){
		return email;
	}
	public  void setEmail(String email){
		if (email == null || email.trim().length() == 0 || email.trim().length() > 255)
			throw new InvalidUserException("invalid email ["+ email+" ]", 5);
		this.email = email;
	}

	public static Autorisation getAutorisation() {
		return autorisation;
	}

	public static void setAutorisation(Autorisation autorisation) {
		User.autorisation = autorisation;
	}
	
}
