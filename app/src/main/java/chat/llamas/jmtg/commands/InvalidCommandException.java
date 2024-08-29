package chat.llamas.jmtg.commands;

public class InvalidCommandException extends Exception {
	
	public InvalidCommandException(String message, Throwable cause) {
		super(message, cause);
	}
}
