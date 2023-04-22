
/* 
    Assignment #: 1
    Name: David Nevarez
    StudentID: 1225929460
    Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
    Description: This class reads a string, an integer and a floating point number from a keyboard and prints it out
                 along with other messages.
*/
import java.util.Scanner; //The Scanner class is used to get the user input

public class Assignment1 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in); // allows for the program to be able to read the user's keyboard
                                                    // input

        System.out.println("Enter your name:"); // read a string (name) entered by a user
        String userName = userInput.nextLine(); // reads the user's next line of input and stores it in a String
                                                // variable named "userName"

        System.out.println("Enter last four digits of your ASU ID:"); // read a integer (last four digits of ASU ID)
                                                                      // entered by a user
        int userID = userInput.nextInt(); // reads the user's next number(as long it's a int) input and stores it in a
                                          // String variable named "userID"

        System.out.println("Enter your CGPA:"); // read a floating point number (classGPA) entered by a user
        float cumulativeGPA = userInput.nextFloat(); // reads the user's next float input and stores it in a float
                                                     // variable
        // named "cumulativeGPA"

        // print the information entered by the user along with other messages
        System.out.printf("Name: %s\n", userName); // outputs the user's name that they inputted to the system
        System.out.printf("Last four digits of ASU ID: %d\n", userID); // outputs the user's last four digits of their
                                                                       // ASU
                                                                       // ID that they inputted into the system.
        System.out.println("CGPA: " + cumulativeGPA); // outputs the user's cumulative GPA that they inputted to
                                                      // the
        // system

        userInput.close(); // closes the Scanner, so it stops reading the user's input
    }
}
