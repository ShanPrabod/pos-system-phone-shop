module shop.shop {
    requires javafx.controls;
    requires javafx.fxml;


    opens shop.shop to javafx.fxml;
    exports shop.shop;
}