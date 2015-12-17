package Entites;

import java.util.ArrayList;
import java.util.List;

public class Cours {

	private int idCours;
	private String titre;
	private int idProf;
	private boolean visible;
	private List<Integer> idsEtudiant;
	
	public Cours(){}
	
	public Cours(int id,String nom, int idProf,boolean visible, List<Integer> idsEtudiant){
		this.idCours = id;
		this.titre = nom;
		this.idProf = idProf;
		this.idsEtudiant = new ArrayList<Integer>();
		this.visible = visible;
		setIdsEtudiant(idsEtudiant);
	}
	
	public Cours(Cours copy){
		setIdCours(copy.getIdCour());
		setTitre(copy.getTitre());
		setIdProf(copy.getIdProf());
		setVisible(copy.getVisible());
		setIdsEtudiant(copy.getIdsEtudiant());
	}	
	
	public String toString()
	{
		StringBuilder s = new StringBuilder().append(this.idCours).
				append(this.titre).append(this.idProf).
				append(this.visible).append("[");
		if (idsEtudiant != null)
			for (int i=0; i < this.idsEtudiant.size(); i++)
				s.append(idsEtudiant.get(i)).append(" ");
		s.append("]");
		return s.toString();
	}
	
	//set- get
	
	public void setIdCours(int id){
		this.idCours = id;
	}
	
	public int getIdCour(){
		return idCours;
	}
	public void setTitre(String name){
		this.titre = name;
	}
	
	
	public String getTitre(){
		return titre;
	}
	
	public void setIdProf(int name){
		this.idProf = name;
	}
	
	public int getIdProf(){
		return idProf;
	}
	
	public int getIdCours(){
		return this.idCours;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
		
	}

	public boolean getVisible() {		
		return this.visible;
	}

	public void setIdsEtudiant(List<Integer> idsEtudiants){
		this.idsEtudiant = idsEtudiants;
	}
	
	public List<Integer> getIdsEtudiant(){
		return this.idsEtudiant;
	}
}
