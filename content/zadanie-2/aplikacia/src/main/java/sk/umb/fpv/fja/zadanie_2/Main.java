package sk.umb.fpv.fja.zadanie_2;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static String input;

    private static HashMap<Character, String> inputVariables = new HashMap<>();
    
    public static void main(String[] args) {

        if(args.length == 0) {
            readFromConsole();
        }

    }

    // Nacitavanie retazca zo suboru.
    private static void readFromConsole() {

        System.out.print("Zadajte retazec pre vypocitanie: ");

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().trim();
        
        calculateResult();
        scanner.close();

    }

    private static void calculateResult() {

        // 1. Kontrola, ci retazec obsahuje premenne. Ak ano, tak ich ulozime do setu.
        for(int i = 0; i < input.length(); i++) {
            if(Character.isLetter(input.charAt(i))) {
                // Ak ide dva krat za sebou ten isty znak, vypise chybu.
                if (i > 0 && input.charAt(i - 1) == input.charAt(i)) {
                    System.out.println("Retazec obsahuje zly nazov premennej: " + input.charAt(i-1) + input.charAt(i));
                    System.exit(1);
                }
                else {
                    inputVariables.put(input.charAt(i), null);
                }
            }
        }

        // 2. Ak sa v retazci nachadzaju premenne, vyzveme pouzivatela aby zadal ich hodnoty.
        if(inputVariables.size() > 0) {
            System.out.println("Najdene premenne: " + inputVariables.toString());

            // TODO: Upravit tak, aby som vedel zadat v jednom riadku vsetky hodnoty
            Scanner scanner = new Scanner(System.in);
            for(Character variable : inputVariables.keySet()) {
                System.out.print("Zadajte hodnotu premennej " + variable + ": ");
                inputVariables.put(variable, scanner.nextLine().trim());
            }
            // DEBUG: System.out.println("Nove hodnoty: " + inputVariables.toString());

            // 2.1. Dosadenie premennych do retazca.
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                // Nie som si isty, ci by sa to ratalo ako regex, preto to nevyuzijem: value = input.replaceAll(String.valueOf(variable), String.valueOf(inputVariables.get(variable)));
                if (Character.isLetter(input.charAt(i))) {
                    if (i > 0 && (Character.isLetter(input.charAt(i - 1)) || Character.isDigit(input.charAt(i - 1))) && input.charAt(i - 1) != '*') { // napr. ak je 4a -> 4*2 a nie 42
                        stringBuilder.append("*" + inputVariables.get(input.charAt(i)));
                    } else {
                        stringBuilder.append(inputVariables.get(input.charAt(i)));
                    }
                } else {
                    stringBuilder.append(input.charAt(i));
                }
            }

            input = stringBuilder.toString();
            // DEBUG: System.out.println("Po dosadeni: " + input);

            // 3. Vypocet vyrazu.
            returnResult(input);
            scanner.close();
            return;
        }

        // 4. Vypocet vyrazu v pripade, ze nemame ziadne premenne.
        returnResult(input);
    }

    // Metoda pre vypocet vyrazu.
    private static void returnResult(String input) {
        try {
            Lexer lexer = new Lexer(new BufferedReader(new StringReader(input)));
            int result = new Parser(lexer).statement();
            System.out.println("Vysledok: " + result);
        } catch (CalculatorException exc) {
            System.err.println("Error: " + exc.getMessage());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
