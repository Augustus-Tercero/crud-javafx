package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.FileWriterWrapper;
import edu.upvictoria.poo.lib.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CreateUserScene extends VBox {
    private static TextField usernameTxt;
    private static TextField emailTxt;
    private static TextField phoneNumberTxt;
    private static TextField firstNameTxt;
    private static TextField lastNameTxt;
    private static Button saveBtn;
    private static Button backBtn;
    private MainFrame main;
    private Scene scene;

    public CreateUserScene(MainFrame main) {
        this.main = main;
        this.scene = new Scene(this, 400, 300);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

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
        saveBtn = new Button("Save");
        backBtn = new Button("Back");
        saveBtn.setOnAction(getEventHandler());

        backBtn.setOnAction(e -> main.switchScenes(0));
        getChildren().addAll(usernameTxt,firstNameTxt,lastNameTxt,emailTxt,phoneNumberTxt,saveBtn,backBtn);
    }

    private static EventHandler<ActionEvent> getEventHandler() {
        return actionEvent -> {
            var db = "src/main/resources/db.csv";
            var writerWrapper = new FileWriterWrapper(db);
            var user = new User(
                    usernameTxt.getText(), firstNameTxt.getText(),
                    lastNameTxt.getText(), emailTxt.getText(),
                    phoneNumberTxt.getText()
            );
            if (!user.isEmpty()) {
                writerWrapper.write(user.toString());
            }

            usernameTxt.setText("");
            firstNameTxt.setText("");
            lastNameTxt.setText("");
            emailTxt.setText("");
            phoneNumberTxt.setText("");
        };
    }
}
