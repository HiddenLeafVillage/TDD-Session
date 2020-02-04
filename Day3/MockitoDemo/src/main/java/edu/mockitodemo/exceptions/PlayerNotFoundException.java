package edu.mockitodemo.exceptions;

public class PlayerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlayerNotFoundException(String message) {
		super(message);
	}
	
}
