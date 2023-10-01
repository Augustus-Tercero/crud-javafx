package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class DeleteUserScene extends VBox {
    private static ComboBox usernameTxt;
    private static Button saveBtn;
    private static Button backBtn;
    private Scene scene;
    private MainFrame main;

    public DeleteUserScene(MainFrame main) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.main = main;
        this.scene = new Scene(this, 400, 300);

        var test = new String[]{"1","2","3"};
        usernameTxt = new ComboBox(FXCollections.observableArrayList(test));
        saveBtn = new Button("Save");
        backBtn = new Button("Back");

        backBtn.setOnAction(e -> main.switchScenes(0));
        getChildren().addAll(usernameTxt,saveBtn,backBtn);
    }
}
