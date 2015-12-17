package Service;

import java.util.List;
import Dao.IAccesData;
import Entites.Cours;
import Entites.Etudiant;
import Entites.FeuilleDevoir;
import Entites.FeuilleSoumise;

public class ServicePlateForme implements IServicePlateForme
{
	private IAccesData dao = null;
	
	public IAccesData getDao()
	{
		return dao;
	}
	
	public void setDao(IAccesData dao){
		this.dao = dao;
	}
	
	
	//liste des feuilles d'excercices
	public List<FeuilleDevoir> getAllDevoirs(){
		return (List<FeuilleDevoir>) dao.selectAllDevoirs();
	}
	
	//liste des feuilles d'excercices d'un prof
	public List<FeuilleDevoir> getDevoirsProf(int idProf){
		return (List<FeuilleDevoir>) dao.selectDevoirsProf(idProf);
	}
	
	//liste des devoirs déjà soumises
	public List<FeuilleSoumise> getAllFeuillesSoumises(){
		return (List<FeuilleSoumise>) dao.selectAllFeuillesSoumises();
	}
	
	//liste des devoirs soumises d'un etudiant
	public List<FeuilleSoumise> getFeuillesSoumises(int idEtudiant){
		return (List<FeuilleSoumise>) dao.selectFeuillesSoumises(idEtudiant);
	}
	
	//liste des cours
	public List<Cours> getAllCours(){
		return  (List<Cours>) dao.selectAllCours();
	}
	
	public List<Etudiant> getAllEtudiants(){
		return (List<Etudiant>) dao.selectAllEtudiants();
	}
		
	//liste de Cours inscrits par un Etudiant
	public List<Cours> getCoursInscrits(int idEtudiant){
		return (List<Cours>) dao.selectCoursInscrits(idEtudiant);
	}
	
	//liste des cours d'un professeur
	public List<Cours> getCoursProf(int idProf){
		return dao.selectCoursProf(idProf);
	}
	
	/*liste des etudiants s'etant inscrits à un cours */
	public List<Etudiant> getEtudiantsDeCours(Cours cours){
		return (List<Etudiant>) dao.selectEtudiantsDuCours(cours);
	}
	
	public void saveEtudiantAuCours(Cours cours, int idEtudiant){
		dao.saveEtudiantAuCours(cours, idEtudiant);
	}
	
	public void suppimerIdEtudiant(Cours cours, int idEtudiant){
		dao.deleteEtudiant(cours, idEtudiant);
	}
	
	//ajouter un cours
	public void ajoutCours(int idProf, Cours cours){
		dao.insertCoursProf(idProf, cours);
	}
	
	public void ajouterCours(Cours cours){
		dao.insertCours(cours);
	}
	
	public void ajouterEtudiant(Etudiant e){
		dao.insertEtudiant(e);
	}
	
	//supprimer un Cours
	public List<Cours> supprimerCours(int idCours){
		return (List<Cours>) dao.deleteCours(idCours);
	}
	
	//ajouter une FeuilleDevoir 
	public void ajoutFeuilleExo(int idProf, FeuilleDevoir feuille){
		dao.ajoutFeuilleExo(idProf, feuille);
	}

}
