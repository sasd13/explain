package Entites;

import java.util.List;

public class QcmCorrigee extends Qcm{

	public QcmCorrigee(int id, TypeExercice typeExo,int idFeuille, 
			int numExo, Question question, List<ReponseAChoisir> list) {
		super(id, typeExo, idFeuille,numExo, question,list) ;
	}

}
