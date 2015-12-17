package TestEntities;

import plateformeDevoirs.web.*;
import Dao.ExceptionDao;
import Dao.FeuilleDevoirImpl;
import Dao.IFeuilleDevoirDao;
import Entites.FeuilleDevoir;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;

/** ce test utilise  Spring, IBatis et base de donnees postgresql
 * a tester sans utiliser server Tomcat
 * */

public class TestFeuilledevoirDao { 
	

	public static void main(String[] args)
	{
	
		//instancier couche Dao pour FeuilleDevoir
		IFeuilleDevoirDao devoirDao = (IFeuilleDevoirDao) (new XmlBeanFactory( 
				new ClassPathResource("feuilleDevoirContext.xml"))).getBean("feuilledevoir_Dao");
		
		if (devoirDao == null){
			throw new ExceptionDao("echouer d'instancier la dao feuilledevoir_Dao] ");
		}else{			
			System.out.println("\n test réussi: on a pu instancier la dao [feuilledevoir_Dao]\n");
			}
		
		
		List<FeuilleDevoir> list = (List<FeuilleDevoir>) devoirDao.selectAllDevoirs();
		if (list == null){
			throw new ExceptionDao("echec de charger la liste de feuilles devoirs");
		}else
			System.out.println("la list de devoirs est chargee");
		
		Iterator<FeuilleDevoir> iter = list.iterator();
		if (list.isEmpty()){
			System.out.println("mais la list n'a pas encore d'element");
		}else{
			System.out.println("parcourir la list:");
			while (iter.hasNext()){
				FeuilleDevoir elt = iter.next();
				System.out.println(elt.toString());
			}			
		}
		
		//delete une feuille devoir dans la base
		try{
			devoirDao.deleteOneDevoir(19); //ok
		}catch(Exception ex){
			System.out.println("echec delete une feuille devoir d'id 19 car elle est inconnue");
			}
		
		FeuilleDevoir f = new FeuilleDevoir(15, "maths", 2, "emplacem", 11, 3, "4/12/1014" );
		
		//insert une feuille a la base
			devoirDao.insertOneDevoir(f);  //ok
		
		devoirDao.updateOneDevoir(devoirDao.selectOneDevoir(15));  //ok
				
	}
}
