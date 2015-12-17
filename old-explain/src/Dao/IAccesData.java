package Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Entites.Cours;
import Entites.Etudiant;
import Entites.FeuilleDevoir;
import Entites.FeuilleSoumise;
//import Entites.FeuilleSoumission;
import Entites.User;

public interface IAccesData {
	//liste des user
	//public List<User> getAllUser();
	
	//liste des feuilles d'excercices
	public Collection selectAllDevoirs();
	
	//liste des feuilles d'excercices d'un prof
	public List<FeuilleDevoir> selectDevoirsProf(int idProf);
	
	//liste des devoirs déjà soumises
	public List<FeuilleSoumise> selectAllFeuillesSoumises();
	
	//liste des devoirs soumises d'un etudiant
	public List<FeuilleSoumise> selectFeuillesSoumises(int idEtudiant);
	
	//liste des cours
	public List<Cours> selectAllCours();
	
	public List<Etudiant> selectAllEtudiants();
		
	//liste de Cours inscrits par un Etudiant
	public List<Cours> selectCoursInscrits(int idEtudiant);
	
	//liste des cours d'un professeur
	public List<Cours> selectCoursProf(int idProf);
	
	/*liste des etudiants s'etant inscrits à un cours,
	 * ceux qui ont le droit de corriger */
	public List<Etudiant> selectEtudiantsDuCours(Cours cours);
	
	public void saveEtudiantAuCours(Cours cours, int idEtudiant);
	
	public void deleteEtudiant(Cours cours, int idEtudiant);
	
	//ajouter un cours
	public void insertCoursProf(int idProf, Cours cours);
	
	public void insertCours(Cours cours);
	
	public void insertEtudiant(Etudiant e);
	
	//supprimer un Cours
	public List<Cours> deleteCours(int idCours);
	
	//ajouter une FeuilleDevoir 
	public void ajoutFeuilleExo(int idProf, FeuilleDevoir feuille);
	
	
	//liste des Feuilles de Soumission d'un etudiant déja soumettre
//	public List<FeuilleSoumission> getAllFeuilleSoumission(int idEtudiant);
	
}
