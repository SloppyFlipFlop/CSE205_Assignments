/* 
 * Assignment #: 8
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This program will ask the user to choose from a menu of options. Which will then call a method that will perform a specific task according to the user's choice.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment8 {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			char choice = ' ';

			while (choice != 'E') {
				printMenu();
				line = reader.readLine();
				choice = line.charAt(0);
				choice = Character.toUpperCase(choice);


				/*
				 * This switch statement will call a method based on the user's choice.
				 */
				switch (choice) {
					case 'A': // asks the user to enter a list of numbers and then calculates the sum of all elements in a array
						System.out.print("Enter numbers (0 to finish): ");
						double[] array = parseDoubles(reader);
						System.out.println("Sum of elements in array: " + sumOfArray(array, 0));
						break;
					case 'B': // asks the user to enter two numbers and then calculates the sum of all integers between the two numbers including the two numbers
						System.out.print("Enter the first number: ");
						int num1 = readInteger(reader);
						System.out.print("Enter the second number: ");
						int num2 = readInteger(reader);
						System.out.println("The sum of all integers between " + num1 + " and " + num2 + " is: "
								+ sumOfIntegers(num1, num2));
						break;
					case 'C': // asks the user to enter an integer and then calculates the prime factorization of the integer
						System.out.print("Enter an integer to factorize: ");
						int num = readInteger(reader);
						System.out.println("The prime factorization of " + num + " is: "
								+ primeFactorization(num).substring(0, primeFactorization(num).length() - 1));
						break;
					case 'D': // asks the user to enter a string and a substring and then removes all occurrences of the substring in the string
						System.out.print("Please enter string: ");
						String str = reader.readLine();
						System.out.print("Please enter substring to remove: ");
						String sub = reader.readLine();
						System.out.println("String after substring removal: " + removeSubstring(str, sub));
						break;
					case 'E': // exits the program
						break;
					default: // if the user enters an invalid choice, the program will print an error message
						System.out.println("Invalid choice. Please choose a char between A and E.");
						break;
				}
			}

		} catch (IOException ex) { // catches any IO exceptions
			System.out.println("IO Exception.");
		}

	}

	// A: recursive method that calculates the sum of all elements in an array of
	// doubles and returns the sum
	public static double sumOfArray(double[] array, int value) {
		double total = 0.0;

		if (value == array.length)
			return total; // base case

		/*
		 * In this recursive case, what's basically happening is that we're gonna be
		 * calling this method recursively until it reaches the base case.
		 * In which this method will continue to add the first element of the array to
		 * the total and
		 */

		total += array[value];
		total += sumOfArray(array, ++value);

		return total;
	}

	// B: recursive method that calculates the sum of all integers between two
	// numbers (including the two numbers) and returns the sum

	public static int sumOfIntegers(int num1, int num2) {

		// refactor the code so that it doesn't matter which number is larger

		int total = 0;

		// check if the first number is larger than the second number
		if (num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}

		if (num1 == num2)
			return num1; // base case - if the two numbers ever equal each other, the recursive method will end and return the total sum

		total += num1; // add the first number to the total
		total += sumOfIntegers(++num1, num2); // increases the first number by 1 and calls the method again

		return total;

	}

	// C: recursive method that calculates the prime factorization of an integer and
	// returns a string as a result

	public static String primeFactorization(int num) {
		String result = "";

		if (num == 1) return result; // base case - if the number ever equals 1, the recursive method will end and return the result

		int i = 2; // start at 2 because 1 is not a prime number
		i = whileLoop(num, i); // call the whileLoop method to find the next prime number

		result += i + "x"; // add the prime number to the result
		result += primeFactorization(num / i); // divides the number given by the prime number and calls the method again

		// result = result.substring(0, result.length() - 1);
		return result;
	}

	// this is a helper method
	/*
	 * my original idea was to use a while loop, but couldn't do that. Here's a
	 * explain of the while loop i was planning to use
	 * while (num % i != 0) {
	 * i++;
	 * }
	 * This while loop will keep incrementing the value of i until the remainder of the
	 * number divided by i is equal to 0.
	 * This would have also replaced the `i = whileLoop(num, i);` line in the primeFactorization method
	 */
	private static int whileLoop(int num, int i) {
		// this method will keep incrementing the value of i until the remainder of the number divided by i is equal to 0
		if (num % i != 0) {
			i++;
			i = whileLoop(num, i);
		}
		return i;
	}

	// D: recursive method that removes all occurrences of a specified substring in
	// a string and returns the result string

	public static String removeSubstring(String str, String sub) {
		String result = "";

		if (str.length() < sub.length())
			return str; // base case - if the length of the string is less than the length of the substring, the recursive method will end and return the result

		// explanation of the code below:
		// if the first substring of the string is equal to the substring we're looking
		// for, then we'll call the method recursively and pass the substring of the
		// string starting from the index of the substring we're looking for
		// otherwise, we'll add the first character of the string to the result string
		// and call the method recursively and pass the substring of the string starting
		// from the second character

		if (str.substring(0, sub.length()).equals(sub)) {
			result += removeSubstring(str.substring(sub.length()), sub);
		} else {
			result += str.charAt(0) + removeSubstring(str.substring(1), sub);
		}

		return result;
	}

	// ----------------------------------------------------------------------------------------

	// utility method for parsing doubles from standard input that returns an array
	// of doubles
	public static double[] parseDoubles(BufferedReader reader) {
		String line = "";
		ArrayList<Double> container = new ArrayList<>();
		try {
			line = reader.readLine();
			double num = Double.parseDouble(line);

			while (num != 0) {
				container.add(num);
				line = reader.readLine();
				num = Double.parseDouble(line);
			}

		} catch (IOException ex) {
			System.out.println("IO Exception.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, return to main menu.");
		}

		double[] result = new double[container.size()];
		for (int i = 0; i < container.size(); i++) {
			result[i] = container.get(i);
		}
		return result;
	}

	// utility method for parsing integers from standard input (only positive
	// integers allowed)
	public static int readInteger(BufferedReader reader) throws IOException {
		int number = 0;
		try {
			String line = reader.readLine();
			number = Integer.parseInt(line);
		} catch (IOException e) {
			System.out.println("Error reading input. Please try again.");
			number = readInteger(reader);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please try again.");
			number = readInteger(reader);
		}
		if (number < 0) {
			System.out.println("Invalid input. Only positive integers allowed. Please try again.");
			number = readInteger(reader);
		}
		return number;
	}

	// utility method for printing the menu
	public static void printMenu() {
		System.out.print("\nWhat would you like to do?\n\n");
		System.out.print("A: Calculate the sum of all elements in an array of doubles\n");
		System.out.print("B: Calculate the sum of all integers between two numbers (including the two numbers)\n");
		System.out.print("C: Calculate the prime factorization of an integer\n");
		System.out.print("D: Remove all occurrences of a specified substring in a string\n");
		System.out.print("E: Quit\n\n");
	}
}
