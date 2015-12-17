package Entites;

//@SuppressWarnings("serial")
/* to suppress warnings relative to missing 
 * serialVersionUID field for a serializable class*/
public class InvalidUserException extends RuntimeException{
	int code;
	String msg;
	public InvalidUserException(String msg, int code){
		super(msg);
		this.code = code;
	}
}
