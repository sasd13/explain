package Entites;

import java.util.ArrayList;

public class Cours {
	private int idCours;
	private String titre;
	private int idProf;
		
	public Cours(int id, String titre, int idProf){
		this.idCours = id;
		this.titre =titre;
		this.idProf = idProf;
	}
	//constructeur par copie
	public Cours(Cours otherCours){
		if (otherCours == null)
			throw new InvalidUserException("invalid cours",7);
		setIdCours(getIdCours());
		setTitre(getTitre());
		setIdProf(getIdProf());
	}
	
	//get-set
	
	private void setIdProf(int idProf) {
		// TODO Auto-generated method stub
		if (idProf < 0)
			throw new InvalidUserException("invalide id cours ["+idProf+" ]",10);
		this.idProf = idProf;
	}

	private int getIdProf() {
		// TODO Auto-generated method stub
		return idProf;
	}

	private void setTitre(String titre) {
		// TODO Auto-generated method stub
		if (titre == null || titre.trim().length() == 0)
			throw new InvalidUserException("invalid cours titre["+titre+" ]",9);
		this.titre = titre;
	}

	private String getTitre() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setIdCours(int idCours) {
		// TODO Auto-generated method stub
		if (idCours < 0)
			throw new InvalidUserException("invalide id cours ["+idCours+" ]",8);
		this.idCours = idCours;
	}

	private int getIdCours() {
		// TODO Auto-generated method stub
		return idCours;
	}
	
	
}
