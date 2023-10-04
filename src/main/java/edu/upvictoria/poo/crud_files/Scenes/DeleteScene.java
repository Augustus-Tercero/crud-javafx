package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.FileWriterWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DeleteScene extends SelectUserScene {
    private static Button saveBtn = new Button("Save");

    public DeleteScene(MainFrame mainFrame) {
        super(mainFrame);
        title.setText("Delete User");
        this.getChildren().add(saveBtn);
        saveBtn.setOnAction(event());
    }

    @Override
    public EventHandler<ActionEvent> event() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var fileWriter = new FileWriterWrapper(mainFrame.db_path);
                var selected = comboBox.getValue();
                userFactory.getUsers().remove(selected);
                fileWriter.overWrite(userFactory.toArray());
                comboBox.setPromptText("Select an Item");
            }
        };
    }
}
