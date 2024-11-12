package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import data.DatabaseConnector;


public class Main extends Application {
    private Stage primaryStage;

    @Override
    
    
    public void start(Stage primaryStage) {
    	
        this.primaryStage = primaryStage;
        showTitleScreen();
        
    }

    public void showTitleScreen() {
        TitleScreen titleScreen = new TitleScreen(this);
        Scene scene = new Scene(titleScreen.getLayout(), 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack Game");
        primaryStage.show();
    }

    public void showProfileScreen() {
        ProfileScreen profileScreen = new ProfileScreen(this);
        Scene scene = new Scene(profileScreen.getLayout(), 1200, 800);
        primaryStage.setScene(scene);
    }
    
    public void showMainMenu() {
        MainMenu mainMenu = new MainMenu(this);
        Scene scene = new Scene(mainMenu.getLayout(), 1200, 800);
        primaryStage.setScene(scene);
    }
    
    public void showStandardModeScreen() {
        StandardMode standardModeScreen = new StandardMode(this);
        Scene scene = new Scene(standardModeScreen.getLayout(), 1200, 800);  // Adjust size as needed
        primaryStage.setScene(scene);
    }



    

    public static void main(String[] args) {
        launch(args);
    }
}
