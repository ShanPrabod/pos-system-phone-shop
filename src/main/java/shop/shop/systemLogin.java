package shop.shop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class systemLogin {

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    public void loginAdmin(){
        String sql = "SELECT * FROM `admin` WHERE username = ? and password = ?";
        connect = DatabaseConnection.connectDb();

        try {
            prepare =  connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();
            Alert alert;

            if (username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields !");
                alert.showAndWait();
            }else {
                if (result.next()){
                    loginButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("system.fxml"));
                    Parent root = loader.load();

                    // Get the controller associated with the FXML file
                    system controller = loader.getController();
                    controller.setConnect(connect); // Pass the connection

                    controller.dashBoard_phones(); // Call the method
                    controller.dashBoard_accessory();
                    controller.dashBoard_repair();
                    controller.dashBoard_sale();
                    controller.dashBoard_profit();

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
                    stage.getIcons().add(image);

                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password ");
                    alert.showAndWait();
                }
            }

        }catch (Exception e){e.printStackTrace();}
    }



}













