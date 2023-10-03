package edu.upvictoria.poo.crud_files;

import edu.upvictoria.poo.crud_files.Scenes.MainScene;
import edu.upvictoria.poo.crud_files.Scenes.RegistrationFormScene;
import edu.upvictoria.poo.crud_files.Scenes.UserDeletionScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainFrame extends Application {
    public final String db_path = "src/main/resources/db.csv";
    private Stage stage;
    private MainScene homeScene;
    private RegistrationFormScene registrationScene;
    private UserDeletionScene deletionScene;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("CRUD");

        this.homeScene = new MainScene(this);
        this.registrationScene = new RegistrationFormScene(this);
        this.deletionScene = new UserDeletionScene(this);

        this.stage.setScene(homeScene.getScene());
        this.stage.show();
    }

    public void switchScenes(int option) {
        switch (option) {
            case 0 -> stage.setScene(homeScene.getScene());
            case 1 -> stage.setScene(registrationScene.getScene());
            case 2 -> stage.setScene(deletionScene.getScene());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
