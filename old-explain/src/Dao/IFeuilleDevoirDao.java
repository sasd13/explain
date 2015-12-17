package Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Entites.FeuilleDevoir;

public interface IFeuilleDevoirDao {

	/**		FeuilleDevoir	*/
	 
	Collection selectAllDevoirs();
		
	//liste des feuilles d'excercices d'un prof
	 List<FeuilleDevoir> selectDevoirsProf(int idProf); //read
	 
	 FeuilleDevoir selectOneDevoir(int idFeuille);
	 
	 //ajout ou modif
	 void saveDevoir(FeuilleDevoir feuille);
	 
	//ajouter une FeuilleDevoir 
	void insertOneDevoir(FeuilleDevoir feuille);   //creat
	
	void updateOneDevoir(FeuilleDevoir feuille);  //update
	
	void deleteOneDevoir(int idFeuilleDevoir);   //delete
	
}
