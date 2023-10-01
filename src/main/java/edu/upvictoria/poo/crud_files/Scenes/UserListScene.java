package edu.upvictoria.poo.crud_files.Scenes;

import edu.upvictoria.poo.crud_files.MainFrame;
import edu.upvictoria.poo.lib.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class UserListScene extends VBox {
    private TableView<String> tableView;
    private ComboBox comboBox;
    private Button searchBtn;
    private Button backBtn;
    private MainFrame main;
    private Scene scene;

    public UserListScene(MainFrame main) {
        this.main = main;
        this.scene = new Scene(this,400,300);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        var column1 = new TableColumn<String,String>("Username");
        var column2 = new TableColumn<String,String>("First Name");
        var column3 = new TableColumn<String,String>("Last Name");
        var column4 = new TableColumn<String,String>("Email");
        var column5 = new TableColumn<String,String>("Phone Number");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
        column2.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        tableView = new TableView<>();
        tableView.getColumns().addAll(column1,column2,column3,column4,column5);
        getChildren().add(tableView);
    }
}
