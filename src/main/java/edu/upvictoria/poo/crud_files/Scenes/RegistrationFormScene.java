package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.FileWriterWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RegistrationFormScene extends Form {

    public RegistrationFormScene(MainFrame mainFrame) {
        super(mainFrame);
        title.setText("User Registration Form");
        saveBtn.setOnAction(saveEvent());
        var test = new Button("Back");
        test.setOnAction(e -> mainFrame.switchScenes(0));
        this.getChildren().addAll(saveBtn,test);
    }

    @Override
    public EventHandler<ActionEvent> saveEvent() {
        return actionEvent -> {
            var fileWriter = new FileWriterWrapper(mainFrame.db_path);
            if (!isAnyFieldEmpty()) {
                fileWriter.write(getTextFieldData());
            }
            cleanTextFields();
        };
    }

    public String getTextFieldData() {
        return usernameTxt.getText() + "," + firstNameTxt.getText() + "," + lastNameTxt.getText() + "," +
                        emailTxt.getText() + "," + phoneNumberTxt.getText();
    }
}
