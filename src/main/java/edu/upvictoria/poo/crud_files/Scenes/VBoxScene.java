package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public abstract class VBoxScene extends VBox {
    protected Scene scene;
    protected MainFrame mainFrame;
    protected Button backBtn = new Button("Back");
    protected Label title = new Label();

    public VBoxScene(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.scene = new Scene(this,400,300);
        backBtn.setOnAction(e -> mainFrame.switchScenes(0));
    }
}
