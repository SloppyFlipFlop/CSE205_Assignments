/* 
 * Assignment #: 9
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This is the main class for Assignment 9. It contains the main method and
 * the menu for the program.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Assignment9 {

    // This method parses the song title and artist from the input.
    private static Song parseSong(String[] input) {
        String title = "";
        int i = 0;
        for (; i < input.length; i++) {
            if (input[i + 1].equals("by")) {
                title += input[i];
                continue;
            } else if (input[i].equals("by")) {
                i++;
                break;
            }
            title += input[i] + " ";
        }
        String artist = "";
        for (; i < input.length - 1; i++) {
            artist += input[i] + " ";
        }
        artist += input[input.length - 1];
        Song song = new Song(title, artist);
        return song;
    }

    // this method finds a playlist with the given name in the given list of
    // playlists aka library.
    private static Playlist findPlaylist(String name,
            ArrayList<Playlist> playlists) {
        // A hashmap would be handy here...
        // but for simplicity we will refrain from using it.
        for (Playlist p : playlists) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        // No playlist found.
        return null;
    }

    // This method prints the menu for the program and allows the user to select an
    // option.
    public static void main(String[] args) throws IOException {

        // Probably makes more sense to use a hashmap, but let's not complica-
        // e things more than needed.
        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist());

        // Keep track of the current playlist.
        Playlist currentPlaylist = playlists.get(0);

        // Print out the menu
        System.out.println("Welcome to AStUnes!");
        System.out.println("===================");
        printMenu();

        /*
         * Gabe i love you - sqrt(cos(x))*cos(300x)+sqrt(abs(x))-0.7)*(4-x*x)^0.01,
         * sqrt(6-x^2), -sqrt(6-x^2) from -4.5 to 4.5
         */

        // Create a BufferedReader object to read input from a keyboard
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        do {
            line = stdin.readLine();
            String[] input = line.split(" ");
            Song song = null;
            switch (input[0]) {
                case "add": // Add to current playlist
                    song = parseSong(
                            Arrays.copyOfRange(input, 1, input.length));
                    currentPlaylist.add(song);
                    System.out.printf("Successfully added %s\n", song);
                    break;
                case "new": // Create a new playlist
                    Playlist playlist = new Playlist(input[1]);
                    playlists.add(playlist);
                    System.out.printf("Creating playlist %s\n", input[1]);
                    currentPlaylist = playlist;
                    System.out.printf("Switched to %s\n", input[1]);
                    break;
                case "count": // Count songs in current playlist
                    System.out.printf(
                            "The current playlist %s has %d songs.\n",
                            currentPlaylist.getName(), currentPlaylist.size());
                    break;
                case "position": // Get position of song in current playlist
                    song = parseSong(
                            Arrays.copyOfRange(input, 1, input.length));
                    int result = currentPlaylist.getPosition(song);
                    if (result == -1) {
                        System.out.printf("%s is not in the playlist.\n", song);
                    } else {
                        System.out.printf(
                                "%s song is located at position %d in %s\n",
                                song, result + 1, currentPlaylist.getName());
                    }
                    break;
                case "remove": // Remove song from current playlist
                    song = parseSong(
                            Arrays.copyOfRange(input, 1, input.length));
                    int index = currentPlaylist.remove(song);
                    if (index == -1) {
                        System.out.println("Song not found.\n");
                    } else {
                        System.out.printf(
                                "Removed %s (at position %d) from %s.\n",
                                song, index + 1, currentPlaylist.getName());
                    }
                    break;
                case "switch": // Switch to another playlist
                    Playlist prev = currentPlaylist;
                    currentPlaylist = findPlaylist(input[1], playlists);
                    System.out.printf(
                            "Switched from playist %s to playlist %s",
                            prev.getName(), currentPlaylist.getName());
                    break;
                case "pop": // Remove current song, switch to next song in playlist.
                    if (currentPlaylist.head() == Song.END) {
                        System.out.printf(
                                "No songs currently in playlist %s.\n",
                                currentPlaylist.getName());
                        break;
                    }
                    Song current = currentPlaylist.removeFirst();
                    if (currentPlaylist.head() == Song.END) {
                        System.out.printf(
                                "Finished %s.\n" +
                                        "No songs currently in playlist %s.\n",
                                current, currentPlaylist.getName());
                    } else {
                        System.out.printf("Finished: %s.\nNow playing: %s\n",
                                current, currentPlaylist.head());
                    }
                    break;
                case "songs": // Print out all songs in current playlist.
                    System.out.println("\n" + currentPlaylist.listSongs());
                    break;
                case "playlists": // Print out all playlists.
                    if (playlists.size() == 0) {
                        System.out.println("No playlists found.");
                    } else {
                        for (Playlist p : playlists) {
                            System.out.println(p.getName());
                        }
                    }
                    break;
                case "help":
                    printMenu();
                    break;
                case "sus":

                    System.out.println("https://s3.ap-southeast-1.amazonaws.com/cdn.vcgamers.com/news/wp-content/uploads/2022/12/Meme-Amogus.png");

                    // make a game for the sus command
                    // make a pong game for the sus command (or the game is twhat we make for this game is they game is teh hjfhskjf thhe game is of the game is fuck you game is the function of the function)

                    break;
                case "quit": // Need to prevent default form executing.
                    break;
                default:
                    System.out.print("Unknown action\n");
                    break;
            }
        } while (!line.equals("quit"));
        stdin.close();
    }

    private static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "add\t\tAdds a song to the current playlist\n" +
                "count\t\tCounts the number of songs in a playlist\n" +
                "position\tGets the position of a song in a playlist\n" +
                "remove\t\tRemove a song from the playlist\n" +
                "new\t\t\tCreate a new playlist\n" +
                "switch\t\tSwitch to another playlist\n" +
                "pop\t\t\tFinish and remove the first song from the playlist\n" +
                "songs\t\tList the songs in the current playlist\n" +
                "playlists\tList the playlists\n" +
                "stack\t\tStack a playlist onto another\n" +
                "interleave\tInterleave two playlists\n" +
                "quit\t\tQuit the program\n" +
                "help\t\tDisplay Help\n\n");
    }
}
