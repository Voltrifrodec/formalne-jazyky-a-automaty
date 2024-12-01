package sk.umb.fpv.fja.zadanie_2;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ApplicationTests {
    
    @Test
    public void testForInvalidInputs() {
        List<String> shouldBeInvalid = Arrays.asList(
            "5--1", "1*/5", "5-2++9", "7**223", "2--", "(1+(3*2+1)3)/2)", "5/0"
        );

        System.out.println("\n");
        for (String s : shouldBeInvalid) {

            String value = testResult(s);
            System.out.print(s + "\t" + value + "=> ");
            assertEquals(null, value);
        }

    }

    @Test
    public void testForValidInputs() {
        List<String> shouldBeValid = Arrays.asList(
            "3/3", "5*2", "3-7/2", "8*6", "2*3+9-7", "3*2+1-3/2"
        );
        List<String> validAnswers = Arrays.asList(
            "1", "10", "0", "48", "8", "6"
        );

        System.out.println("\n");
        for (String s : shouldBeValid) {
            String value = testResult(s);
            System.out.print(s + "\t" + value + "=> ");
            assertEquals(validAnswers.get(shouldBeValid.indexOf(s)), value);
        }
    }

    private static String testResult(String input) {
        try {
            Lexer lexer = new Lexer(new BufferedReader(new StringReader(input)));
            int result = new Parser(lexer).statement();
            System.out.println("Vysledok: " + result);
            return Integer.toString(result);
        } catch (CalculatorException exc) {
            System.err.println("Error: \n" + exc.getMessage());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

}
