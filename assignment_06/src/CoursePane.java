/* 
 * Assignment #: 5
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This class represents the GUI components for a course pane. It allows users to add and remove courses to a course list and display the list to see.
*/

//Note: when you submit on gradescope, you need to comment out the package line
//package yourPackageName;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

import javax.swing.JList.DropLocation;

public class CoursePane extends HBox {
    // GUI components
    private ArrayList<Course> courseList;
    private ArrayList<Course> dropCourseList;
    private VBox checkboxContainer;

    private int courseCount = 0;
    private Label numCourses;

    // constructor
    public CoursePane() {

        // creates the course list
        courseList = new ArrayList<Course>();

        // creates the drop course list
        dropCourseList = new ArrayList<Course>();


        // makes the left pane that will contain all the course information input sections
        BorderPane leftPane = new BorderPane();
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setStyle("-fx-border-color: black");


        // creates the title for the left pane
        Label labelLeft = new Label("Add Course(s)");// leftPane title
        labelLeft.setAlignment(Pos.CENTER_LEFT);
        labelLeft.setTextFill(Color.BLUE);
        labelLeft.setFont(Font.font(null, 14));
        leftPane.setTop(labelLeft);

        // creates the bottom label for the left pane
        Label bottomLabel = new Label("No course entered");
        bottomLabel.setFont(Font.font(null, 14));
        leftPane.setBottom(bottomLabel);
        
        // creates the center content for the left pane, which will contain all the input sections
        VBox leftPaneContent = new VBox();

        leftPaneContent.setSpacing(30);

        leftPaneContent.setAlignment(Pos.CENTER);

        leftPane.setCenter(leftPaneContent);

        HBox subjectBox = new HBox();
        subjectBox.setSpacing(10);
        Label subjectLabel = new Label("Subject");

        subjectBox.setSpacing(40);

        subjectLabel.setAlignment(Pos.CENTER_LEFT);

        HBox subjectMenuBox = new HBox();
        ComboBox<String> subjectMenu = new ComboBox<String>();
        subjectMenu.getItems().addAll("ACC", "AME", "BME", "CHEM", "CSE", "DAT", "EEE");
        subjectMenu.setValue("CSE");
        subjectMenuBox.getChildren().add(subjectMenu);

        subjectBox.getChildren().addAll(subjectLabel, subjectMenu);

        leftPaneContent.getChildren().add(subjectBox);

        // make a text input field for the course number
        HBox courseNumBox = new HBox();
        courseNumBox.setSpacing(10);
        Label courseNumLabel = new Label("Course Num");
        courseNumLabel.setAlignment(Pos.CENTER_LEFT);

        // make a text input field for the course number
        TextField courseNumField = new TextField();

        courseNumBox.getChildren().addAll(courseNumLabel, courseNumField);
        leftPaneContent.getChildren().add(courseNumBox);

        HBox instructorBox = new HBox();
        instructorBox.setSpacing(26);
        // instructorBox.setSpacing(10);
        Label instructorLabel = new Label("Instructor");
        // instructorLabel.setAlignment(Pos.CENTER_LEFT);
        // make a text input field for the instructor
        TextField instructorField = new TextField();
        // instructorField.setAlignment(Pos.CENTER_RIGHT);

        instructorBox.getChildren().addAll(instructorLabel, instructorField);
        leftPaneContent.getChildren().add(instructorBox);

        // Center Pane Code

        VBox centerPane = new VBox();
        centerPane.setPadding(new Insets(10, 10, 10, 10));
        centerPane.setSpacing(50);
        centerPane.setAlignment(Pos.CENTER);

        // add button
        Button addButton = new Button("Add");

        // when the add button is clicked, the course will be added  to the courselist
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // get the subject from the drop down menu
                String subject = subjectMenu.getValue();
                // get the course number from the text field and convert it to an int
                String courseNum = courseNumField.getText();
                // get the instructor from the text field
                String instructor = instructorField.getText();

                bottomLabel.setText("Course added successfully");
                bottomLabel.setTextFill(Color.BLACK);

                // if the data from courseNum and instructor is non existent, then update
                // bottomLabel to say "Invalid Input"
                if (courseNumField.getText().equals("") || instructorField.getText().equals("")) {
                    bottomLabel.setText("At least one field is empty, Fill all fields");
                    bottomLabel.setTextFill(Color.RED);

                    // make the textfields that are empty red
                    if (courseNumField.getText().equals("")) {
                        courseNumField.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
                    } else {
                        courseNumField.setStyle("-fx-text-box-border: black ; -fx-focus-color: black ;");
                    }

                    if (instructorField.getText().equals("")) {
                        instructorField.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
                    } else {
                        instructorField.setStyle("-fx-text-box-border: black ; -fx-focus-color: black ;");
                    }
                    return;
                }

                // checks to make sure that only numbers are entered into the courseNumField
                int courseNumInt;

                try {
                    courseNumInt = Integer.parseInt(courseNum);
                } catch (NumberFormatException e) {
                    bottomLabel.setText("Error! Course number must be an integer");
                    bottomLabel.setTextFill(Color.RED);
                    return;
                }

                // int courseNumInt = Integer.parseInt(courseNum);

                // boolean courseExists = false;

                Course newCourse = new Course(subject, courseNumInt, instructor);
                boolean doesCourseExist = doesCourseExistAlready(newCourse);

                if (doesCourseExist == false) {
                    courseList.add(newCourse);
                    courseCount++;
                    updateCourseEnrollmentCount();
                } else {
                    bottomLabel.setText("Duplicated course - Not added");
                    bottomLabel.setTextFill(Color.RED);
                    return;
                }

                // clear the text fields
                subjectMenu.setValue("CSE");
                courseNumField.clear();
                instructorField.clear();

            

                updateCourseListDisplay();
            }
        });

        centerPane.getChildren().add(addButton);

        // drop button
        Button dropButton = new Button("Drop");
        // when the drop button is clicked, the class selected will be remove from the
        // course list

        dropButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // get the selected courses

                for (int i = 0; i < courseList.size(); i++) {
                    System.out.println("checkbox: " + checkboxContainer.getChildren().get(i));
                    System.out.println(courseList.get(i).getSubject() + " " + courseList.get(i).getCourseNum() + " "
                            + courseList.get(i).getInstructor());
                }

                int numCheckBoxSelected = 0;

                System.out.println("checkbox size: " + checkboxContainer.getChildren().size());

                for (int i = 0; i < checkboxContainer.getChildren().size(); i++) {
                    CheckBox checkBox = (CheckBox) checkboxContainer.getChildren().get(i);
                    if (checkBox.isSelected()) {
                        numCheckBoxSelected++;
                    }
                }


                System.out.println("numCheckBoxSelected: " + numCheckBoxSelected);

            }
        });

        centerPane.getChildren().add(dropButton);

        // Right Pane Code

        // VBox rightPane = new VBox();
        BorderPane rightPane = new BorderPane();

        Label labelRight = new Label("Course(s) Enrolled");
        labelRight.setTextFill(Color.BLUE);
        labelRight.setFont(Font.font(null, 14));
        rightPane.setTop(labelRight);

        rightPane.setPadding(new Insets(10, 10, 10, 10));
        // rightPane.setSpacing(50);
        // add a boder around the rightPane
        rightPane.setStyle("-fx-border-color: black");
        // set labelRight to the top of the rightPane

        // make a checkbox container
        checkboxContainer = new VBox();

        // code to display the courses in courseList
        updateCourseListDisplay();

        checkboxContainer.setSpacing(10);
        rightPane.setCenter(checkboxContainer);
 
        numCourses = new Label("Number of Courses Enrolled: " +
                courseCount + "");

        // // numCourses.setText("" + courseList.size());
        rightPane.setBottom(numCourses);

        this.getChildren().addAll(leftPane, centerPane, rightPane);
        this.setPadding(new Insets(10, 10, 10, 10));

    } // end of constructor

    public boolean doesCourseExistAlready(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getSubject().equals(course.getSubject()) && courseList.get(i).getCourseNum() == course.getCourseNum()) {
                return true;
            }
        }
        return false;
    }

    public void updateCourseListDisplay() {
        // clear the checkboxContainer
        checkboxContainer.getChildren().clear();

        // will loop through eachs class in the courseList Array to display it's
        // infomation in the checkboxContainer
        for (int i = 0; i < courseList.size(); i++) {
            // when the loop goes through each class in courseList It will:

            HBox itemContainer = new HBox(); // make a container that will wrap all the children items which will be

            // two sections, the checkbox and the content that displays the classes
            // infomation
            CheckBox itemCheckBox = new CheckBox();
            itemCheckBox.setIndeterminate(false); // sets the itital state as false
            VBox itemInfoContainer = new VBox();
            itemContainer.getChildren().addAll(itemCheckBox, itemInfoContainer);

            // within the part(itemInfoContainer) that contains the infomation for the each
            // item's class
            Label courseInfo = new Label(
                    "Course #: " + courseList.get(i).getSubject() + " " + courseList.get(i).getCourseNum() + "");
            Label instructorInfo = new Label("Instructor: " + courseList.get(i).getInstructor() + "");

            itemInfoContainer.getChildren().addAll(courseInfo, instructorInfo);

            // add the itemContainer to the checkboxContainer
            checkboxContainer.getChildren().add(itemContainer);

        }
    }

    public void updateCourseEnrollmentCount() {
        numCourses.setText("Number of Courses Enrolled: " + courseCount + "");
    }

    public class removeCourse implements EventHandler<ActionEvent> {
        CheckBox checkBox;
        Course course;

        public removeCourse(CheckBox checkBox, Course course) {
            this.checkBox = checkBox;
            this.course = course;
        }

        @Override
        public void handle(ActionEvent event) {
            if (checkBox.isSelected()) {
                courseList.remove(course);
                courseCount--;
                updateCourseListDisplay();
                updateCourseEnrollmentCount();
            }
        }
    }

} // end of CoursePane class