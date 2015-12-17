package Entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Etudiant extends User {
	//private ArrayList<Cours> listeCours= new ArrayList<Cours>();
	//private ArrayList<FeuilleExo> listeFeuilleExo= new ArrayList<FeuilleExo>();
	
	public Etudiant(){
		this.setAutorisation(Autorisation.E);
	}
	public Etudiant(int id, String name, String firstName, Date birthday, String email){
		super(id, name, firstName, birthday, email);
		this.getAutorisation();
		}
	
	
	public static Autorisation getAutorisation(){
		return Autorisation.E;
	}
	
	@Override
	public String toString(){
		return "[ "+this.getId()+","+this.getName()+" "+this.getFirstName()+","+this.getAutorisation()+","+
				new SimpleDateFormat("DD/MM/yyyy").format(this.getBirthday())+","+
				this.getEmail()+" ]";
	}
}

