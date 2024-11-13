package sk.umb.fpv.fja.zadanie_1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ApplicationTests {
	@Test
	public void testForInvalidInputs() {
		List<String> shouldBeInvalid = Arrays.asList(
				"", "a", "caab", "aab", "ababac", "abc");

		System.out.println("\n");
		for (String s : shouldBeInvalid) {
			String value = Application.compareToRegex(s);
			System.out.println(s + "\t" + value + " <=> N");
			assertEquals(value, "N");
		}
	}

	@Test
	public void testForValidInputs() {
		List<String> shouldBeValid = Arrays.asList(
			"b", "ab", "aba", "abab", "abba", "abaa"
		);

		System.out.println("\n");
		for (String s : shouldBeValid) {
			String value = Application.compareToRegex(s);
			System.out.println(s + "\t" + value + " <=> A");
			assertEquals(value, "A");
		}
		System.out.println("\n");
	}
}
