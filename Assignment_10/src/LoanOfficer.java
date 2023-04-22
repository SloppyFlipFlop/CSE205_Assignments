/* 
 * Assignment #: 10
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class represents loan officers and data about them.
 */

public class LoanOfficer {
   private int officerID;
   private Customer currentCustomer;

   // **************************************************
   // Constructor to initialize member variables
   // Initially, no customer is assigned
   public LoanOfficer(int id) {
      this.officerID = id;
      currentCustomer = null;
   }

   // ******************************************
   // an accessor method for the officer's ID
   public int getID() {
      return officerID;
   }

   // ****************************************************************
   // this method checks to see if the loanOfficer currently has a customer or not
   public boolean hasCustomer() {
      if (currentCustomer == null)
         return false;
      else
         return true;

   }

   // ************************************************************************
   // this method assigns the given customer to this loan officer
   public boolean assignCustomer(Customer customer1) {
      if (currentCustomer == null) {
         currentCustomer = customer1;
         return true;
      } else
         return false;
   }

   // *********************************************
   // this method releases the current customer from this loan officer and returns
   // it
   // But if there is no customer, this method returns null
   public Customer handleCustomer() {
      if (currentCustomer == null)
         return null;
      else {
         Customer assignedCustomer = currentCustomer;
         this.currentCustomer = null;
         return assignedCustomer;
      }
   }

   // ********************************************
   // toString method returns a string containing
   // the information of a loanOfficer
   public String toString() {
      String result = "\nOfficer ID: " + officerID;

      if (currentCustomer == null)
         result += " does not have any cutomers\n";
      else
         result += " is serving customer with id " + currentCustomer.getCustID() + "\n";

      return result;
   }
}