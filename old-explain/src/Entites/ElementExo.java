package Entites;

public class ElementExo {
	private int id;
	private String enoncee;
	private float bareme;
	private int numero;	
		
	public ElementExo(){}
	
		
	public ElementExo(int id, int numero, String chaine){
		this.id = id;
		this.numero = numero;
		this.enoncee = chaine;
	}
	public ElementExo(int id, int numero, String chaine, float bareme){
		this.id = id;
		this.numero = numero;
		setChaine(chaine);
		this.bareme = bareme;	
	}
	
	public ElementExo(ElementExo copy){
		setId(copy.getId());
		setNumero(copy.getNumero());
		setChaine(copy.getChaine());
		setBareme(copy.getBareme());
	}
	
	public void setId(int id) {
		if (id < 0)
		throw new InvalidDevoirException("invalid id");
		
	}

	public int getId() {
		return this.id;
	}
	
	public int getNumero(){
		return numero;
	}

	public void setNumero(int num){
		numero = num;
	}
	public void setChaine(String chaine) {
		if (chaine == null || chaine.trim().length() == 0)
			throw new InvalidDevoirException("chaine nulle");
			
		this.enoncee = chaine;
	}

	public String getChaine() { 
		return this.enoncee;
	}

	public void setBareme(float note) {
		this.bareme = note;		
	}

	public float getBareme() {
		return this.bareme;
	}	
	/*public String toString(){
		return "[idExo: "+this.idExo+", "+"type: "+this.typeExo+", "
				+"idFeuille: "+this.idFeuille+", "+"numExo: "+this.numberExo+", \n"
				+"la question: "+this.question+" ] ";
	}
*/
	public String toString(){
		return "[ id: "+this.id+", "+" numero:"+this.numero+", chaine: \""+this.enoncee+"\", bareme: "+this.bareme+"]";
	}
}
