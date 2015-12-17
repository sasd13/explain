package Dao;

import java.util.ArrayList;

import Entites.Cours;
import Entites.Etudiant;
import Entites.FeuilleDevoir;
import Entites.FeuilleSoumise;
import Entites.TypeExercice;
import Entites.User;

 interface Idao 
 {
	 /**	User	*/
	 
	//liste des user
	 ArrayList<User> selectAllUser();
	 
	 User selectOneUser(int idUser);
	 
	 void insertOneUser(User user);
	 
	 void updateOneUser(User user);
	 
	 void deleteUser(int idUser);
	 
	/**		FeuilleDevoir	*/
	 
	//liste des feuilles d'excercices
	 ArrayList<FeuilleDevoir> selectAllDevoirs();
		
	//liste des feuilles d'excercices d'un prof
	 ArrayList<FeuilleDevoir> selectDevoirsProf(int idProf); //read
	 
	 FeuilleDevoir selectOneDevoir(int idFeuille);
	 
	 //ajout ou modif
	 void saveDevoir(int idProf, FeuilleDevoir feuille);
	 
	//ajouter une FeuilleDevoir 
	void insertOneDevoir(int idProf, FeuilleDevoir feuille);   //creat
	
	void updateOneDevoir(int idProf, FeuilleDevoir feuille);  //update
	
	void deleteOneDevoir(int idProf, int idFeuilleDevoir);   //delete
	
	/**    FeuillesSoumises	*/
	
	//liste des devoirs déjà soumises
	 ArrayList<FeuilleSoumise> selectAllFeuillesSoumises();
	
	//liste des devoirs soumises d'un etudiant
	 ArrayList<FeuilleSoumise> selectAllFeuillesSoumises(int idEtudiant,
			 FeuilleSoumise feuillesSoumise); 		 //read
	
	 /**     Cours */
	 
	//liste des cours
	 ArrayList<Cours> selectAllCours();
	 
	 Cours selectOneCours(int idCours); //read

	 //ajout ou modif
	 void saveCours(Cours cours); 
	 
	 void insertOneCours(Cours cours); //creat
	 
	 void updateOneCours(Cours cours); //update
	 
	void deleteOneCours(int idCours); //delete
	 
	//liste des cours d'un professeur
	 ArrayList<Cours> selectAllCoursProf(int idProf);
	 
	//liste de Cours inscrits par un Etudiant
	 ArrayList<Cours> selectAllCoursEtudiant(int idEtudiant);
	 
	//ajouter un cours
	void insertCoursProf(int idProf, Cours cours);

	 
	 /**     Etudiant*/
	 
	 ArrayList<Etudiant> selectAllEtudiants();		
	
	 Etudiant selectOneEtudiant(int idEtudiant);
	 
	 //ajout ou modif un etudiant
	 void saveEtudiant(Etudiant e);
	 
	 void insertOneEtudiant(Etudiant e);
	 
	 void updateOneEtudiant(Etudiant e);
	 
	 void deleteOneEtudiant(int idE);
	 
	 
	 void deleteEtudiant(Cours cours, int idEtudiant);
	
	 //liste des etudiants s'etant inscrits à un cours,
	 ArrayList<Etudiant> selectAllEtudiantsDuCours(Cours cours);
	
	 Etudiant selectEtudiantDuCours(Etudiant e);
	 
	 //ajout ou modif un etudiant inscrit au cours
	 void saveEtudiantAuCours(int idCours, int idEtudiant);
	 
	 void insertEtudiantAuCours(Cours cours, int idEtudiant);
	 
	 ArrayList<Etudiant> updateEtudiantAuCours(Cours cours, int idEtudiant); 	
	
	
	//liste des Feuilles de Soumission d'un etudiant déja soumettre
//	 List<FeuilleSoumission> selectAllFeuilleSoumission(int idEtudiant);
	 
	 /**		Excercice */
	 
	 void selectOneExcercie(int idExo, TypeExercice type);   //read
	 
	 void saveExcercie(int idExo, TypeExercice type);
	 
	 void insertExcercie(int idExo, TypeExercice type);   //creat
	 
	 void updateExcercie(int idExo, TypeExercice type);
	 
	 void deleteExcercice(int idExo, TypeExercice type);
	
}
