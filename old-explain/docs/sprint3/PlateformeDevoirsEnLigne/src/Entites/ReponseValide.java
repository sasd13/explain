package Entites;

import java.text.SimpleDateFormat;

public class ReponseValide extends ElementExo
{	
	private int idQcmQuestion;
	private int idReponsevalide;
	//private boolean valide;
	int numeroReponse;
	ReponseAChoisir reponseAChoisir;

	//liste reponses valides pour QCM: à faire !!!!
	
	public ReponseValide (int idReponseValide, int question, int numero, String solution ){
		super(idReponseValide, numero, solution );
		setIdQcmQuestion(question);
		//reponseAChoisir.setIsSelect(true);  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}	
	
	public void setIdQcmQuestion(int idQuestion) {
		this.idQcmQuestion = idQuestion;
	}
	
	public int getIdQcmQuestion(){
		return this.idQcmQuestion;
	}

	public ReponseValide(ReponseValide copy){
		super(copy);
		setIdQcmQuestion(copy.getIdQcmQuestion());		
	}
	
	
	@Override
	public int getId(){
		return this.idReponsevalide;
	}

	@Override
	public String toString(){
		return "[ voici la reponse valide: "+super.toString()+", idQuestion: "+this.getIdQcmQuestion()+"]";
	}
}
