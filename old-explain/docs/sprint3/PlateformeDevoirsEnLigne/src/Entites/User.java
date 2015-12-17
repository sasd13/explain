package Entites;

//import java.util.String;
//import java.text.SimpleStringFormat;

public class User {
	private int id;
	private static String login;
	private String auth_serial;
	private static Autorisation autorisation;
	private String name;
	private String firstName;	
	private String birthday;
	private static String email;
		
	
	//constructor
	public User(){}
	
	/*
	public User(int id, String login, String auth_serial, String name, String firstName,String birthday){
		this.id = id;
		this.login = login;
		this.auth_serial = auth_serial;
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
	}*/
	
	public User(int id, String login, String auth_serial, String name, String firstName,String birthday, String email){
		setId(id);
		setLogin(login);
		setAuth_serial(auth_serial);
		setName(name);		
		setFirstName(firstName);
		setBirthday(birthday);
		setEmail(email);
		User.setAutorisation(null);
	}
	//constructor of copy
	public User(User user){
		setId(user.getId());
		setLogin(User.getLogin());
		setAuth_serial(user.getAuth_serial());
		setName(user.getName());		
		setFirstName(user.getFirstName());
		setBirthday(user.getBirthday());
		setEmail(user.getEmail());
		setAutorisation(User.getAutorisation());
	}
	
	
	
	public String toString(){
		return "[ "+this.getId()+","+this.getName()+" "+this.getFirstName()
				+","+User.getAutorisation()+","+
				this.getBirthday()
				+","+this.getEmail()+" ]";
	}

	//set-get
	
	public int getId(){
		return id;
	}
	
	public void setId(int i){
		if (i <= -1)
			throw new InvalidUserException("invalid id ["+ id+"]", 1);
		this.id = i;
	}
	
	public static String getLogin(){
		return login;
	}
	
	public static void setLogin(String login){
		User.login= login;
	} 
	
	public void setAuth_serial(String auth_serial){
		this.auth_serial = auth_serial;
	}
	
	public String getAuth_serial(){
		return auth_serial;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String nom){
		if (nom == null || nom.trim().length() == 0)
			throw new InvalidUserException("invalid name ["+ nom+ "]");
		name = nom;
	}
	
	public String getFirstName(){
		return firstName;
	}
	private void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().length() == 0)
			throw new InvalidUserException("invalid name ["+ firstName+ "]");
		this.firstName = firstName;
		
	}
	public String getBirthday(){
		return birthday;
	}
	public void setBirthday(String birthday){
		if (birthday == null )
			throw new InvalidUserException("invalid birthday ["+birthday+" ]");
		this.birthday = birthday;
	}
	public String getEmail(){
		return email;
	}
	public  void setEmail(String email){
		if (email == null || email.trim().length() == 0 
				|| email.trim().length() > 255)
			throw new InvalidUserException("invalid email ["+ email+" ]");
		this.email = email;
	}

	public static Autorisation getAutorisation() {
		return autorisation;
	}

	public static void setAutorisation(Autorisation autorisation) {
		User.autorisation = autorisation;
	}
	
}
