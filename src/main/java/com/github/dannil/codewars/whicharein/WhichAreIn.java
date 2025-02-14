package com.github.dannil.codewars.whicharein;

import java.util.Arrays;

public class WhichAreIn {

	public static String[] inArray(String[] array1, String[] array2) {
		return Arrays.stream(array1)
				.filter(a -> Arrays.stream(array2).anyMatch(b -> b.contains(a)))
				.sorted()
				.toArray(String[]::new);
	}

}
