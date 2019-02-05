package practice;

import java.util.Arrays;

public class ResizeArray {

	public static void main(String[] args) {

		int[] emparray = new int[10];

		System.out.println(Arrays.toString(emparray));

		// or

		for (int i : emparray) {
			System.out.println(i);
		}

		// You can't resize an array in Java. You'd need to either: Create a new array
		// of the desired size, and copy the contents from the original array to the new
		// array, using java.lang.System.arraycopy(...)

	}

}
