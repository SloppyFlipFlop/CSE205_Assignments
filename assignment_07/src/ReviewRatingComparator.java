/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class will be used to compare two movies by initialy their difference in star ranking. Then follow the hierarchy of the folllowing attributes: Stars, Movie name, Movie director, then Review. At any point if the attributes are the same, then it will return 0. else it will return the difference of the two attributes.
*/

import java.util.Comparator;

public class ReviewRatingComparator implements Comparator<Movie> {
    
    @Override
    public int compare(Movie movie1, Movie movie2) {
        /*
         * This override compare method is used to compare two movies by their movie star rankings. But if their star ranking are the same, then it will compare the
         * movies by their name(by which movie comes earlier in alphabetical order). If
         * their names are the same, then it will compare the movies by their
         * director(in alphabetical order). If their director's name are the same, then
         * it will compare the movies by their review(in alphabetical order). If their
         * reviews are the same, then it will return 0.
         */

        int starCompare = movie1.getStars() - movie2.getStars();
        if (starCompare != 0) return starCompare;
        
        int nameCompare = movie1.getMovieName().compareTo(movie2.getMovieName());
        if (nameCompare != 0) return nameCompare;
        
        int directorCompare = movie1.getDirector().compareTo(movie2.getDirector());
        if (directorCompare != 0) return directorCompare;
        
        int reviewCompare = movie1.getReview().compareTo(movie2.getReview());
        return reviewCompare;

    }
}
