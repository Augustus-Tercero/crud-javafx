package edu.upvictoria.poo.crud_files;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public abstract class Form extends VBox {
    private Scene scene = new Scene(this,400,300);
    private MainFrame mainFrame;
    private static Button backBtn = new Button("Back");
    private static Button saveBtn = new Button("Save");
    private static TextField usernameTxt = new TextField();
    private static TextField firstNameTxt = new TextField();
    private static TextField lastNameTxt = new TextField();
    private static TextField emailTxt = new TextField();
    private static TextField phoneNumberTxt = new TextField();

    public Form(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.scene = new Scene(this,400,300);
        this.getChildren().addAll(usernameTxt,firstNameTxt,lastNameTxt,emailTxt,phoneNumberTxt,saveBtn,backBtn);

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

    public abstract EventHandler<ActionEvent> saveEvent();
}
