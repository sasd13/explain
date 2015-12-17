package Dao;

@SuppressWarnings("serial")
public class ExceptionDao extends RuntimeException
{
	public ExceptionDao(String msg){
		super(msg);
	}
	
}
