/* 
 * Assignment #: 11
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: 
*/

public class Game {
    // Declare instance variables
    private String name;
    private String description;
    private double price;
    private int downloads;

    // Define constructor
    public Game(String name, String description, double price, int downloads) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.downloads = downloads;
    }

    // Define accessor methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getDownloads() {
        return downloads;
    }

    // Define string representation of Game objects
    @Override
    public String toString() {
        return name + "\n" + description + "\nZyBox Price: $" + String.format("%.2f", price) + "\n" + downloads
                + " downloads\n";
    }
}