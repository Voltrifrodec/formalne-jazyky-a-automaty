package sk.umb.fpv.fja.zadanie_1;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// Podpora pre nacitanie vstupneho retazca z konzoly.
		if(args.length == 0) {
			System.out.println("regex: [a]b{a|b}\n");
			readFromConsole();
		}
	}

	public static String compareToRegex(String input) {

		// Kontrola, ci vstupny retazec nie je prazdny.
		if(input.length() == 0)
			return "N";

		// Kontrola prveho stavu: 	Ak retazec na zaciatku obsahuje znak 'a', tak musi
		// 							dalsi znak musi byt 'b'. Inak nastava chyba. Ak obsahuje,
		// 							tak odstrani skontrolovany znak. A skontroluje ci novy
		// 							retazec nie je prazdny a ci na zaciatku je znak 'b'
		//							(druhy stav).
		if(input.charAt(0) == 'a') {
			input = input.substring(1);
			
			if(!input.isEmpty() && input.charAt(0) != 'b') {
				return "N";
			}

		}
		if(input.isEmpty())
			return "N";

		// Kontrola druheho stavu: 	Retazec musi obsahovat znak 'b' (bez ohladu na vysledok
		// 							prveho stavu). Inak nastava chyba. Ak obsahuje, tak 
		// 							odstrani skontrolovany znak.
		if(input.charAt(0) != 'b') {
			return "N";
		}
		input = input.substring(1);

		// Kontrola tretieho stavu: Retazec moze obsahovat 0 a viac znakov 'a' alebo 'b'. 
		// 							Ak obsahuje iny, nastava chyba. Ak nie, skrat vstupny
		//							retazec o skontrolovany stav.
		while(!input.isEmpty()) {
			if(input.charAt(0) != 'a' && input.charAt(0) != 'b') {
				return "N";
			}
			input = input.substring(1);
		}
		
		// Ak je vsetko v poriadku, tak sa vrati vystup 'A'.
		return "A";

	}

	// Metoda pre nacitanie a porovnanie znaku z konzoly pouzivatelom.
	private static void readFromConsole() {

		// Nacitanie vstupneho retazca z konzoly.
		System.out.print("Zadajte vstupny retazec: ");
		Scanner reader = new Scanner(System.in);
		String input = reader.next().trim(); // .trim() pre odstranenie whitespace znakov
		
		// Ukoncenie nacitavania znakov.
		reader.close();

		System.out.println(
			String.format("\nVstup -> %s,  vystup: %s", input, compareToRegex(input))
		);

	}

}