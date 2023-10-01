module edu.upvictoria.poo.crud_files {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.upvictoria.poo.crud_files to javafx.fxml;
    exports edu.upvictoria.poo.crud_files;
    exports edu.upvictoria.poo.crud_files.Scenes;
    opens edu.upvictoria.poo.crud_files.Scenes to javafx.fxml;
}