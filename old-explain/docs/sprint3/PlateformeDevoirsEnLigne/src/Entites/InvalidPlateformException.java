package Entites;

@SuppressWarnings("serial")
/* to suppress warnings relative to missing 
 * serialVersionUID field for a serializable class*/
public class InvalidPlateformException extends RuntimeException{
	int codeErr;
	String msg;
	
	public InvalidPlateformException(String msg){
		super(msg);
	}
	
	public InvalidPlateformException(String msg, int code){
		super(msg);
		this.codeErr = code;
	}
	
	public int getCodeErr(){
		return codeErr;
	}
}
