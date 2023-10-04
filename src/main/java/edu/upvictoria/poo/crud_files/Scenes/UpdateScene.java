package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.FileContentWrapper;
import edu.upvictoria.poo.lib.FileWriterWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class UpdateScene extends VBoxScene {
    private static TextArea textArea = new TextArea();
    private static Button saveBtn = new Button("Save");
    private static Button backBtn = new Button("Back");

    public UpdateScene(MainFrame mainFrame) {
        super(mainFrame);
        this.title.setText("Modify users");
        this.setTextArea(textArea);
        saveBtn.setOnAction(event());
        backBtn.setOnAction(e -> mainFrame.switchScenes(0));
        this.getChildren().addAll(title,textArea,saveBtn,backBtn);
    }

    public void setTextArea(TextArea textArea) {
        var text = new StringBuilder();
        var content = new FileContentWrapper(mainFrame.db_path).getFileContent();
        if (!content.isEmpty()) {
            for (var line : content) {
                text.append(line).append("\n");
            }
        }
        textArea.setText(text.toString());
    }

    public EventHandler<ActionEvent> event() {
        return actionEvent -> {
            var fileWriter = new FileWriterWrapper(mainFrame.db_path);
            fileWriter.overWrite(textArea.getText());
        };
    }
}
