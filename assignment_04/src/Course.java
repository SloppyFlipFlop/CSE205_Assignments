/* 
 * Assignment #: 4
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The Course class allows for the creation of courses within this program.
*/

public class Course {

  // golbal variables for the Course class only, will be private for anything
  // outside of the class to access.
  private int courseID;

  private String instructor;

  private String subject;

  public Course() {
    /*
     * default values for the given variables within the course class
     */
    this.courseID = 0;
    this.instructor = "?";
    this.subject = "?";
  }

  public Course(int initCourseID, String initInstructor) {
    this.courseID = initCourseID;
    this.instructor = initInstructor;
    this.subject = "Math";
  }

  public Course(int initCourseID, String initInstructor, String initSubject) {
    this.courseID = initCourseID;
    this.instructor = initInstructor;
    this.subject = initSubject;
  }

  // getters

  public int getCourseID() {
    /*
     * Return this inatnce of course's id
     */
    return courseID;
  }

  public String getInstructor() {
    /*
     * returns this intance of the object course's instructor
     */
    return instructor;
  }

  public String getSubject() {
    /*
     * returns this intance of the course object's subject variable
     */
    return subject;
  }

  // setters

  public void setCourseId(int newCourseId) {
    /*
     * this local public function allows for the "courseID" variable to be
     * overwritten
     */
    courseID = newCourseId;
  }

  public void setInstructor(String newInstructor) {
    /*
     * this local public function allows for the "instructor" variable to be
     * overwritten
     */
    instructor = newInstructor;
  }

  public void setSubject(String newSubject) {
    /*
     * this local public function allows for the "subject" variable to be
     * overwritten
     */
    subject = newSubject;
  }

  public String toString() {
    /*
     * returns a string verison of the course information
     */
    String stringOutput = "\nCourse information:" + "\nCourse ID:\t"
        + courseID + "\nInstructor:\t" + instructor
        + "\nSubject:\t" + subject + "\n";
    return stringOutput;
  }
}
