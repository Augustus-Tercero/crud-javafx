package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Form extends VBoxScene {
    protected static Button saveBtn = new Button("Save");
    protected static TextField usernameTxt = new TextField();
    protected static TextField firstNameTxt = new TextField();
    protected static TextField lastNameTxt = new TextField();
    protected static TextField emailTxt = new TextField();
    protected static TextField phoneNumberTxt = new TextField();

    public Form(MainFrame mainFrame) {
        super(mainFrame);
        this.getChildren().addAll(
                title,usernameTxt,firstNameTxt,lastNameTxt,emailTxt,phoneNumberTxt
        );
        usernameTxt.setPromptText("Enter username");
        firstNameTxt.setPromptText("Enter user's first name");
        lastNameTxt.setPromptText("Enter user's last name");
        emailTxt.setPromptText("Enter user's email");
        phoneNumberTxt.setPromptText("Enter user's phone number");
    }

    public void cleanTextFields() {
        usernameTxt.setText("");
        firstNameTxt.setText("");
        lastNameTxt.setText("");
        emailTxt.setText("");
        phoneNumberTxt.setText("");
    }

    public static boolean isAnyFieldEmpty() {
        return usernameTxt.getText().isEmpty() || firstNameTxt.getText().isEmpty() || lastNameTxt.getText().isEmpty()
                || emailTxt.getText().isEmpty() || phoneNumberTxt.getText().isEmpty();
    }

    public abstract EventHandler<ActionEvent> saveEvent();
}
