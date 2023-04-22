/* 
 * Assignment #: 9
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This is the Playlist class for Assignment 9. It contains the methods for the Playlist class. 
*/

public class Playlist {
    String name;
    Song first;

    // constructors
    public Playlist() {
        name = "library";
        first = Song.END;
    }

    public Playlist(String name) {
        this.name = name;
        first = Song.END;
    }

    // getters

    public String getName() { // returns the name of the playlist
        return name;
    }

    // The size() calculates the number of songs in a playlist (Note: DO NOT use an
    // instance variable to store the size. Calculate the size on-the-fly)
    public int size() {
        int size = 0;
        Song current = first;
        while (current != Song.END) {
            size++;
            current = current.next;
        }
        return size;
    }

    // The removeFirst() method removes the first song on the playlist (so that the
    // next song can begin playing). Return the removed song. (Note: DO NOT return
    // null when there are no songs in the playlist, instead return Song.END).
    public Song removeFirst() {
        Song removed = first;
        first = first.next;
        if (removed == Song.END)
            return Song.END;
        return removed;
    }

    // This method removes a song from the playlist with given Song object
    public int remove(Song song) {
        // else if the song is in the playlist, the song is removed and the method
        // returns the position
        // of the song in the playlist before it was removed.
        int position = getPosition(song);
        Song current = first;
        Song previous = Song.END;
        while (current != Song.END) {
            if (current.equals(song)) {
                if (previous == Song.END) {
                    first = current.next;
                    return position;
                }
                previous.next = current.next;
                return position;
            }
            previous = current;
            current = current.next;
        }
        return -1;
    }

    // this method returns the first song in the playlist
    public Song head() {
        return first;
    }

    // This method gets the position of the given song in the playlist
    public int getPosition(Song song) {
        Song current = first;
        int position = 0;
        while (current != Song.END) {
            if (current.equals(song))
                return position;
            current = current.next;
            position++;
        }
        return -1;
    }

    // refctor this method to use recursion

    // this method lists all the songs in the playlist in String format. Along with
    // the size of the playlist at the end of the string.
    public String listSongs() {
        if (first == Song.END)
            return "No songs in playlist";

        String list = "";
        Song current = first;
        while (current != Song.END) {
            list += current.toString() + "\n";
            current = current.next;
        }
        list += "\nTotal songs: " + size() + ".";
        return list;

    }

    // A recurive version of the listSongs() method
    // public String listSongs() {
    // if (first == Song.END)
    // return "No songs in playlist";

    // String list = "";
    // Song current = first;
    // list = getToString(current);
    // list += "\nTotal songs: " + size() + ".";
    // return list;
    // }

    // private String getToString(Song current) {
    // if (current == Song.END)
    // return "";
    // return current.toString() + "\n" + getToString(current.next);
    // }

    // setters

    // This method adds a song to the end of the playlist
    public void add(Song song) {
        if (first == Song.END) {
            first = song;
            return;
        }
        Song current = first;
        while (current.next != Song.END) {
            current = current.next;
        }
        current.next = song;
    }

}
