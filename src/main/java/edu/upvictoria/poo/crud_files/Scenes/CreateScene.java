package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.FileWriterWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreateScene extends Form {

    public CreateScene(MainFrame mainFrame) {
        super(mainFrame);
        title.setText("User Registration Form");
        saveBtn.setOnAction(saveEvent());
        this.getChildren().addAll(saveBtn,backBtn);
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
