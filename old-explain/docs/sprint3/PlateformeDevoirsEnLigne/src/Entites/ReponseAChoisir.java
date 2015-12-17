package Entites;

public class ReponseAChoisir extends ElementExo{
	private int idQuestion;
	private boolean isSelect; 
		
	public ReponseAChoisir(){
		super();
	}
		
	public ReponseAChoisir(int idQuestion, String reponse){
		this.getId();
		setChaine(reponse);
		this.isSelect = false;
	}
	
	public ReponseAChoisir(int idQuestionUniteQcm, int numberReponse, 
			String solution, int idQuestion)
	{
		super(idQuestionUniteQcm,numberReponse, solution);
		this.idQuestion = idQuestion;
		this.isSelect = false;
	}
	public ReponseAChoisir(int idReponse, int numberReponse, String solution, 
			float note, int idQuestion, boolean isSelect)
	{
		super(idReponse,numberReponse, solution, note);
		this.idQuestion = idQuestion;
		setIsSelect(isSelect);
	}
	//construsteur par copy
	public ReponseAChoisir(ReponseAChoisir copy){
		super(copy);
		setIsSelect(copy.getIsSelect());
	}

	//get-set
	public boolean getIsSelect(){
		return this.isSelect;
	}
	public void setIsSelect(boolean isSelect){
		this.isSelect = isSelect;
	}
	
	@Override
	public String toString(){
		return "[ idQuestion: "+this.idQuestion+", la reponse: "
	+"[ id: "+this.getId()+", "+" numero:"+this.getNumero()
	+", chaine: \""+this.getChaine()+"\"],"+
	"bareme: "+this.getBareme()+"]";
	}
	
}
