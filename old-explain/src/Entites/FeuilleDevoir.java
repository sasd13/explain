package Entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeuilleDevoir {
	private int id;
	private String nomFeuille;
	private int idCours;
	private int idProf;
	private int maxRendu;
	private Date dateRendu;
	private String emplacement;
	
		//constructeur
		public FeuilleDevoir(int id, String name, int idProf, int idCours,
				int maxRendu, Date dateForSoumettre,  String emplacement )
		{
			setId(id);
			setNomFeuille(nomFeuille);
			setIdProf(idProf);
			setIdCours( idCours);
			setMaxRendu(maxRendu);
			this.dateRendu = dateForSoumettre;
			setEmplacement(emplacement);
		}
	
	//constructeur par copie
	public FeuilleDevoir(FeuilleDevoir copyDevoir){
		if (copyDevoir == null)
			throw new InvalidUserException("invalid devoir",10);
		setId(copyDevoir.getId());
		setNomFeuille(copyDevoir.getNomFeuille());
		setIdProf(copyDevoir.getIdProf());
		setIdCours(copyDevoir.getIdCours());
		setMaxRendu(copyDevoir.getMaxRendu());
		setEmplacement(copyDevoir.getEmplacement());
	}
public void setEmplacement(String emplacement) {
		this.emplacement =emplacement;
	}

public String getEmplacement() 
{
		return emplacement;
}

	
	public String toString()
	{		
		return "["+ this.id + this.nomFeuille + this.idProf + this.idCours
			+ this.maxRendu+ "]";
	}
	
	//get-set
	
	public void setId(int idFeuille) {
		this.id = idFeuille;
	}

	public int getId() {
		return this.id;
	}
	
	public void setNomFeuille(String titre) {
		this.nomFeuille = titre;
	}

	public String getNomFeuille() {
		return this.nomFeuille;
	}
	
	public void setIdProf(int idProf) {
			this.idProf = idProf;
		}

	public int getIdProf() {
			return idProf;
		}

	public void setIdCours(int idCours) 
	{
			this.idCours = idCours;
	}

	public int getIdCours() {
			return idCours;
		}
	/*
	public void setEtatCorrection(EtatCorrection etatCorrection) {
		if (etatCorrection != EtatCorrection.Y || etatCorrection != EtatCorrection.N 
				|| etatCorrection != EtatCorrection.EC) throw new InvalidDevoirException(
				"seuls les etats valides: [Y,N,EC]");
		etatCorrection = etatCorrection;
	}*/

	public void setDateRendu(Date dateForSoumettre)
	{
		this.dateRendu = dateForSoumettre;
	}

	public Date getDateRendu() {
		return this.dateRendu;
	}
	
	public void setMaxRendu(int maxRendu){
		this.maxRendu = maxRendu;
	}
	
	public int getMaxRendu(){
		return this.maxRendu;
	}

}
