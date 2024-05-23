package shop.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public interface common {

    default void dashboard(ActionEvent event) {
        try {
            // Load the FXML file for the new scene
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double width = stage.getWidth();
            double height = stage.getHeight();

            // Set the new scene on the stage
            stage.setScene(new Scene(root));
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
            stage.getIcons().add(image);

            // (Optional) Set stage title for the new scene
            stage.setTitle("JAY Mobile");
            stage.setHeight(height);
            stage.setWidth(width);

            // Show the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle loading FXML file exceptions
        }
    }
    default void bill(ActionEvent event) {
        try {
            // Load the FXML file for the new scene
            Parent root = FXMLLoader.load(getClass().getResource("bill.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene on the stage
            stage.setScene(new Scene(root));
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
            stage.getIcons().add(image);

            // (Optional) Set stage title for the new scene
            stage.setTitle("JAY Mobile");

            // Show the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle loading FXML file exceptions
        }
    }
    default void inventory(ActionEvent event) {
        try {
            // Load the FXML file for the new scene
            Parent root = FXMLLoader.load(getClass().getResource("inventory.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            // Set the new scene on the stage
            stage.setScene(new Scene(root));

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
            stage.getIcons().add(image);

            // (Optional) Set stage title for the new scene
            stage.setTitle("JAY Mobile");

            // Show the new scene
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            // Handle loading FXML file exceptions
        }
    }
    default void reports(ActionEvent event) {
        try {
            // Load the FXML file for the new scene
            Parent root = FXMLLoader.load(getClass().getResource("reports.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            // Set the new scene on the stage
            stage.setScene(new Scene(root));
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
            stage.getIcons().add(image);

            // (Optional) Set stage title for the new scene
            stage.setTitle("JAY Mobile");

            // Show the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle loading FXML file exceptions
        }
    }
    default void contacts(ActionEvent event) {
        try {
            // Load the FXML file for the new scene
            Parent root = FXMLLoader.load(getClass().getResource("contacts.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            // Set the new scene on the stage
            stage.setScene(new Scene(root));

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
            stage.getIcons().add(image);

            // (Optional) Set stage title for the new scene
            stage.setTitle("JAY Mobile");

            // Show the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle loading FXML file exceptions
        }
    }
    default void settings(ActionEvent event) {
        try {
            // Load the FXML file for the new scene
            Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene on the stage
            stage.setScene(new Scene(root));

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
            stage.getIcons().add(image);

            // (Optional) Set stage title for the new scene
            stage.setTitle("JAY Mobile");
            // Show the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle loading FXML file exceptions
        }
    }


}
