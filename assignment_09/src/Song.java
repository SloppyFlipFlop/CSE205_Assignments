/* 
 * Assignment #: 9
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class contains the methods for the Song class. In which it contains the Song object and the Song constructor for getting the title and artist of the song. Along with getting the next song in the playlist.
*/

public class Song {
    private String title;
    private String artist;
    public Song next;
    public static final Song END = new Song();

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        next = END;
    }

    // This is used to construct the END Table.
    private Song() {
        title = "";
        artist = "";
        next = this;
    }

    //setters
    // This method returns the position of a song in the playlist.
    public boolean equals(Song other) {
        if (this.title.equals(other.title)
                && this.artist.equals(other.artist))
            return true;
        return false;
    }

    // getters
    // returns a string representation of the song
    public String toString() {
        return "Title: " + title + "\tArtist: " + artist;
    }
}
