package com.devstack.quickcart.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    public void openDashboardOnAction(ActionEvent actionEvent) {
        setUi("DashboardForm", actionEvent);
    }

    public void openForgotPasswordOnAction(ActionEvent actionEvent) {
        setUi("ForgotPasswordForm", actionEvent);
    }

    private void setUi(String location, ActionEvent event){
        try {
            // Load FXML
            URL resource = getClass().getResource("/com/devstack/quickcart/view/" + location + ".fxml");
            if (resource == null) {
                throw new RuntimeException("FXML file not found: " + location + ".fxml");
            }

            Parent parent = FXMLLoader.load(resource);
            Scene scene = new Scene(parent);

            // Get current stage from the event source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(location);
            stage.centerOnScreen();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load UI: " + location, e);
        }
    }
}
