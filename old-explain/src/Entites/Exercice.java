package Entites;

import java.util.ArrayList;
import java.util.List;

public class Exercice
{
	private int id;
	private TypeExercice typeExo; 
	private int idFeuille;
	private int numberExo;
	private Question question;
	
	//contructeurs
	
	public Exercice(){}
	
	
	public Exercice(int id,TypeExercice typeExo , int idFeuille,
			int numberExo, Question question)
	{
		setIdExo(id);
		setType(getType());
		setIdFeuille(idFeuille);
		setNumberExo(numberExo);
		setQuestion(question);
	}
	
	public Exercice(Exercice copy){
		setIdExo(copy.getIdExo());
		setType(copy.getType());
		setIdFeuille(copy.getIdFeuille());
		setNumberExo(copy.getNumberExo());
		setQuestion(copy.getQuestion());
	}
	
	//get-set
	
	public void setIdExo(int idExo) {
		this.id = idExo;
	}

	public int getIdExo() {
		return id;
	}
	
	public void setIdFeuille(int idFeuille) {
		if (idFeuille < 0)
			throw new InvalidDevoirException("invalid idQuestion["+idFeuille+" ]");
		
	}

	public int getIdFeuille() {
		return this.idFeuille;
	}

	public void setNumberExo(int numberExo) {
		if (numberExo < 0)
			throw new InvalidDevoirException("invalid idQuestion["+numberExo+" ]");
		this.numberExo = numberExo;
	}

	public int getNumberExo() {
		return this.numberExo;
	}
	
	public  TypeExercice getType() {
		return typeExo;
	}

	public void setType(TypeExercice type){
		this.typeExo = type;
	}
	public Question getQuestion(){
		return this.question;
	}
	
	public void setQuestion(Question enonce){
		if (enonce == null)
			throw new InvalidDevoirException("Invalide question");
		this.question = enonce;
	}

	public String toString(){
		return "[idExo: "+this.id+", "+"type: "+this.typeExo+", "
				+"idFeuille: "+this.idFeuille+", "+"numExo: "+this.numberExo+", \n"
				+"la question: "+this.question+" ] ";
	}
}
