package Entites;

import java.util.Date;

public class FeuilleSoumise {
	private int id;
	private int idEtudiant;
	private int nbrSoumises;
	private Date dateSoumise;
//	private static String emplacement;
	private EtatCorrection etatCorrection;
	private int version;

	
	public FeuilleSoumise(int id, int idEtudiant, int nbrSoumises,
			Date dateSoumise, String emplacement, 
			EtatCorrection etatCorr, int version)
	{
		this.id = id;
		this.idEtudiant = idEtudiant;
		this.nbrSoumises = nbrSoumises;
		this.dateSoumise = dateSoumise;
	//	FeuilleSoumise.emplacement =emplacement;
		this.etatCorrection = etatCorr;
		this.version = version;
	}
	
	
	public FeuilleSoumise(FeuilleSoumise copy)
	{
		setId(copy.getId());
		setIdEtudiant(copy.getIdEtudiant());
		setNbrSoumises(copy.getNbrSoumises());
		setDateSoumise(copy.getDateSoumise());
		//setEmplacement(copy.getEmplacement());
		setEtatCorrection(copy.getEtatCorrection());
		setVersion(copy.getVersion());
	}
	

	public String toString()
	{
		StringBuilder s = new StringBuilder().append("[").append(this.id)
				.append(this.idEtudiant).append(this.nbrSoumises)
				.append(this.dateSoumise);//.append(emplacement).append("]");
		
		return s.toString();
	}
	
	//setter - getter
	
	private void setEtatCorrection(EtatCorrection etat)
	{
		this.etatCorrection = etat;
	}


	private EtatCorrection getEtatCorrection() 
	{
		if (etatCorrection != EtatCorrection.Y || etatCorrection != EtatCorrection.N 
				|| etatCorrection != EtatCorrection.EC)
			throw new InvalidDevoirException("seuls les etats valides: [Y,N,EC]");
		return this.etatCorrection;
	}

	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	 public void setIdEtudiant(int idEtudiant){
		 this.idEtudiant = idEtudiant;
	 }
	 
	 public int getIdEtudiant(){
		 return this.idEtudiant;
	 }
	public void setNbrSoumises(int nbrSoumises){
		this.nbrSoumises = nbrSoumises;
	}
	public int getNbrSoumises(){
		return this.nbrSoumises;
	}
	public void setDateSoumise(Date dateSoumise){
		this.dateSoumise = dateSoumise;
	}
	public Date getDateSoumise(){
		return dateSoumise;
	}
	/*
	public static void setEmplacement(String emplacement){
		FeuilleSoumise.emplacement= emplacement;
	}
	
	public static String getEmplacement(){
		return emplacement;
	}
	*/
	public void setVersion(int version){
		this.version = version;
	}
	public int getVersion(){
		return version;
	}
}