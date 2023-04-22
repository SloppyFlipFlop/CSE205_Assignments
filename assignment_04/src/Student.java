/* 
 * Assignment #: 4
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The Student class allows for the creation of students within this program.
*/

public class Student {

  private int id; // a inclusive string variable for the student class that's for the student's
                  // "id"
  private String major; // a inclusive string variable for the student class that's for the student's
                        // "major"
  private Course course; // a inclusive string variable for the student class that's for the student's
                         // "course"
                         // this variable is a object of the course object class

  public Student() {
    /*
     * In this public function, It sets the String varibales of the private
     * variables: "id, major"
     * within the Student class as "?". But also sets the course variable as the
     * defualt Course object state.
     */
    id = 0;
    major = "?";
    course = new Course();
  }

  public Student(int initID, String initMajor, Course initCourse) {
    /*
     * This function allows the user to set the inital state of the Student
     * variables to be what the user wants. As long as the values still follow the
     * requirement of the "id" and "major" being Strings and the course varibale
     * being a Course object of three inputs of "courseID", "instructor", and
     * "subject"(ALL STRINGS)
     */
    id = initID;
    major = initMajor;
    course = initCourse;
  }

  // getters
  public int getID() {
    /*
     * returns the value stored in the variable "id" for this instance of
     * student
     */
    return id;
  }

  public String getSubject() {
    /*
     * returns the value stored in the variable "subject" for this instance of
     * student
     */
    return major;
  }

  public Course getCourse() {
    /*
     * returns the value stored in the variable "course" for this instance of
     * student
     */
    return course;
  }

  // setters
  public void setID(int newID) {
    /*
     * updates the "id" variable for this intance of student to the new id put in by
     * the user
     */
    id = newID;
  }

  public void setSubject(String newSubject) {
    /*
     * updates the "subject" variable for this intance of student to the new subject
     * put in by
     * the user
     */
    major = newSubject;
  }

  public void setCourse(int courseID, String instructor, String subject) {
    /*
     * updates the "course" object variable for this intance of student to a new
     * course object with variables put in by
     * the user
     */
    course = new Course(courseID, instructor, subject);
  }

  // others

  public String toString() {
    /*
     * return a String of the student information
     */
    String output = "\nStudent information:" + "\nStudent Id:\t" + id + "\nMajor:\t\t" + major + "\n";
    return output;
  }

}
