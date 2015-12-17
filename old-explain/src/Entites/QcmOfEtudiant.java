package Entites;

import java.util.List;

public class QcmOfEtudiant extends Qcm{
		private List<ElementExo> solutionsChoisis;
		
		public QcmOfEtudiant(int id, TypeExercice typeExo,int idFeuille, 
				int numExo, Question question, List<ReponseAChoisir> list){
			super(id, typeExo, idFeuille,numExo, question, list );
		}
		
		
		public void addReponse(ReponseAChoisir repQcm){
			if (repQcm.getIsSelect()){
				super.addReponse(repQcm);
			}
		}
	
}
