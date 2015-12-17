package EvaluationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entites.Exercice;
import Entites.FeuilleDevoir;


public class Container {
	private Map<String,Object> composants;
	private Exercice exo;
	
	
	//constructeur pour les QCMs
	public Container(){
		this.composants = new HashMap<String, Object>();
		GererDevoir gererDevoir = new AutoCorrection(exo);
		gererDevoir.setExercice(exo);
		composants.put("gererDevoir",gererDevoir);
		ServiceDevoir serviceDevoir = new ServiceDevoir();
		serviceDevoir.setGererDevoir(gererDevoir);
		composants.put("service devoir", serviceDevoir);
	}
	
	//contructor pour copy
	public Container(Map<String,Object> list){
		this.composants = list;
	}
}
