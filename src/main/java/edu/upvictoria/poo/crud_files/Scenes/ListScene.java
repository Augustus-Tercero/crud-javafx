package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;
import java.util.Map;

public class ListScene extends VBoxScene {
    private static TableView tableView = new TableView<>();
    public ListScene(MainFrame mainFrame) {
        super(mainFrame);
        title.setText("List Users");
        backBtn.setOnAction(e -> mainFrame.switchScenes(0));

        var col1 = new TableColumn<User,String>("Username");
        var col2 = new TableColumn<User,String>("First Name");
        var col3 = new TableColumn<User,String>("Last Name");
        var col4 = new TableColumn<User,String>("Email");
        var col5 = new TableColumn<User,String>("Phone Number");

        col1.setCellValueFactory(new PropertyValueFactory<>("username"));
        col2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col4.setCellValueFactory(new PropertyValueFactory<>("email"));
        col5.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableView.getColumns().addAll(col1,col2,col3,col4,col5);
        // Agregar datos a la tabla (en este ejemplo, dos usuarios de prueba)
        tableView.getItems().addAll(
                new User("randal", "Randall", "Kovic", "test@mail.com", "00000"),
                new User("leesin", "lee", "sin", "test@mail.com", "00000")
        );

        this.getChildren().addAll(title, tableView, backBtn);
    }

    public EventHandler<ActionEvent> event() {
        return actionEvent -> {};
    }
}
