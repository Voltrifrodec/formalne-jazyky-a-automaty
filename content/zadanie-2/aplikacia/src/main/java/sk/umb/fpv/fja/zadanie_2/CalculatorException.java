package sk.umb.fpv.fja.zadanie_2;

public class CalculatorException extends RuntimeException {

	public CalculatorException(String message) {
		super(message);
	}
	
	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}

}