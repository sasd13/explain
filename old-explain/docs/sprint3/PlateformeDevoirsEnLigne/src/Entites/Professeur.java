package Entites;


public class Professeur extends User {
		
	public Professeur(){
		Professeur.setAutorisation(Autorisation.P);
	}
	public Professeur(int id, String login, String auth_serial, String name, String firstName, String birthday, 
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
		StringBuilder s = new StringBuilder().append("[ ").append(super.toString()).append(" ]");
		return s.toString();
	}
}
