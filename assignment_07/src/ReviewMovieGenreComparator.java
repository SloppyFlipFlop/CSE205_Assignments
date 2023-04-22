/* 
 * Assignment #: 7
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The following class is used to compare two movies by their movie genre. But if their movie genres are the same, then it will compare the movies by their total movie collection(movie earnings). If their total collections are the same, then it will compare the movies by their names(in alphabetical order). If their names are the same, then it will compare the movies by their director's name(in alphabetical order). If their director's name are the same, then it will compare the movies by their review(in alphabetical order). If their reviews are the same, then it will return 0.
*/


import java.util.Comparator;

public class ReviewMovieGenreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        /*
         * This override compare method is used to compare two movies by their movie
         * eenre. But if their movie genres are the same, then it will compare the
         * movies by their total movie collection(movie earnings). If
         * their total collections are the same, then it will compare the movies by
         * their
         * names(in alphabetical order). If their names are the same, then
         * it will compare the movies by their director's name(in alphabetical order).
         * If their
         * director's name are the same, then it will compare the movies by their
         * review(in alphabetical order). If their reviews are the same, then it will
         * return 0.
         */

        int genreCompare = movie1.getMovieGenre().getGenre().compareTo(movie2.getMovieGenre().getGenre());
        if (genreCompare != 0)
            return genreCompare;

        int collectionCompare = movie1.getTotalCollection() - movie2.getTotalCollection();
        if (collectionCompare != 0)
            return collectionCompare;

        int nameCompare = movie1.getMovieName().compareTo(movie2.getMovieName());
        if (nameCompare != 0)
            return nameCompare;

        int directorCompare = movie1.getDirector().compareTo(movie2.getDirector());
        if (directorCompare != 0)
            return directorCompare;

        int reviewCompare = movie1.getReview().compareTo(movie2.getReview());
        return reviewCompare;

    }
}