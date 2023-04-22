/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This file is the driver class for the program. It is used to read the user's input and perform the operations that the user wants to perform using the data given.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Assignment7 {
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Movie and Movie Genre information
        String movieName, movieGenre;
        String review = null, director, productionCompany, totalCollection;

        int rating;
        // Output information
        String outFilename, inFilename;
        // String outMsg, inMsg;
        String outMsg;
        // Movie manager
        ReviewManager reviewManager = new ReviewManager(); // create
        // Operation result
        boolean opResult;

        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Movie Review
                        System.out.print("Please enter the movie information:\n");
                        System.out.print("Enter the movie name:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the total collection:\n");
                        totalCollection = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the movie genre:\n");
                        movieGenre = stdin.readLine().trim();
                        System.out.print("Enter the movie's Director:\n");
                        director = stdin.readLine().trim();
                        System.out.print("Enter the movie's production company\n");
                        productionCompany = stdin.readLine().trim();

                        /*********************************************************************
                         * Complete the code by calling the addReview method. *
                         * If the review was added successfully, show *
                         * "Movie added to the database!\n" on screen, otherwise "Movie NOT added!\n" *
                         **********************************************************************/

                        opResult = reviewManager.addReview(movieName, rating, review, totalCollection, movieGenre,
                                director, productionCompany);
                        if (opResult) {
                            System.out.print("Movie added to the database!\n");
                        } else {
                            System.out.print("Movie NOT added!\n");
                        }

                        break;
                    case 'D': // Search for a movie
                        System.out.print("Please enter the Movie name to search:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the movies's director':\n");
                        director = stdin.readLine().trim();

                        // Complete the code. If the movie review exists, print "Movie found. Here's the
                        // review:\n". Otherwise, print "Movie not found. Please try again\n"
                        int doesmovieExists = reviewManager.movieExists(movieName, director);
                        if (doesmovieExists == 1) {
                            System.out.print("Movie found. Here's the review:\n");
                            System.out.println(reviewManager.getMovie(movieName, director).getReview());
                        } else {
                            System.out.print("Movie not found. Please try again\n");
                        }

                        break;

                    case 'E': // Search for a Movie Genre
                        System.out.print("Please enter the movie genre to search:\n");
                        movieGenre = stdin.readLine().trim();

                        try {
                            // search for all the movies in the database that have the given genre
                            ArrayList<Movie> movies = reviewManager.getMoviesByGenre(movieGenre);
                            // print the movies
                            System.out.print(movies.size() + " Movies matching " + movieGenre + " type were found:\n");
                            for (Movie movie : movies) {
                                System.out.print(movie);
                            }

                        } catch (NullPointerException e) {
                            System.out.print("Movie genre not found. Please try again\n");
                        }

                        break;

                    case 'L': // List movie's reviews
                        // lsit the reviews in the database without having it in an array
                        System.out.print("\n" + reviewManager.listReviews() + "\n");

                        break;

                    // Complete the code by adding two cases: case 'N': sorts the movie reviews by
                    // rating and prints "sorted by rating\n" case 'P': sorts the movie reviews by
                    // movie genre and prints "sorted by genre\n"

                    case 'N': // sorts the movie reviews by rating and prints "sorted by rating\n"
                        reviewManager.sortByRating();
                        System.out.print("sorted by rating\n");
                        break;

                    case 'P': // sorts the movie reviews by movie genre and prints "sorted by genre\n"
                        reviewManager.sortByGenre();
                        System.out.print("sorted by genre\n");
                        break;

                    case 'Q': // Quit
                        reviewManager.closeReviewManager();
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the name of the movie for which you want the review removed:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie's director:\n");
                        director = stdin.readLine().trim();

                        // Complete the code. If a review for a certain movie directed by the given
                        // director is found, remove the review and print that it was removed. Otherwise
                        // print that it was NOT removed.
                        int doesMovieExists = reviewManager.movieExists(movieName, director);
                        if (doesMovieExists != -1) {
                            reviewManager.removeReview(movieName, director);
                            System.out.print(movieName + ", " + director + " was removed\n");
                        } else {
                            System.out.print(movieName + ", " + director + " was NOT removed\n");
                        }

                        break;

                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("The movie management system was reset!\n");
                        break;

                    case 'U': // Write movies' names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie:\n");
                        movieName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = movieName + "\n" + review + "\n";

                        // Add a try and catch block to write the string outMsg into the user-specified
                        // file Then, print on the screen that the file " is written\n" In case of an IO
                        // Exception, print "Write string inside the file error\n"
                        try {
                            BufferedWriter out = new BufferedWriter(new BufferedWriter(new FileWriter(outFilename)));
                            out.write(outMsg);
                            out.close();
                            System.out.print(outFilename + " is written\n");
                        } catch (IOException e) {
                            System.out.print("Write string inside the file error\n");
                        }
                        break;

                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();

                        // Add a try and catch block to read from the above text file. Confirm that the
                        // file " was read\n" and then print "The contents of the file are:\n" followed
                        // by the contents In case of an IO Exception, print "Read string from file
                        // error\n" In case of a file not found exception, print that the file " was not
                        // found\n"

                        try {
                            BufferedReader in = new BufferedReader(new FileReader(inFilename));
                            String str;
                            System.out.print(inFilename + " was read\n");
                            System.out.print("The contents of the file are:\n");
                            while ((str = in.readLine()) != null) {
                                System.out.println(str);
                            }
                            System.out.println();
                            in.close();
                        } catch (IOException e) {
                            System.out.print(inFilename + " was not found\n");
                        }
                        break;

                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();

                        // Add a try and catch block to serialize ReviewManager to a data file. Catch
                        // two exceptions and print the corresponding messages on the screen: "Not
                        // serializable exception\n" "Data file written exception\n"

                        try {
                            FileOutputStream fileOut = new FileOutputStream(outFilename);
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(reviewManager);
                            out.close();
                            fileOut.close();
                            // System.out.println("Serialized data is saved in " + outFilename);
                        } catch (NotSerializableException e) {
                            System.out.print("Not serializable exception\n");
                        } catch (IOException e) {
                            System.out.print("Data file written exception\n");
                        }
                        break;

                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();

                        // Add a try and catch block to deserialize ReviewManager from a data file.
                        // Catch three exceptions and print the corresponding messages on the screen:
                        // "Class not found exception\n" "Not serializable exception\n" "Data file read
                        // exception\n"
                        try {
                            FileInputStream fileIn = new FileInputStream(inFilename);
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            reviewManager = (ReviewManager) in.readObject();
                            in.close();
                            fileIn.close();
                            System.out.print(inFilename + " was read\n");
                        } catch (ClassNotFoundException e) {
                            System.out.print("Class not found exception\n");
                        } catch (NotSerializableException e) {
                            System.out.print("Not serializable exception\n");
                        } catch (IOException e) {
                            System.out.print("Data file read exception\n");
                        }
                        break;

                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        } catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to YoMovies! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) movies.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a movie\n" + "E\t\tSearch for a genre\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by genre\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
}
