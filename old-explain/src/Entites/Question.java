package Entites;

public class Question extends ElementExo{
	
	public Question(int id, int num, String quest){
		super(id,num, quest);
	}
		
	//constructeur pour initiation
	public Question(int idQuestion, int numQuestion, String enoncee, float baremeQuest){
		super(idQuestion, numQuestion, enoncee,baremeQuest);
	}
	
	public Question(Question copy){
			super(copy);
	}
	
	@Override
	public void setBareme(float baremeQuest){
		if (baremeQuest <= 0 )
			throw new InvalidDevoirException("invalid note ["+ baremeQuest+"]");
		super.setBareme(baremeQuest);
	}
	
	@Override
	public void setChaine(String request){
		if (request == null || request.trim().length() == 0)
			throw new InvalidDevoirException("invalid request["+request+" ]");
		super.setChaine( request);
	}
	

}
