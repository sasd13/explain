package Service;

import java.util.ArrayList;
import java.util.List;

import Dao.*;
import Entites.*;

public interface IServicePlateForme {
	

		//liste des user
		//public List<User> getAllUser();
		
		//liste des feuilles d'excercices
		public List<FeuilleDevoir> getAllDevoirs();
		
		//liste des feuilles d'excercices d'un prof
		public List<FeuilleDevoir> getDevoirsProf(int idProf);
		
		//liste des devoirs déjà soumises
		public List<FeuilleSoumise> getAllFeuillesSoumises();
		
		//liste des devoirs soumises d'un etudiant
		public List<FeuilleSoumise> getFeuillesSoumises(int idEtudiant);
		
		//liste des cours
		public List<Cours> getAllCours();
		
		public List<Etudiant> getAllEtudiants();
			
		//liste de Cours inscrits par un Etudiant
		public List<Cours> getCoursInscrits(int idEtudiant);
		
		//liste des cours d'un professeur
		public List<Cours> getCoursProf(int idProf);
		
		/*liste des etudiants s'etant inscrits à un cours,
		 * ceux qui ont le droit de corriger */
		public List<Etudiant> getEtudiantsDeCours(Cours cours);
		
		public void saveEtudiantAuCours(Cours cours, int idEtudiant);
		
		public void suppimerIdEtudiant(Cours cours, int idEtudiant);
		
		//ajouter un cours
		public void ajoutCours(int idProf, Cours cours);
		
		public void ajouterCours(Cours cours);
		
		public void ajouterEtudiant(Etudiant e);
		
		//supprimer un Cours
		public List<Cours> supprimerCours(int idCours);
		
		//ajouter une FeuilleDevoir 
		public void ajoutFeuilleExo(int idProf, FeuilleDevoir feuille);
		
		
		//liste des Feuilles de Soumission d'un etudiant déja soumettre
//		public List<FeuilleSoumission> getAllFeuilleSoumission(int idEtudiant);
		
	}

