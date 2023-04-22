/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class is used to manage the movies in the reviewList and carry out the different operations that the user wants to do with the movies's reviewList.
*/

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    private ArrayList<Movie> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }

    public int movieExists(String movieName, String directorName) {
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getMovieName().equals(movieName)
                    && reviewList.get(i).getDirector().equals(directorName)) {
                return i;
            }
        }
        return -1;
    }


    // this method will return an arraylist of the indexes of the movies that have the same genre has the given genre
    public ArrayList<Integer> movieGenreExists(String movieGenre) {
        ArrayList<Integer> movieGenreList = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getMovieGenre().getGenre().equals(movieGenre)) {
                movieGenreList.add(i);
            }
        }
        if (movieGenreList.size() == 0)
            return null;
        return movieGenreList;
    }

    // getter methods

    // The following method is used to get a movie object with the given movie name and director name
    public Movie getMovie(String movieName, String director) {
        int index = movieExists(movieName, director);
        if (index != -1) {
            return reviewList.get(index);
        }
        return null;
    }

    // the following method is used to get a array of movie objects with the given genre
    public ArrayList<Movie> getMoviesByGenre(String genre) {
        ArrayList<Movie> moviesByGenre = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getMovieGenre().getGenre().equals(genre)) {
                moviesByGenre.add(reviewList.get(i));
            }
        }
        if (moviesByGenre.size() == 0)
            return null;
        return moviesByGenre;
    }

    /**
     * Add a Movie object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two Movies are
     * considered duplicates if they have the exact same movie name and genre.
     * 
     * @param movieName         the name of the movie
     * @param stars             the number of stars the movie received
     * @param review            the movie review
     * @param totalCollection   the integer total collection earned by the movie
     * @param genre             the movie's genre
     * @param director          the movie's director
     * @param prodictionCompany production comapny of the movie
     * @return true if the operation is successful; false otherwise
     */

    // Adds a movie review to the reviewList
    public boolean addReview(String movieName, int stars, String review, String totalCollection, String genre,
            String director, String productionCompany) {
        if (movieExists(movieName, director) == -1) {
            int collection = totalCollection.length();
            MovieGenre newGenre = new MovieGenre(genre, productionCompany);
            Movie newMovie = new Movie(movieName, stars, review, collection, director, newGenre);
            reviewList.add(newMovie);
            return true;
        }
        return false;
    }

    // the following method is used to remove a movie object from the reviewList
    public boolean removeReview(String movieName, String directorName) {
        int index = movieExists(movieName, directorName);
        if (index != -1) {
            reviewList.remove(index);
            return true;
        }
        return false;
    }

    public void sortByRating() {
        // This method sorts the reviewList by star rankings and then the movie name in
        // alphabetical order.
        // The method calls the sort method in the Sorts class by using an object
        // generated from the ReviewRatingComparator class.
        Sorts.sort(reviewList, new ReviewRatingComparator());
    }

    public void sortByGenre() {
        // This method sorts the reviewList by movie genre in alphabetical order of the
        // genre, then
        // the movie name. The method calls the sort method defined in the Sorts class
        // by using an object generated from the ReviewMovieGenreComparator class.
        Sorts.sort(reviewList, new ReviewMovieGenreComparator());
    }

    public String listReviews() {
        // returns a list of all the movie objects in reviewList. If no reviews are
        // available, the method
        // returns a message that the list is empty.
        String list = "";
        if (reviewList.size() == 0) {
            list = "No Reviews available";
        } else {
            for (int i = 0; i < reviewList.size(); i++) {
                list += reviewList.get(i).toString();
            }
        }
        return list;
    }

    public void closeReviewManager() {
        // Close the Movie management system by clearing the reviewList.
        reviewList.clear();
    }

}
