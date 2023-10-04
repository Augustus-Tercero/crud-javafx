package edu.upvictoria.poo.crud_files;

import edu.upvictoria.poo.crud_files.Scenes.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainFrame extends Application {
    public final String db_path = "src/main/resources/db.csv";
    private Stage stage;
    private MainScene homeScene;
    private CreateScene registrationScene;
    private DeleteScene deletionScene;
    private UpdateScene updateScene;
    private ListScene listScene;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("CRUD");

        this.homeScene = new MainScene(this);
        this.registrationScene = new CreateScene(this);
        this.deletionScene = new DeleteScene(this);
        this.updateScene = new UpdateScene(this);
        this.listScene = new ListScene(this);

        this.stage.setScene(homeScene.getScene());
        this.stage.show();
    }

    public void switchScenes(int option) {
        switch (option) {
            case 0 -> stage.setScene(homeScene.getScene());
            case 1 -> stage.setScene(registrationScene.getScene());
            case 2 -> stage.setScene(deletionScene.getScene());
            case 3 -> stage.setScene(updateScene.getScene());
            case 4 -> stage.setScene(listScene.getScene());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
