/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class is used to create a movie object that will be used to store the information of a movie
*/

import java.io.Serializable;

public class Movie implements Serializable {

    protected final long serialVersionUID = 205L;
    protected String movieName;
    protected int stars;
    protected String review;
    protected int totalCollection;
    protected String director;
    protected MovieGenre movieGenre;

    public Movie(String movieName, int initRating, String initReview, int totalCollection, String director,
        MovieGenre movieGenre) {
        this.movieName = movieName;
        this.stars = initRating;
        this.review = initReview;
        this.totalCollection = totalCollection;
        this.director = director;
        this.movieGenre = movieGenre;
    }

    // getters

    /*
     * The following methods are used to get the value of the instance variables
     */
    public String getMovieName() {
        return this.movieName;
    }

    public int getStars() {
        return this.stars;
    }

    public int getTotalCollection() {
        return this.totalCollection;
    }

    public String getDirector() {
        return this.director;
    }

    public String getReview() {
        return this.review;
    }

    public MovieGenre getMovieGenre() {
        return this.movieGenre;
    }

    // a method to convert the dollar value to a string representation of "$" the value of the movie's total collection
    private String convertToStringDollarRepresentive(int value) {
        String stringRepresentation = "";
        for (int i = 0; i < value; i++) {
            stringRepresentation += "$";
        }
        return stringRepresentation;
    }

    // a method to convert the star value to a string representation of "*" the value of the movie's star rating
    private String convertToStringStarRepresentive(int value) {
        String starRepresentation = "";
        for (int i = 0; i < value; i++) {
            starRepresentation += "*";
        }
        return starRepresentation;
    }

    // for this graded project, we the value passed in is either a star or a dollar value
    // we also know that the value for star is always going to be less than 5 and any value greater the 5 is a dollar value
    // So with that knowledge, we can use a conditional statement to check if the value is greater than 5, if it is, then we can convert the value to a dollar value representation
    public String toStringRepresentive(int value) {
        String stringRepresentation = "";
        if (value > 5) {
            stringRepresentation = convertToStringDollarRepresentive(value);
        } else {
            stringRepresentation = convertToStringStarRepresentive(value);
        }
        return stringRepresentation;
    }

    // The following method is used to convert the this inatnce of the movie object to a string representation
    public String toString() {
        String stringOutput = this.getMovieName() + " Movie\n" 
                + convertToStringStarRepresentive(this.getStars()) + "\n"
                + "Total Collection earned: "
                + convertToStringDollarRepresentive(this.getTotalCollection()) + "\n" + getMovieGenre().toString()

                + "Director: " + this.getDirector() + "\n"
                + "Review:\t" + this.getReview() + "\n\n";

        return stringOutput;
    }
}
