package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.User;
import edu.upvictoria.poo.lib.UserList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class UserListScene extends VBox {
    private TextArea textArea;
    private Button backBtn;
    private MainFrame main;
    private Scene scene;
    private UserList userList;

    public UserListScene(MainFrame main) {
        this.main = main;
        this.scene = new Scene(this, 400, 300);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.userList = new UserList("src/main/resources/db.csv");

        textArea = new TextArea();
        textArea.setEditable(false);
        displayUsers();
        getChildren().add(textArea);
    }

    private void displayUsers() {
        StringBuilder userData = new StringBuilder();
        for (User user : userList.getUsers()) {
            userData.append(user.toString()).append("\n"); // Append user data with a line break
        }
        textArea.setText(userData.toString());
    }
}
