package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class ModifyUserScene extends VBox {
    private Scene scene;
    private MainFrame main;
    private static Button backBtn;
    private static Button saveBtn;
    private static Label label;
    private static ComboBox comboBox;

    public ModifyUserScene(MainFrame main) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.main = main;
        this.scene = new Scene(this,400,300);

        var test = new String[]{"1","2","3"};
        label = new Label("");
        backBtn = new Button("Back");
        saveBtn = new Button("Save");
        comboBox = new ComboBox(FXCollections.observableArrayList(test));
        backBtn.setOnAction(e -> main.switchScenes(0));

        getChildren().addAll(label,comboBox,saveBtn,backBtn);
    }
}
