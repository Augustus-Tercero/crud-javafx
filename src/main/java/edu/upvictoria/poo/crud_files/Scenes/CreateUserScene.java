package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

        usernameTxt = new TextField("Enter username");
        firstNameTxt = new TextField("Enter first name");
        lastNameTxt = new TextField("Enter last name");
        emailTxt = new TextField("Enter email");
        phoneNumberTxt = new TextField("Enter phone number");
        saveBtn = new Button("Save");
        backBtn = new Button("Back");
        saveBtn.setOnAction(getEventHandler());

        backBtn.setOnAction(e -> main.switchScenes(0));
        getChildren().addAll(usernameTxt,firstNameTxt,lastNameTxt,emailTxt,phoneNumberTxt,saveBtn,backBtn);
    }

    private static EventHandler<ActionEvent> getEventHandler() {
        var saveEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var user = new User(
                        usernameTxt.getText(),firstNameTxt.getText(),
                        lastNameTxt.getText(),emailTxt.getText(),
                        phoneNumberTxt.getText()
                );
                System.out.println(user);
                usernameTxt.setText("");
                firstNameTxt.setText("");
                lastNameTxt.setText("");
                emailTxt.setText("");
                phoneNumberTxt.setText("");
            }
        };
        return saveEvent;
    }
}
