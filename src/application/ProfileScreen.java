package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileScreen {
    private BorderPane layout;
    private Main mainApp;

    public ProfileScreen(Main mainApp) {
        this.mainApp = mainApp;
        layout = new BorderPane();

        // Center: Profile display
        HBox profileContainerH = new HBox(10);
        VBox profileContainerV = new VBox(10);

        profileContainerH.setAlignment(Pos.CENTER);
        profileContainerV.setAlignment(Pos.CENTER);

        // Labels for profile
        Label profilePicturePlaceholder = new Label("[Profile Picture]");
        profilePicturePlaceholder.setStyle("-fx-border-color: black; -fx-padding: 40px; -fx-background-color: lightgrey;");
        
        Label profileLabel = new Label("Select or Create Profile");
        Label profileLabel2 = new Label("Sample Profile");
        
       
        profileContainerV.getChildren().addAll(profilePicturePlaceholder, profileLabel, profileLabel2);
        profileContainerH.getChildren().add(profileContainerV);

     
        layout.setCenter(profileContainerH);

        
        Button createProfileButton = new Button("Create New Profile");
        Button deleteProfileButton = new Button("Delete Profile");

        createProfileButton.setOnAction(e -> System.out.println("Create Profile clicked"));
        deleteProfileButton.setOnAction(e -> System.out.println("Delete Profile clicked"));

       
        HBox bottomControls = new HBox(10);
        bottomControls.setAlignment(Pos.CENTER);
        bottomControls.setSpacing(200);
        bottomControls.getChildren().addAll(deleteProfileButton, createProfileButton);

        
        layout.setBottom(bottomControls);
    }

    public BorderPane getLayout() {
        return layout;
    }
}
