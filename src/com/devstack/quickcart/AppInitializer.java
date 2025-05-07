package com.devstack.quickcart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("/com/devstack/quickcart/view/SplashScreen.fxml");
        Parent parent = FXMLLoader.load(resource);
        Scene scene=new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Quick Cart");
        primaryStage.show();

    }
}
