package edu.upvictoria.poo.crud_files;

import edu.upvictoria.poo.crud_files.Scenes.CreateUserScene;
import edu.upvictoria.poo.crud_files.Scenes.DeleteUserScene;
import edu.upvictoria.poo.crud_files.Scenes.ModifyUserScene;
import edu.upvictoria.poo.crud_files.Scenes.UserListScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainFrame extends Application {
    private Stage MainStage;
    private DeleteUserScene deleteUserScene;
    private CreateUserScene createUserScene;
    private ModifyUserScene modifyUserScene;
    private UserListScene userListScene;
    private StartScene firstScreen;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainStage = primaryStage;
        MainStage.setTitle("CRUD");
        firstScreen = new StartScene(this);
        deleteUserScene = new DeleteUserScene(this);
        createUserScene = new CreateUserScene(this);
        modifyUserScene = new ModifyUserScene(this);
        userListScene = new UserListScene(this);

        primaryStage.setScene(firstScreen.getScene());
        primaryStage.show();
    }

    public void switchScenes(int option) {
        switch (option) {
            case 0 -> MainStage.setScene(firstScreen.getScene());
            case 1 -> MainStage.setScene(createUserScene.getScene());
            case 2 -> MainStage.setScene(deleteUserScene.getScene());
            case 3 -> MainStage.setScene(modifyUserScene.getScene());
            case 4 -> MainStage.setScene(userListScene.getScene());
        }
    }
}
