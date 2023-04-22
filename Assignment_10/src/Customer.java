/* 
 * Assignment #: 10
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class represents a customer and data about them.
 */
public class Customer
{
    private int custID;
    private String category;

    //Constructor to initialize member variables
    public Customer(int custID, String category)
    {
        this.custID = custID;
        this.category = category;
    }

    //Accessor method to access its custID
    public int getCustID()
    {
        return custID;
    }

    //Accessor method to access its category
    public String getCategory()
    {
        return category;
    }

    //toString method returns a string containing
    //the information of a customer
    public String toString( )
    {
        String result = "Cust.ID: " + custID
                + "(" + category + ")";
        return result;
    }
}