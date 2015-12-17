package Entites;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Qcm extends Exercice
{	
	private List<ReponseAChoisir> reponsesAChoisir;
	
	public Qcm(int id, TypeExercice typeExo,int idFeuille, 
			int numExo, Question question, List<ReponseAChoisir> list)
	{
		super(id, typeExo, idFeuille,numExo, question );
		setType(TypeExercice.Qcm);
		this.reponsesAChoisir = list;
	}
	
	public Qcm(Qcm copy){
		super(copy);
		setReponses(copy.getReponses());
	}
	
	
	public List<ReponseAChoisir> getReponses(){
		return this.reponsesAChoisir;
	}
	
	
	public TypeExercice getType(){
		return TypeExercice.Qcm;
	}
	
	
	public void setReponses(List<ReponseAChoisir> reponsesAChoisir) {
		if (reponsesAChoisir == null || reponsesAChoisir.isEmpty())
			throw new InvalidDevoirException("liste de reponses à choisir est vide");
		System.arraycopy(reponsesAChoisir, 0, reponsesAChoisir, 0, reponsesAChoisir.size());
	}
	
	public void addReponse(ReponseAChoisir reponse){
		this.reponsesAChoisir.add(reponse);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder().append("[voila QCM : ").append(super.toString()).append(
				",\n list réponses à choisir:{\n");	
		
		if (reponsesAChoisir != null)
			for (Iterator<ReponseAChoisir> iter = reponsesAChoisir.iterator(); iter.hasNext(); )
			{
				s.append(iter.next().getChaine().toString()).append(",\n");
			}
		s.append("}");
		return s.toString();
	}
}
