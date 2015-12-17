package Dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Entites.User;

public interface IUserDao {
	
	/**		User	*/
	 
	List<User> selectAllUsers();
	
	User selectOneUser(int idUser);
	 
	 //ajout ou modif
	 void saveUser(User user);
	 
	//ajouter une User 
	void insertOneUser(User user);   //creat
	
	void updateOneUser(User user);  //update
	
	void deleteOneUser(int idUser);   //delete
	
}
