/* 
 * Assignment #: 4
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The Assignment 4 class displays a menu of choices to the user
                and performs the chosen task. It will keep asking the user to
                enter the next choice until the choice of 'Q' (Quit) is entered.
*/

import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        // local variables, can be accessed anywhere from the main method
        char input1 = 'Z';
        String major, subject, instructor;
        int id, courseId;
        String line;
        // instantiate a Student and course objects
        Student student = new Student();
        Course course = new Course();

        // prints the menu prompt out for the user
        printMenu();
        // Create a Scanner object to read the user's input
        Scanner scan = new Scanner(System.in);
        do { // will ask for user input
            System.out.println("\nWhat action would you like to perform?");
            line = scan.nextLine();
            if (line.length() == 1) {
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);
                // matches one of the case statement
                switch (input1) {
                    case 'A':

                        // Add a Student
                        System.out.print("\nPlease enter the student's information:\n");
                        System.out.print("\nEnter student's ID:\t");
                        id = scan.nextInt();
                        scan.nextLine(); // use to skip the enter key you typed
                        System.out.print("\nEnter student's major:\t");
                        major = scan.nextLine();

                        // Add a course
                        System.out.print("\nPlease enter the course information:");
                        System.out.print("\nEnter course ID:\t");
                        courseId = scan.nextInt();
                        scan.nextLine(); // use to skip the enter key you typed
                        System.out.print("\nEnter instr. name:\t");
                        instructor = scan.nextLine();
                        System.out.print("\nEnter course subject:\t");
                        subject = scan.nextLine();

                        course = new Course(courseId, instructor, subject);
                        student = new Student(id, major, course);
                        break;
                    case 'D':
                        // Display Student Info
                        System.out.print(student);
                        System.out.print(course);
                        break;
                    case 'Q': // Quit
                        break;
                    case '?': // Display Menu
                        printMenu();
                        break;
                    default:
                        System.out.print("Unknown action\n");
                        break;
                }
            } else {
                System.out.print("Unknown action\n");
            }
        } while (input1 != 'Q' || line.length() != 1); // will run till the user quits the program or has no input
        scan.close();
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Student\n" +
                "D\t\tDisplay Student info\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
