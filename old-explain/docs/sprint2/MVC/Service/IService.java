package Service;

import java.util.List;

import Entites.Cours;
import Entites.FeuilleExo;
import Entites.User;

public interface IService {
	//liste des user
	public List<User> getAllUser();
	
	//liste des cours
	public List<Cours> getAllCours();
	
	//liste des cours d'un professeur
	public List<Cours> getCoursProf(int idProf);
	
	//ajouter un cours
	public int ajoutCours(int idProf, String titreCours);
	
	//ajouter une FeuilleExo 
	public int ajourtFeuilleExo(int idProf, String nameFeuille);
	
	//liste des Feuilles d'exercices d'un etudiant à faire
	public List<FeuilleExo> getAllFeuilleExo(int idEtudiant);
	
}
