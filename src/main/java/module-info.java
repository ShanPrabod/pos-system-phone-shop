module shop.shop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;


    opens shop.shop to javafx.fxml;
    exports shop.shop;
}