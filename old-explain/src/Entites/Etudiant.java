package Entites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Etudiant extends User 
{
	private int[] idsCours;
	private Date dateInscription;
	
	public Etudiant(){
		Etudiant.setAutorisation(Autorisation.E);
	}
	public Etudiant(int id, String login, String auth_serial, String name,
			String firstName, Date birthday, String email, int[] idsCours)
	{
		super(id, login, auth_serial, name, firstName, birthday, email);
		Etudiant.setAutorisation(Autorisation.E);
		setIdsCours(idsCours);
		this.dateInscription = dateInscription;
	}
	
	//constructor of copy
	public Etudiant(Etudiant etudiant){
		super(etudiant);
		setIdsCours(etudiant.getIdsCours());
		setDateInscription(etudiant.getDateInscription());
	}
	
	public void setIdsCours(int[] idsCours){
		this.idsCours = idsCours;
	}
	
	public int[] getIdsCours(){
		return idsCours;
	}
	
	public Date getDateInscription(){
		return dateInscription;
	}
	
	public void setDateInscription(Date jour){
		this.dateInscription = jour;
	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder().append("[ ").append(super.toString()).append(" ]");
		 
		if (idsCours != null)
			for (int i=0; i < this.idsCours.length; i++)
				s.append(idsCours[i]);
		return s.toString();
	}
}

