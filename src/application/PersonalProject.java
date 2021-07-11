package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class PersonalProject extends Application
{
    public void start(Stage primaryStage)
    {
        //create a CirclePane object.
        SetCards gui = new SetCards();

        //put gui on top of the rootPane
        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(gui);

        //Create a scene and place rootPane in the stage
        Scene scene = new Scene(rootPane, 1500, 1500);
        primaryStage.setTitle("Set: The Game");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    
}

