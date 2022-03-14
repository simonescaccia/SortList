package logic.exception;

public class OrderTypeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderTypeException (String message){
		super("error: " + message);
	}
	
	public OrderTypeException (Throwable cause) {
		super(cause);
	}

	public OrderTypeException (String message, Throwable cause) {
		super(" +++ " + message + " +++ ", cause);
	}

}
