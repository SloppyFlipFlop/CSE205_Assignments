/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class is used as the Movie's gerne object class. It is used to store the movie's genre and production company. Also allows for the genre to be converted to a string.
*/

import java.io.Serializable;


public class MovieGenre implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String genre;
    private String productionCompany;

    public MovieGenre(String genre, String productionCompany) {
        this.genre = genre;
        this.productionCompany = productionCompany;
    }

    // getter
    // The following method is used to get the value of the instance variable "genre"
    public String getGenre() {
        return genre;
    }

    // The following is a override "toString" method used to get the stringify this instance of MovieGenre variables
    @Override
    public String toString() {
        return genre + " Movie\n" +
                "Production Company:\t" + productionCompany + '\n';
    }
}

