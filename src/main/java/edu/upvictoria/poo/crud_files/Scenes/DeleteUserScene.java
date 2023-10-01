package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.User;
import edu.upvictoria.poo.lib.UserList;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DeleteUserScene extends VBox {
    private static ComboBox usernameTxt;
    private Label label;
    private static Button saveBtn;
    private static Button backBtn;
    private Scene scene;
    private MainFrame main;

    public DeleteUserScene(MainFrame main) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.main = main;
        this.scene = new Scene(this, 400, 300);
        var userList = new UserList("src/main/resources/db.csv");
        usernameTxt = new ComboBox(FXCollections.observableArrayList(userList.getUsers()));
        usernameTxt.setPromptText("Select an item");
        saveBtn = new Button("Save");
        backBtn = new Button("Back");
        label = new Label("Delete a user");

        backBtn.setOnAction(e -> main.switchScenes(0));
        getChildren().addAll(label,usernameTxt,saveBtn,backBtn);
    }
}
