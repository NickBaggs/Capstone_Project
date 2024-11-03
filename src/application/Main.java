package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showTitleScreen();
    }

    public void showTitleScreen() {
        TitleScreen titleScreen = new TitleScreen(this);
        Scene scene = new Scene(titleScreen.getLayout(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack Game");
        primaryStage.show();
    }

    public void showProfileScreen() {
        ProfileScreen profileScreen = new ProfileScreen(this);
        Scene scene = new Scene(profileScreen.getLayout(), 400, 400);
        primaryStage.setScene(scene);
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
