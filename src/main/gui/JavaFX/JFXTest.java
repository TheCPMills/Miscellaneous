package main.gui.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;

public class JFXTest extends Application {

    // launch the application
    public void start(Stage stage) {
        try {
            Label errorLabel = new Label("Error: ");
            errorLabel.setTextFill(Color.color(1, 1, 1));

            stage.setTitle("FileChooser");
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files (*.png, *.jpg, *.jpeg, *gif)", "*.png", "*.jpg", "*.jpeg", "*.gif");
            fileChooser.getExtensionFilters().add(extFilter);

            DirectoryChooser directoryChooser = new DirectoryChooser();

            Label imageLabel = new Label("no image selected");
            Button imageButton = new Button("Select Image");

            // create an Event Handler
            EventHandler<ActionEvent> imageEvent = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    File selectedImage = fileChooser.showOpenDialog(stage);

                    if (selectedImage != null) {
                        imageLabel.setText(selectedImage.getAbsolutePath());
                        imageLabel.setTextFill(Color.color(0, 0, 0));
                        imageButton.setTextFill(Color.color(0, 0, 0));
                        fileChooser.setInitialDirectory(new File(selectedImage.getAbsolutePath().substring(0, selectedImage.getAbsolutePath().lastIndexOf("\\"))));
                    }
                }
            };
            imageButton.setOnAction(imageEvent);

            Label directoryLabel = new Label("no location selected");
            Button directoryButton = new Button("Choose Export Location");

            // create an Event Handler
            EventHandler<ActionEvent> directoryEvent = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    File selectedDirectory = directoryChooser.showDialog(stage);

                    if (selectedDirectory != null) {
                        directoryLabel.setText(selectedDirectory.getAbsolutePath());
                        directoryLabel.setTextFill(Color.color(0, 0, 0));
                        directoryButton.setTextFill(Color.color(0, 0, 0));
                        directoryChooser.setInitialDirectory(new File(selectedDirectory.getAbsolutePath()));
                    }
                }
            };
            directoryButton.setOnAction(directoryEvent);

            Button convertButton = new Button("Convert");

            // create an Event Handler
            EventHandler<ActionEvent> convertEvent = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    String i = imageLabel.getText();
                    String d = directoryLabel.getText();

                    errorLabel.setText("Error: ");

                    if (i.equals("no image selected") && d.equals("no location selected")) {
                        imageLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        directoryLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        errorLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        errorLabel.setText(errorLabel.getText() + "Must select a reference image and a folder to save to");
                    } else if (i.equals("no image selected")) {
                        imageLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        errorLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        errorLabel.setText(errorLabel.getText() + "Must select a reference image");
                    } else if (d.equals("no location selected")) {
                        directoryLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        errorLabel.setTextFill(Color.color(0.6862745098, 0.00392156862, 0.00392156862));
                        errorLabel.setText(errorLabel.getText() + "Must select a folder to save to");
                    } else {
                        errorLabel.setTextFill(Color.color(1, 1, 1));
                        System.out.println("Hello World!");
                    }
                }
            };
            convertButton.setOnAction(convertEvent);

            Pane scene = new Pane();

            imageButton.setLayoutX(10);
            imageButton.setLayoutY(10);
            imageButton.setBackground(new Background(new BackgroundFill(Color.color(0.10588, 0.11765, 0.16863), new CornerRadii(5), Insets.EMPTY)));  

            imageLabel.setLayoutX(97.75);
            imageLabel.setLayoutY(13.75);

            directoryButton.setLayoutX(10);
            directoryButton.setLayoutY(40);

            directoryLabel.setLayoutX(155);
            directoryLabel.setLayoutY(43.75);

            convertButton.layoutXProperty().bind(scene.widthProperty().subtract(convertButton.widthProperty()).divide(2));
            convertButton.setLayoutY(95);

            errorLabel.layoutXProperty().bind(scene.widthProperty().subtract(errorLabel.widthProperty()).divide(2));
            errorLabel.setLayoutY(75);
            
            scene.getChildren().add(imageButton);
            scene.getChildren().add(imageLabel);
            scene.getChildren().add(directoryButton);
            scene.getChildren().add(directoryLabel);
            scene.getChildren().add(convertButton);
            scene.getChildren().add(errorLabel);

            scene.setBackground(new Background(new BackgroundFill(Color.color(0.15686274509, 0.17647058823, 0.2431372549), CornerRadii.EMPTY, Insets.EMPTY)));
            
            stage.setScene(new Scene(scene, 600, 130));
            stage.setResizable(false);
            stage.show();
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Main Method
    public static void main(String args[]) {
        // launch the application
        launch(args);

        //setDiable(true);
    }
}
