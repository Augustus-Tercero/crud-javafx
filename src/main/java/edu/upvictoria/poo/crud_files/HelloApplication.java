package edu.upvictoria.poo.crud_files;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new MainFrame();
    }

    public static void main(String[] args) {
        launch();
    }
}