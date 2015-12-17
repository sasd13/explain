package Entites;

public class InvalidDevoirException extends RuntimeException{
	int codeError;
	
	public InvalidDevoirException(String msg){
		super(msg);
	}
	
	public InvalidDevoirException(String msg, int codeError){
		super(msg);
		this.codeError = codeError;
	}
	
	public int getErrCode(){
		return codeError;
	}
}
