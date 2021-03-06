package TestEntities;

import plateformeDevoirs.web.*;
import Dao.FeuilleDevoirImpl;
import Dao.IFeuilleDevoirDao;
import Entites.FeuilleDevoir;
import java.util.List;
import java.util.Iterator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/** ce test utilise  Spring, IBatis et base de donnees postgresql
 * a tester sans utiliser server Tomcat
 * */

public class TestFeuilledevoirDao { 
	

	public static void main(String[] args)
	{
	
		//instancier couche Dao pour FeuilleDevoir
		IFeuilleDevoirDao devoirDao = (IFeuilleDevoirDao) (new XmlBeanFactory( new ClassPathResource("" +
				"feuilleDevoirContext.xml"))).getBean("feuilledevoir_Dao");
		
		if (devoirDao != null){
			System.out.println("\n test r�ussi: on a pu instancier la dao [feuilledevoir_Dao]\n");
			
		}
		//IFeuilleDevoir testdevoir = new FeuilleDevoirImpl();
		List<FeuilleDevoir> list = (List<FeuilleDevoir>) devoirDao.selectAllDevoirs();
		if (list != null){
			System.out.println("la list de devoirs est chargee");
			Iterator<FeuilleDevoir> iter = list.iterator();
			if (list.isEmpty()){
				System.out.println("mais la list n'a pas encore d'element");
			}
			while (iter.hasNext()){
				FeuilleDevoir elt = iter.next();
				System.out.print(elt.toString());
			}
		}
	}
}
