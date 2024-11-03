package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;  // To easily switch scenes
    
    @Override
    public void start(Stage primaryStage){
        this.stage = primaryStage;

        // Set up the title screen layout
        VBox titleScreen = new VBox(20);
        titleScreen.setAlignment(Pos.CENTER);

        // Create the title label
        Label titleLabel = new Label("Welcome to Beat The House!");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Create the "Click to Continue" button
        Button startButton = new Button("Click to Continue");
        startButton.setStyle("-fx-font-size: 16px;");
        
        // Button action to start the profile screen
        startButton.setOnAction(e -> showProfileScreen());

        // Add the label and button to the VBox
        titleScreen.getChildren().addAll(titleLabel, startButton);

        // Create the scene with title screen layout and set up the stage
        Scene scene = new Scene(titleScreen, 400, 400);
        primaryStage.setTitle("Blackjack Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to display the profile screen
    private void showProfileScreen() {
        BorderPane profileScreen = new BorderPane();

        // Center: Placeholder for profile display
        HBox profileContainer = new HBox(10);
        profileContainer.setAlignment(Pos.CENTER);

        VBox profileBox = new VBox(5);
        profileBox.setAlignment(Pos.CENTER);
        Label profilePicturePlaceholder = new Label("[Profile Picture]");
        profilePicturePlaceholder.setStyle("-fx-border-color: black; -fx-padding: 40px; -fx-background-color: lightgrey;");
        Label profileNameLabel = new Label("Profile Name");
        profileBox.getChildren().addAll(profilePicturePlaceholder, profileNameLabel);

        profileContainer.getChildren().add(profileBox);
        profileScreen.setCenter(profileContainer);

        // Bottom: Create New Profile and Delete Profile buttons
        Button createProfileButton = new Button("Create New Profile");
        createProfileButton.setOnAction(e -> createNewProfile());

        Button deleteProfileButton = new Button("Delete Profile");
        deleteProfileButton.setOnAction(e -> deleteProfile());

        HBox bottomControls = new HBox(10);
        bottomControls.setAlignment(Pos.CENTER);
        bottomControls.setSpacing(200);
        bottomControls.getChildren().addAll(createProfileButton, deleteProfileButton);

        profileScreen.setBottom(bottomControls);

        // Set up the new scene with profileScreen layout
        Scene profileScene = new Scene(profileScreen, 400, 400);
        stage.setScene(profileScene);
    }

    // Placeholder for creating a new profile
    private void createNewProfile() {
        System.out.println("Create New Profile clicked!");
        // Add logic to create and display a new profile here
    }

    // Placeholder for deleting a profile
    private void deleteProfile() {
        System.out.println("Delete Profile clicked!");
        // Add logic to delete a profile here
    }

    public static void main(String[] args) {
        launch(args);
    }
}
