/*
 * Assignment #: 2
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class reads the user input and calls the different methods
 *              that will perform the different tasks that the user has chosen based on the menu prompt given to the user
 */

import java.util.Scanner; //The Scanner class is used to get the user input

public class Assignment2 {

  public static Scanner userInput = new Scanner(System.in);

  public static void main(String[] args) {

    int userChoice = 0; // Initialize the userChoice variable to 0

    do {
      userChoice = menuPrompt(); // Calls the initPrompt method
      switch (userChoice) {
        case 1:
          choiceOne(); // Calls the choiceOne method
          break;
        case 2:
          choiceTwo(); // Calls the choiceTwo method
          break;
        case 3:
          choiceThree(); // Calls the choiceThree method
          break;
        case 4:
          choiceFour(); // Calls the choiceFour method
          break;
        case 5:
          choiceFive(); // Calls the choiceFive method
          break;
        case 6:
          quit(); // runs the quit method
          break;
      }
      if (userChoice != 6) {
        System.out.println(); // Prints a blank line between each prompt result, making sure that it doesn't
                              // print a blank line at the end of the propmt when the user quits the program
      }
    } while (userChoice != 6); // the loop will continue to run till the user enters 6. Whicb is the quit
                               // option

    userInput.close(); // Closes the Scanner object
  }

  public static int menuPrompt() {
    System.out.println("Please choose one option from the following menu:");
    System.out.println("1. Calculate the sum of integers from 1 to m");
    System.out.println("2. Calculate the factorial of a given number");
    System.out.println("3. Calculate the count of odd integers in a given sequence");
    System.out.println("4. Display the leftmost digit of a given number");
    System.out.println("5. Calculate the greatest common divisor of two given integers");
    System.out.println("6. Quit");

    int userChoice = userInput.nextInt();
    return userChoice;
  }

  // different choices that the users can pick from the prompt
  public static void choiceOne() {
    System.out.println("Enter a number:"); // Prompt the user to enter a number
    int n = userInput.nextInt(); // Read user input and stores it in the int variable n
    int sum = (n * (1 + n)) / 2; // uses the Sum of Integers Formula to store the Sum of Integers in the int
                                 // variable sum
    System.out.println("The sum of 1 to " + n + " is " + sum); // Prints the sum of integers from 1 to n
  }

  public static void choiceTwo() {
    System.out.println("Enter a number:"); // Prompt the user to enter a number
    int n = userInput.nextInt(); // Read user input and stores it in the int variable m
    int factorial = 1; // Initialize the factorial variable to 1
    for (int i = 1; i <= n; i++) { // Loop that calculates the factorial of m
      factorial = factorial * i;
    }
    System.out.println("The factorial of " + n + " is " + factorial); // Prints the factorial of m
  }

  public static void choiceThree() {
    System.out.println("Enter the length of sequence"); // Prompt the user to enter the length of the
                                                        // sequence
    int length = userInput.nextInt();
    // the following loop will prompt the user to enter the next number in the
    // sequence till it reaches the total length of the sequence that the user has
    // entered.
    // However while the loop is running it will also check to see if the given
    // number enter was even odd
    // In which if it was, the program will then increase the total number of Odd
    // number stored in the variable "totalOdd"
    int totalOdd = 0;
    System.out.println("Enter the sequence");
    for (int i = 1; i <= length; i++) {
      int n = userInput.nextInt();
      if (n % 2 != 0) {
        totalOdd++;
      }
    }
    System.out.println("The count of odd integers in the sequence is " + totalOdd); // outputs the total number of odd
                                                                                    // integers in the sequence
  }

  public static void choiceFour() {
    System.out.println("Enter a number:"); // Prompt the user to enter a number
    int n = userInput.nextInt(); // Read user int input and stores it in the variable n

    int startingInt = n; // Initialize the variable startingInt to the value of n
    int leftMostDigit = 0; // Initialize the variable leftMostDigit to 0

    while (n > 0) { // Loop that will run till the number n is greater than 0
      leftMostDigit = n % 10; // Stores the remainder of n divided by 10 in the variable leftMostDigit
      n = n / 10; // Stores the value of n divided by 10 in the variable n
    }

    System.out.println("The leftmost digit of " + startingInt + " is " + leftMostDigit); // Prints the leftmost digit of
                                                                                         // the
    // number

  }

  public static void choiceFive() {

    System.out.println("Enter the first number:"); // Prompt the user to enter the first number
    int firstInt = userInput.nextInt(); // Read user int input and stores it in the variable n
    System.out.println("Enter the second number:"); // Prompt the user to enter the second number
    int secondInt = userInput.nextInt(); // Read user int input and stores it in the variable m

    int gcd = 0; // Initialize the variable gcd to 0

    for (int i = 1; i <= firstInt && i <= secondInt; i++) { // Loop that will run till the number i is less than or
                                                            // equal to the firstInt and i is less than or equal to the
                                                            // secondInt
      // less than or equal to m
      if (firstInt % i == 0 && secondInt % i == 0) { // Checks to see if the remainder of the firstInt variable divided
                                                     // by i is equal to 0
                                                     // and if the remainder of the secondInt variable divided by i is
                                                     // equal to 0 then it will run the code

        gcd = i; // Stores the value of i in the variable gcd, making gcd the greatest common
                 // divisor of the two numbers
      }
    }

    System.out.println("The greatest common divisor of " + firstInt + " and " + secondInt + " is " + gcd); // Prints the
                                                                                                           // greatest
    // common
    // divisor of the two numbers
  }

  public static void quit() {
    System.out.println("Bye"); // Prints Bye if the user chooses to quit
  }
}
