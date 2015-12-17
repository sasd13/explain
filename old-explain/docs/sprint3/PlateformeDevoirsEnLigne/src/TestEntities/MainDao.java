package TestEntities;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import Dao.ExceptionDao;
import Dao.IFeuilleDevoirDao;
import Dao.IUserDao;
import Entites.User;
import junit.framework.TestCase;

public class MainDao extends TestCase { //test Junit
	//couche Dao
	
	public static void main(String[] args)
	{
		/**------------user-----------*/
		//IFeuilleDevoirDao devoirDao;
		IUserDao userDao;
		
		//instancier Dao User
		userDao = (IUserDao) (new XmlBeanFactory( new ClassPathResource(
				"userContext.xml"))).getBean("user_Dao");
		 
		if (userDao == null){
				throw new ExceptionDao("echouer d'instancier la dao userDao] ");
		}else{			
			System.out.println("\n test réussi: on a pu instancier la dao [userDao]\n");
		}
		
		List<User> users = userDao.selectAllUsers();
		if (users == null){
			throw new ExceptionDao("echec chargement liste des utilisateurs de la BDD");
		}else{
			System.out.print("succes de chargement liste des utilisateurs de la BDD");
			
			Iterator<User> iter = users.iterator();
			while (iter.hasNext()){
				iter.next().toString();
			}
		}
		// get un user
		
	}
}
