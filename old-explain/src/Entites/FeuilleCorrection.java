package Entites;

public class FeuilleCorrection {
	private int id;
	private int idFeuilleDevoir;
	private int idEtudiant;
	private int idCorrecteur;
	private float note;
	
	public FeuilleCorrection(int id, int idFeuilleDevoir, int idEtudiant,
			int idCorrecteur, float note)
	{
		this.id = id;
		this.idFeuilleDevoir = idFeuilleDevoir;
		this.idEtudiant= idEtudiant;
		this.idCorrecteur = idCorrecteur;
		this.note= note; 
	} 
	
	public FeuilleCorrection(FeuilleCorrection copy){
		setId(copy.getId());
		setIdEtudiant(copy.getIdEtudiant());
		setIdCorrecteur(copy.getIdCorrecteur());
		setNote(copy.getNote());
	}
	
	//toString
	public String toString(){
		StringBuilder s= new StringBuilder().append(this.id)
				.append(this.idFeuilleDevoir).append(this.idEtudiant)
				.append(this.idCorrecteur).append(this.note);
		return s.toString();
	}
	
	//getter-setter	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setIdFeuilleDevoir(int idFeuilleDevoir){
		this.idFeuilleDevoir = idFeuilleDevoir;
	}
	
	public int getIdFeuilleDevoir(){
		return this.idFeuilleDevoir;
	}
	
	 public void setIdEtudiant(int idEtudiant){
		 this.idEtudiant = idEtudiant;
	 }
	 
	 public int getIdEtudiant(){
		 return this.idEtudiant;
	 }
	 
	 public void setIdCorrecteur(int idCorrecteur){
		if (idCorrecteur == this.idEtudiant)
			new InvalidDevoirException("invalide Correcteur");
		this.idCorrecteur = idCorrecteur;
	 }
	 
	 public int getIdCorrecteur(){
		 return this.idCorrecteur;
	 }
	
	 public void setNote(float note){
		 this.note= note;
	 }
	 public float getNote(){
		 return note;
	 }
}
