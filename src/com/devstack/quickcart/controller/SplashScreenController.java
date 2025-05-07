package com.devstack.quickcart.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashScreenController {


    public AnchorPane container;
    public ProgressBar progressbar;

    public void initialize() {
        load();
    }

    private void load() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressbar.progressProperty(),0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(progressbar.progressProperty(),1))
        );
        timeline.play();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5));
        pauseTransition.setOnFinished(event -> {openLoginForm();});
        pauseTransition.play();
    }

    private void openLoginForm() {
        URL resource =
                getClass().getResource("/com/devstack/quickcart/view/LoginForm.fxml");
        Parent parent = null;
        try {
            parent = FXMLLoader.load(resource);
            Scene scene = new Scene(parent);
            Stage stage = (Stage) container.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Login Form");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}