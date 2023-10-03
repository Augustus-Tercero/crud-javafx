package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.User;
import edu.upvictoria.poo.lib.UserFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public abstract class SelectUserScene extends VBoxScene{
    protected static ComboBox<User> comboBox;
    protected UserFactory userFactory;

    public SelectUserScene(MainFrame mainFrame) {
        super(mainFrame);
        this.userFactory = new UserFactory(mainFrame.db_path);
        comboBox = new ComboBox<>(FXCollections.observableList(userFactory.getUsers()));
        comboBox.setPromptText("Select an Item");
        this.getChildren().addAll(title, comboBox,backBtn);
    }

    public abstract EventHandler<ActionEvent> event();

}
