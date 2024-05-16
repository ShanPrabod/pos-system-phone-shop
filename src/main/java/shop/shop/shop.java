package shop.shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.util.Objects;

public class loginSystem extends Application {
    private double x = 0;
    private double y = 0;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginSystem.class.getResource("loginSystem.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png")));
        stage.getIcons().add(image);

        stage.setTitle("J Mobile");
        stage.setScene(scene);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
