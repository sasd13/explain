package Entites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Professeur extends User {
		
	public Professeur(){
		Professeur.setAutorisation(Autorisation.P);
	}
	public Professeur(int id, String login, String auth_serial, String name, String firstName, Date birthday, 
			String email)
	{
		super(id, login, auth_serial, name, firstName, birthday, email);
		Professeur.setAutorisation(Autorisation.P);	// Autorisation est initialisée qu'une seule fois
	}
	
	//constructor of copy
	public Professeur(Professeur prof){
		super(prof);
		Professeur.setAutorisation(Autorisation.P);
	}
	
	@Override
	public String toString(){
		return "[ "+this.getId()+","+this.getName()+" "+this.getFirstName()+","
				+Professeur.getAutorisation()+","
				+new SimpleDateFormat("DD/MM/yyyy").format(this.getBirthday())
				+","+this.getEmail()+" ]";
	}
}
