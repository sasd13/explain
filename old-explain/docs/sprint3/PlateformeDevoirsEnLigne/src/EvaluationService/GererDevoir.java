package EvaluationService;

import Entites.Exercice;

public abstract class GererDevoir {
	Exercice exo;

	public GererDevoir(){}
	
	public GererDevoir(Exercice ex){
		setExercice(ex);
	}
	
	public Exercice getExo(){
		return exo;
	}
	
	//choisir un excercice à corriger
	public void setExercice(Exercice exercice){
		this.exo = exercice;
	}
	
	public abstract void corriger(Exercice exo);
	
}
