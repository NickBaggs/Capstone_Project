package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane; 
import javafx.scene.layout.HBox;  
import javafx.scene.layout.VBox;  
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfileScreen {
    private Pane layout;
    private Main mainApp;

    public ProfileScreen(Main mainApp) {
        this.mainApp = mainApp;
        layout = new Pane();  // Using Pane for flexible positioning

        // Set the background image
        String backgroundImagePath = "file:C:/Users/candy/Desktop/Capstone Workspace/Capstone_Project/assets/Backgrounds/Table_Background.png";
        Image backgroundImage = new Image(backgroundImagePath);

        // Set the BackgroundImage to scale to the size of the window
        BackgroundImage background = new BackgroundImage(
            backgroundImage, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            new BackgroundSize(100, 100, true, true, true, true)
        );

        layout.setBackground(new Background(background));

        //Create Title text
        Text profileLabel = new Text("Select or Create Profile");
        profileLabel.setFont(new Font("Arial", 24)); 
        profileLabel.setFill(Color.WHITE);  
        
        //Set profile label position
        profileLabel.layoutXProperty().bind(layout.widthProperty().subtract(profileLabel.getBoundsInLocal().getWidth()).divide(2)); 
        profileLabel.layoutYProperty().bind(layout.heightProperty().multiply(0.2)); 

        //Contains profile images horizontal row
        HBox profileImagesContainer = new HBox(20);  
        profileImagesContainer.setAlignment(Pos.CENTER); 

       // loop to create 5 profiles
        for (int i = 1; i <= 5; i++) {
            
            String profileImagePath = "file:C:/Users/candy/Desktop/Capstone Workspace/Capstone_Project/assets/Profile_Pictures/" + i + ".png";  // Example profile image using the index
            Image profileImage = new Image(profileImagePath);
            ImageView profileImageView = new ImageView(profileImage);
            profileImageView.setFitWidth(100);  
            profileImageView.setFitHeight(100);

            // Label "Create New Profile"
            Text createProfileLabel = new Text("Create New Profile");
            createProfileLabel.setFont(new Font("Arial", 14));  
            createProfileLabel.setFill(Color.WHITE); 

            // Profile Image Buttons
            Button profileButton = new Button();
            profileButton.setGraphic(profileImageView);  
            profileButton.setStyle("-fx-background-color: transparent; -fx-border: none;"); 

           //Set button actions
            int index = i;  
            profileButton.setOnAction(e -> System.out.println("Profile " + index + " selected!"));

            // Arrange the profile image and label vertically using VBox
            VBox profileContainer = new VBox(5);  
            profileContainer.setAlignment(Pos.CENTER);
            profileContainer.getChildren().addAll(profileButton, createProfileLabel);

            // Add profile icon to HBox
            profileImagesContainer.getChildren().add(profileContainer);
        }


        // Bind the X position of the HBox
        profileImagesContainer.layoutXProperty().bind(layout.widthProperty().subtract(profileImagesContainer.widthProperty()).divide(2));  
        
        // Bind the Y position of the HBox 
        profileImagesContainer.layoutYProperty().bind(layout.heightProperty().multiply(0.4));  

        // Add the profile label and profile images container to the layout
        layout.getChildren().addAll(profileLabel, profileImagesContainer);
        
        Button goToMainMenuButton = new Button("Go to Main Menu");
        goToMainMenuButton.setOnAction(e -> mainApp.showMainMenu());  
        
        // Position the button below the profile images
        goToMainMenuButton.layoutXProperty().bind(layout.widthProperty().subtract(goToMainMenuButton.widthProperty()).divide(2));
        goToMainMenuButton.layoutYProperty().bind(layout.heightProperty().multiply(0.8)); 

        layout.getChildren().add(goToMainMenuButton);  
    }
    

    public Pane getLayout() {
        return layout;
    }
}
