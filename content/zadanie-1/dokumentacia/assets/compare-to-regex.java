public static String compareToRegex(String input) {
	// Kontrola, ci vstupny retazec nie je prazdny.
	if(input.length() == 0) {
		return "N";
	}

	// Kontrola prveho stavu:	Ak retazec na zaciatku obsahuje znak 'a', tak musi
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
	if(input.isEmpty()) {
		return "N";
	}

	// Kontrola druheho stavu:	Retazec musi obsahovat znak 'b' (bez ohladu na vysledok
	// 							prveho stavu). Inak nastava chyba. Ak obsahuje, tak 
	// 							odstrani skontrolovany znak.
	if(input.charAt(0) != 'b') {
		return "N";
	}
	input = input.substring(1);

	// Kontrola tretieho stavu:	Retazec moze obsahovat 0 a viac znakov 'a' alebo 'b'. 
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