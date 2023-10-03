package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.FileContentWrapper;
import edu.upvictoria.poo.lib.FileWriterWrapper;
import edu.upvictoria.poo.lib.User;
import edu.upvictoria.poo.lib.UserList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ModifyUserScene extends VBox {
    private Scene scene;
    private MainFrame main;
    private static Button backBtn;
    private static Button saveBtn;
    private static Label label;
    private static ComboBox<User> comboBox;
    private static UserList userList;
    private static TextField usernameTxt;
    private static TextField emailTxt;
    private static TextField phoneNumberTxt;
    private static TextField firstNameTxt;
    private static TextField lastNameTxt;

    public ModifyUserScene(MainFrame main) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.main = main;
        this.scene = new Scene(this,400,300);
        userList = new UserList("src/main/resources/db.csv");

        usernameTxt = new TextField();
        usernameTxt.setPromptText("Enter username*");
        firstNameTxt = new TextField();
        firstNameTxt.setPromptText("Enter first name*");
        lastNameTxt = new TextField();
        lastNameTxt.setPromptText("Enter last name*");
        emailTxt = new TextField();
        emailTxt.setPromptText("Enter email*");
        phoneNumberTxt = new TextField();
        phoneNumberTxt.setPromptText("Enter phone number*");
        label = new Label("Modify User");
        backBtn = new Button("Back");
        saveBtn = new Button("Save");
        comboBox = new ComboBox(FXCollections.observableArrayList(userList.getUsers()));
        comboBox.setPromptText("Select an item");
        backBtn.setOnAction(e -> main.switchScenes(0));
        saveBtn.setOnAction(event());
        getChildren().addAll(label,comboBox,usernameTxt,firstNameTxt,lastNameTxt,emailTxt,phoneNumberTxt,saveBtn,backBtn);
    }

    public EventHandler<ActionEvent> event() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var selected = comboBox.getValue();
                var db = "src/main/resources/db.csv";
                var index = new FileContentWrapper(db).getStringIndex(selected.getUsername());
                var wr = new FileWriterWrapper(db);
                if (!selected.isEmpty()) {
                    wr.modifyLine(index, txtToString());
                }
                clean();
                comboBox.setValue(null);
            }
        };
    }

    public static void clean() {
        usernameTxt.setText("");
        firstNameTxt.setText("");
        lastNameTxt.setText("");
        phoneNumberTxt.setText("");
        emailTxt.setText("");
    }

    public static String txtToString() {
        return usernameTxt.getText() + "," + firstNameTxt.getText() + "," + lastNameTxt.getText() + "," +
                emailTxt.getText() + "," + phoneNumberTxt.getText();
    }
}
