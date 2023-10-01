package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StartScene extends VBox {
    private Scene scene;
    private MainFrame main;
    private Button createSceneBtn;
    private Button deleteSceneBtn;
    private Button modifySceneBtn;
    private Button listSceneBtn;
    public StartScene(MainFrame main) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.main = main;
        this.scene = new Scene(this, 400, 300);
        // this.scene.getStylesheets().add(MainFrame.class.getResource("/darktheme.css").toExternalForm());

        createSceneBtn = new Button("Create User");
        deleteSceneBtn = new Button("Delete User");
        modifySceneBtn = new Button("Modify User");
        listSceneBtn = new Button("List Users");
        createSceneBtn.setOnAction(e -> main.switchScenes(1));
        deleteSceneBtn.setOnAction(e -> main.switchScenes(2));
        modifySceneBtn.setOnAction(e -> main.switchScenes(3));
        listSceneBtn.setOnAction(e -> main.switchScenes(4));
        getChildren().addAll(createSceneBtn,deleteSceneBtn,modifySceneBtn,listSceneBtn);
    }
}
