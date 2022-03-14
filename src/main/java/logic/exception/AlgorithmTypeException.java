package logic.exception;

public class AlgorithmTypeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlgorithmTypeException (String message){
		super("error: " + message);
	}
	
	public AlgorithmTypeException (Throwable cause) {
		super(cause);
	}

	public AlgorithmTypeException (String message, Throwable cause) {
		super(" +++ " + message + " +++ ", cause);
	}
}
