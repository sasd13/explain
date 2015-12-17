package Entites;

//@SuppressWarnings("serial")
/* to suppress warnings relative to missing 
 * serialVersionUID field for a serializable class*/
public class InvalidUserException extends RuntimeException{
	int codeErr;
	String msg;
	
	public InvalidUserException(String msg){
		super(msg);
	}
	
	public InvalidUserException(String msg, int code){
		super(msg);
		this.codeErr = code;
	}
	
	public int getCodeErr(){
		return codeErr;
	}
}
