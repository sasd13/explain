package Entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Professeur extends User {
	//private ArrayList<Cours> listeCours= new ArrayList<Cours>();
	//private ArrayList<FeuilleExo> listeFeuilleExo= new ArrayList<FeuilleExo>();
	
	public Professeur(){
		this.setAutorisation(Autorisation.P);
	}
	public Professeur(int id, String name, String firstName, Date birthday, String email){
		super(id, name, firstName, birthday, email);
		this.getAutorisation();
		}
	
	
	public static Autorisation getAutorisation(){
		return Autorisation.P;
	}
	
	@Override
	public String toString(){
		return "[ "+this.getId()+","+this.getName()+" "+this.getFirstName()+","+this.getAutorisation()+","+
				new SimpleDateFormat("DD/MM/yyyy").format(this.getBirthday())+","+
				this.getEmail()+" ]";
	}
}
