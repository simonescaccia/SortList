package logic.exception;

public class NumbersSequenceSplitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NumbersSequenceSplitException (String message){
		super("error: " + message);
	}
	
	public NumbersSequenceSplitException (Throwable cause) {
		super(cause);
	}

	public NumbersSequenceSplitException (String message, Throwable cause) {
		super(" +++ " + message + " +++ ", cause);
	}
	
}
