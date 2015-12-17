package EvaluationService;
import java.util.List;

import Entites.Exercice;
import Entites.InvalidDevoirException;
import Entites.TypeExercice;
public class AutoCorrection extends GererDevoir{
	private Exercice qcmExercice;

	
	public AutoCorrection(Exercice qcm){
		this.qcmExercice = qcm;
	}
	
	
	//choisir un excercice à corriger
	@Override
	public void setExercice(Exercice exercice){
		if (exercice.getType() != TypeExercice.Qcm 
				&& exercice.getType() != TypeExercice.L 
				&& exercice.getType() != TypeExercice.P){
					throw new InvalidDevoirException("type invalide");
				}
			this.exo = exercice;
	}
		
	@Override
	public void corriger(Exercice qcm){
		//
	}
}
