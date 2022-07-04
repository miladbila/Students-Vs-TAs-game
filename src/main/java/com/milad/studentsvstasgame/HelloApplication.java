package com.milad.studentsvstasgame;

import com.milad.studentsvstasgame.heros.student.StudiousStudent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static GamePage gamePage;
    @Override
    public void start(Stage stage) throws IOException {
        gamePage=new GamePage();
        Scene scene=new Scene(gamePage);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}