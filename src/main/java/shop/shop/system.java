package shop.shop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class inventory implements common{
    @FXML
    private TableView<accessoryData> accessoryTable;

    @FXML
    private TableColumn<?, ?> accessoryTableBrandName;

    @FXML
    private TableColumn<?, ?> accessoryTableCostPrice;

    @FXML
    private TableColumn<?, ?> accessoryTableId;

    @FXML
    private TableColumn<?, ?> accessoryTableModelName;

    @FXML
    private TableColumn<?, ?> accessoryTableQuantity;

    @FXML
    private TableColumn<?, ?> accessoryTableSellingPrice;

    @FXML
    private Button addButtonAccessory;

    @FXML
    private Button addButtonPhone;

    @FXML
    private Button billButton;

    @FXML
    private AnchorPane billForm;

    @FXML
    private TextField brandNameAccessory;

    @FXML
    private TextField brandNamePhone;

    @FXML
    private Button clearButtonAccessory;

    @FXML
    private Button clearButtonPhone;

    @FXML
    private TextField colorPhone;

    @FXML
    private Button contactsButton;

    @FXML
    private AnchorPane contactsForm;

    @FXML
    private TextField costPriceAccessory;

    @FXML
    private TextField costPricePhone;

    @FXML
    private AnchorPane dashBoardForm;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button deleteButtonAccessory;

    @FXML
    private Button deleteButtonPhone;

    @FXML
    private Button inventoryButton;

    @FXML
    private AnchorPane inventoryForm;

    @FXML
    private TextField memoryPhone;

    @FXML
    private TextField modelNameAccessory;

    @FXML
    private TextField modelNamePhone;

    @FXML
    private TableView<phoneData> phoneTable;

    @FXML
    private TableColumn<?, ?> phoneTableBrandName;

    @FXML
    private TableColumn<?, ?> phoneTableColor;

    @FXML
    private TableColumn<?, ?> phoneTableCostPrice;

    @FXML
    private TableColumn<?, ?> phoneTableId;

    @FXML
    private TableColumn<?, ?> phoneTableMemory;

    @FXML
    private TableColumn<?, ?> phoneTableModelName;

    @FXML
    private TableColumn<?, ?> phoneTableQuantity;

    @FXML
    private TableColumn<?, ?> phoneTableSellingPrice;

    @FXML
    private TextField quantityAccessory;

    @FXML
    private TextField quantityPhone;

    @FXML
    private AnchorPane reportForm;

    @FXML
    private Button reportsButton;

    @FXML
    private TextField searchBarAccessory;

    @FXML
    private TextField searchBarPhone;

    @FXML
    private TextField sellingPriceAccessory;

    @FXML
    private TextField sellingPricePhone;

    @FXML
    private Button settingsButton;

    @FXML
    private AnchorPane settingsForm;

    @FXML
    private Button updateButtonAccessory;

    @FXML
    private Button updateButtonPhone;
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    public void addPhones(){
        String sql = "INSERT INTO phones"
                +"(brandNamePhone, modelNamePhone, memoryPhone, colorPhone, costPricePhone, sellingPricePhone, quantityPhone) "
                +"VALUES(?,?,?,?,?,?,?)";

        connect = DatabaseConnection.connectDb();

        try {
            Alert alert;
            if (brandNamePhone.getText().isEmpty()
            ||modelNamePhone.getText().isEmpty()
            ||memoryPhone.getText().isEmpty()
            ||colorPhone.getText().isEmpty()
            ||costPricePhone.getText().isEmpty()
            ||sellingPricePhone.getText().isEmpty()
            ||quantityPhone.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                String check = "SELECT * FROM phones WHERE " +
                        "brandNamePhone = '" +brandNamePhone.getText()+"' AND " +
                        "modelNamePhone = '"+ modelNamePhone.getText()+"' AND " +
                        "memoryPhone = '"+ memoryPhone.getText()+"' AND " +
                        "colorPhone = '"+ colorPhone.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Entered data already exists in the table:");
                    alert.showAndWait();
                }else {
                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, brandNamePhone.getText());
                    prepare.setString(2, modelNamePhone.getText());
                    prepare.setString(3, memoryPhone.getText());
                    prepare.setString(4, colorPhone.getText());
                    prepare.setString(5, costPricePhone.getText());
                    prepare.setString(6, sellingPricePhone.getText());
                    prepare.setString(7, quantityPhone.getText());

                    prepare.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    phonesShowListData();
                }
            }
        }catch (Exception e){e.printStackTrace();
        }
    }

    public ObservableList<phoneData> phonesListData(){
        ObservableList<phoneData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM phones";

        connect = DatabaseConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            phoneData phoneD;

            while (result.next()){
                phoneD = new phoneData(result.getInt("ID"),
                        result.getString("brandNamePhone"),
                        result.getString("modelNamePhone"),
                        result.getInt("memoryPhone"),
                        result.getString("colorPhone"),
                        result.getDouble("costPricePhone"),
                        result.getDouble("sellingPricePhone"),
                        result.getInt("quantityPhone"));
                listData.add(phoneD);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<phoneData> phoneList;
    public void phonesShowListData(){
        phoneList = phonesListData();

        phoneTableId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        phoneTableBrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        phoneTableModelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        phoneTableMemory.setCellValueFactory(new PropertyValueFactory<>("memory"));
        phoneTableColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        phoneTableCostPrice.setCellValueFactory(new PropertyValueFactory<>("costPrice"));
        phoneTableSellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        phoneTableQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        phoneTable.setItems(phoneList);
    }
    public void addAccessories(){
        String sql = "INSERT INTO accessories"
                +"(brandNameAccessory, modelNameAccessory, costPriceAccessory, sellingPriceAccessory, quantityAccessory) "
                +"VALUES(?,?,?,?,?)";

        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if(brandNameAccessory.getText().isEmpty()||
            modelNameAccessory.getText().isEmpty()||
            costPriceAccessory.getText().isEmpty()||
            sellingPriceAccessory.getText().isEmpty()||
            quantityAccessory.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                String check = "SELECT * FROM accessories WHERE " +
                        "brandNameAccessory = '" +brandNameAccessory.getText()+"' AND " +
                        "modelNameAccessory = '"+ modelNameAccessory.getText() +"'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Entered data already exists in the table:");
                    alert.showAndWait();
                }else{
                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, brandNameAccessory.getText());
                    prepare.setString(2, modelNameAccessory.getText());
                    prepare.setString(3,costPriceAccessory.getText());
                    prepare.setString(4, sellingPriceAccessory.getText());
                    prepare.setString(5, quantityAccessory.getText());

                    prepare.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    accessoryShowListData();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<accessoryData> accessoryListData(){
        ObservableList<accessoryData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM accessories";

        connect = DatabaseConnection.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            accessoryData accessoryD;

            while (result.next()){
                accessoryD = new accessoryData(result.getInt("ID"),
                        result.getString("brandNameAccessory"),
                        result.getString("modelNameAccessory"),
                        result.getDouble("costPriceAccessory"),
                        result.getDouble("sellingPriceAccessory"),
                        result.getInt("quantityAccessory"));
                listData.add(accessoryD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    public ObservableList<accessoryData> accessoryList;
    public void accessoryShowListData(){
        accessoryList = accessoryListData();

        accessoryTableId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        accessoryTableBrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        accessoryTableModelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        accessoryTableCostPrice.setCellValueFactory(new PropertyValueFactory<>("costPrice"));
        accessoryTableSellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        accessoryTableQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        accessoryTable.setItems(accessoryList);
    }

    public void phoneDataReset(){
        modelNamePhone.clear();
        brandNamePhone.clear();
        memoryPhone.clear();
        colorPhone.clear();
        costPricePhone.clear();
        sellingPricePhone.clear();
        quantityPhone.clear();
    }
    public void accessoryDataReset(){
        modelNameAccessory.clear();
        brandNameAccessory.clear();
        costPriceAccessory.clear();
        sellingPriceAccessory.clear();
        quantityAccessory.clear();
    }

    public void phoneSelect(){
        phoneData phoneData = phoneTable.getSelectionModel().getSelectedItem();
        int num = phoneTable.getSelectionModel().getSelectedIndex();

        if ((num-1) < -1){
            return;
        }
        brandNamePhone.setText(String.valueOf(phoneData.getBrandName()));
        modelNamePhone.setText(String.valueOf(phoneData.getModelName()));
        memoryPhone.setText(String.valueOf(phoneData.getMemory()));
        colorPhone.setText(String.valueOf(phoneData.getColor()));
        costPricePhone.setText(String.valueOf(phoneData.getCostPrice()));
        sellingPricePhone.setText(String.valueOf(phoneData.getSellingPrice()));
        quantityPhone.setText(String.valueOf(phoneData.getQuantity()));
    }
    public void accessorySelect(){
        accessoryData accessoryData = accessoryTable.getSelectionModel().getSelectedItem();
        int num = accessoryTable.getSelectionModel().getSelectedIndex();

        if ((num-1) < -1) {
            return;
        }
        brandNameAccessory.setText(String.valueOf(accessoryData.getBrandName()));
        modelNameAccessory.setText(String.valueOf(accessoryData.getModelName()));
        costPriceAccessory.setText(String.valueOf(accessoryData.getCostPrice()));
        sellingPriceAccessory.setText(String.valueOf(accessoryData.getSellingPrice()));
        quantityAccessory.setText(String.valueOf(accessoryData.getQuantity()));
    }

    public void switchForm(ActionEvent event){
        if (event.getSource() == dashboardButton){
            dashBoardForm.setVisible(true);
            billForm.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);
        } else if (event.getSource() == billButton) {
            dashBoardForm.setVisible(false);
            billForm.setVisible(true);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);
        }else if (event.getSource() == inventoryButton) {
            dashBoardForm.setVisible(false);
            billForm.setVisible(false);
            inventoryForm.setVisible(true);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);
        }else if (event.getSource() == reportForm) {
            dashBoardForm.setVisible(false);
            billForm.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(true);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);
        }else if (event.getSource() == contactsForm) {
            dashBoardForm.setVisible(false);
            billForm.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(true);
            settingsForm.setVisible(false);
        }else if (event.getSource() == settingsForm) {
            dashBoardForm.setVisible(false);
            billForm.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(true);
        }
    }

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
