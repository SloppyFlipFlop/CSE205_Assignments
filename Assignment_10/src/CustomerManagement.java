/* 
 * Assignment #: 10
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class represents a customer management system for a bank.
*/

import java.util.LinkedList;

public class CustomerManagement {
   private LinkedList<Customer> LEQueue;
   private LinkedList<Customer> MEQueue;
   private LinkedList<Customer> SEQueue;

   private LinkedList<Customer> checkoutQueue;

   private LoanOfficer[] officerList;

   // **********************************************
   // Constructor
   public CustomerManagement(int numOfLoanOfficers) {
      LEQueue = new LinkedList<Customer>();
      MEQueue = new LinkedList<Customer>();
      SEQueue = new LinkedList<Customer>();
      checkoutQueue = new LinkedList<Customer>();

      // creating LoanOfficer objects
      officerList = new LoanOfficer[numOfLoanOfficers];
      for (int i = 0; i < officerList.length; i++) {
         officerList[i] = new LoanOfficer(i);
      }
   }

   // *******************************************************************
   // This method adds a customer to a corresponding queue based on its category

   boolean addCustomer(int id, String category) { // return true if added to a queue successfully; otherwise return
                                                  // false

      Customer newCustomer = new Customer(id, category);

      if (category.equals("LE")) {
         LEQueue.add(newCustomer);
         return true;
      } else if (category.equals("ME")) {
         MEQueue.add(newCustomer);
         return true;
      } else if (category.equals("SE")) {
         SEQueue.add(newCustomer);
         return true;
      } else
         return false;
   }

   // *******************************************************************
   // This method assigns a customer to a loan officer with large enterprise (LE) queues
   // going first, then medium enterprise (ME) queues, and then small enterprise (SE) queues last.
   Customer assignCustomerToLoanOfficer() { // return null if there are no customers in the queues or if
      // there are no loan officers available

      for (int i = 0; i < officerList.length; i++) {
         LoanOfficer currentOfficer = officerList[i];

         if (currentOfficer.hasCustomer() == false) {
            Customer assignedCustomer;
            if (LEQueue.size() > 0) {
               assignedCustomer = LEQueue.remove();
            } else if (MEQueue.size() > 0) {
               assignedCustomer = MEQueue.remove();
            } else if (SEQueue.size() > 0) {
               assignedCustomer = SEQueue.remove();
            } else
               return null;

            currentOfficer.assignCustomer(assignedCustomer);
            return assignedCustomer;
         }
      }
      return null;
   }

   // ***************************************************************
   // This method checks if a given loan officer has a customer and if they do, it'll release
   // that customer from them. Then the method adds that customer to the checkout queue
   // and return the Customer object. otherwise return null
   Customer releaseCustomerFromOfficer(int officerID) {

      if (officerID < 0 || officerID > officerList.length - 1) {
         return null;
      } else if (officerList[officerID].hasCustomer()) {
         Customer releasedCustomer = officerList[officerID].handleCustomer();
         checkoutQueue.add(releasedCustomer);
         return releasedCustomer;
      } else
         return null;

   }

   // **************************************************************
   // This method removes the next customer from the checkout queue and returns it.
   // If the checkout queue is empty, this method returns null.
   public Customer checkoutCustomer() {
      if (checkoutQueue.size() > 0) {
         return checkoutQueue.remove();
      } else
         return null;
   }

   // ************************************************
   // This method prints out the queues and the loan officers
   public void printQueues() {
      System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
      System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
      System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
      for (int i = 0; i < officerList.length; i++) {
         System.out.print(officerList[i].toString());
      }
      System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
   }
}