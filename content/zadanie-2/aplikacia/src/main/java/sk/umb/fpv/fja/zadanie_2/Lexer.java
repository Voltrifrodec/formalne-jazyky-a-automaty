package sk.umb.fpv.fja.zadanie_2;

import java.io.IOException;
import java.io.Reader;

public class Lexer {
	private int current;
	private Reader input;
	
	public Lexer(Reader input) {
		this.input = input;
		consume();
	}

	// Metoda pre nacitanie dalsieho operatora podla znaku ktory mu pride.
	public Token nextToken() {
		switch(current) {
			case '+':
			return Token.PLUS;
			case '-':
			return Token.MINUS;
			case '*':
			return Token.MUL;
			case '/':
			return Token.DIV;
			case '(':
			return Token.LPAR;
			case ')':
			return Token.RPAR;
			case -1:
			return Token.EOF;
			default: {
				if (Character.isDigit(current))
				return Token.NUMBER;
				throw new CalculatorException("Chyba v Lexer.java: Neočakávaný znak: " + (char) current);
			}
		}
	}

	// Metoda pre nacitanie znaku z retazca. Akonahle zavolame Lexer po prvy krat sa tato metoda spusti.
	public void consume() {
		try {
			current = input.read();
		} catch (IOException e) {
			throw new CalculatorException("Lexer consume error: " + e);
		}
	}

	// Metóda pre vrátenie hodnoty
	public int getValue() {
		return Integer.valueOf(String.valueOf((char) current));
	}
}
