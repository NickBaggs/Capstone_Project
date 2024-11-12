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
import javafx.scene.layout.HBox;  // For horizontal alignment
import javafx.scene.paint.Color;

public class StandardMode {
    private Pane layout;
    private Main mainApp;

    public StandardMode(Main mainApp) {
        this.mainApp = mainApp;
        layout = new Pane();  

        // Set the background image
        String backgroundImagePath = "file:C:/Users/candy/Desktop/Capstone Workspace/Capstone_Project/assets/Backgrounds/Table_Background.png";
        Image backgroundImage = new Image(backgroundImagePath);

        BackgroundImage background = new BackgroundImage(
            backgroundImage, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            new BackgroundSize(100, 100, true, true, true, true)
        );

        layout.setBackground(new Background(background));

        // Create HBox 
        HBox buttonContainer = new HBox(30);  
        buttonContainer.setAlignment(Pos.CENTER);  

        // Create the "Stay" button 
        Button stayButton = new Button();
        String stayButtonImagePath = "file:C:/Users/candy/Desktop/Capstone Workspace/Capstone_Project/assets/Buttons/Simple Buttons v1.2/simple_ui_button_round_128_down_2.png"; // Stay button image path
        Image stayButtonImage = new Image(stayButtonImagePath);
        ImageView stayButtonImageView = new ImageView(stayButtonImage);
        stayButton.setGraphic(stayButtonImageView);
        stayButton.setStyle("-fx-background-color: transparent; -fx-border: none;");

        // Create the "Hit" button (right side)
        Button hitButton = new Button();
        String hitButtonImagePath = "file:C:/Users/candy/Desktop/Capstone Workspace/Capstone_Project/assets/Buttons/Simple Buttons v1.2/simple_ui_button_round_128_down_0.png"; // Hit button image path
        Image hitButtonImage = new Image(hitButtonImagePath);
        ImageView hitButtonImageView = new ImageView(hitButtonImage);
        hitButton.setGraphic(hitButtonImageView);
        hitButton.setStyle("-fx-background-color: transparent; -fx-border: none;");

        // Add the buttons to the HBox
        buttonContainer.getChildren().addAll(stayButton, hitButton);

        // Bind the position of the button container
        buttonContainer.layoutXProperty().bind(layout.widthProperty().subtract(buttonContainer.widthProperty()).divide(2));  
        buttonContainer.layoutYProperty().bind(layout.heightProperty().multiply(0.6));  

        
        stayButton.setOnAction(e -> System.out.println("Stay button pressed"));
        hitButton.setOnAction(e -> System.out.println("Hit button pressed"));

       
        layout.getChildren().addAll(buttonContainer);
    }

    public Pane getLayout() {
        return layout;
    }
}
