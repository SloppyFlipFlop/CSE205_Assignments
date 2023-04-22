/* 
 * Assignment #: 6
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: This program creates a GUI that allows the user to enter a course subject, course number, and instructor.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Assignment6 extends Application {
    public static final int WIDTH = 600, HEIGHT = 400;

    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        CoursePane coursePane = new CoursePane();
        root.getChildren().add(coursePane);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("ASU Course Enrollment System");
        primaryStage.setScene(scene);
        primaryStage.show(); // Displays the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}