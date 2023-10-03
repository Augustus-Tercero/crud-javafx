package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import javafx.scene.control.Button;

public class MainScene extends VBoxScene {
    private static Button createBtn = new Button("Create");
    private static Button deleteBtn = new Button("Delete");
    private static Button updateBtn = new Button("Update");
    private static Button listBtn = new Button("List Users");


    public MainScene(MainFrame mainFrame) {
        super(mainFrame);
        createBtn.setOnAction(e -> mainFrame.switchScenes(1));
        deleteBtn.setOnAction(e -> mainFrame.switchScenes(2));
        updateBtn.setOnAction(e -> mainFrame.switchScenes(3));
        listBtn.setOnAction(e -> mainFrame.switchScenes(4));
        this.getChildren().addAll(createBtn,deleteBtn,updateBtn,listBtn);
    }
}
