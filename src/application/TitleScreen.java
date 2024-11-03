package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TitleScreen {
    private VBox layout;
    private Main mainApp;  // Reference to Main for screen switching

    public TitleScreen(Main mainApp) {
        this.mainApp = mainApp;
        layout = new VBox(20);
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        Label titleLabel = new Label("Welcome to Blackjack!");
        Button startButton = new Button("Start Game");
        
        startButton.setOnAction(e -> mainApp.showProfileScreen());

        layout.getChildren().addAll(titleLabel, startButton);
    }

    public VBox getLayout() {
        return layout;
    }
}
