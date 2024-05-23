package shop.shop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboard  implements common {
    @Override
    public void dashboard(ActionEvent event) {
        common.super.dashboard(event);
    }

    @Override
    public void bill(ActionEvent event) {
        common.super.bill(event);
    }

    @Override
    public void inventory(ActionEvent event) {
        common.super.inventory(event);
    }

    @Override
    public void reports(ActionEvent event) {
        common.super.reports(event);
    }

    @Override
    public void contacts(ActionEvent event) {
        common.super.contacts(event);
    }

    @Override
    public void settings(ActionEvent event) {
        common.super.settings(event);
    }
}