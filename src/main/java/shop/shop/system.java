package shop.shop;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class system {
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
    private MenuButton billButton;

    @FXML
    private MenuItem menuItemAccessory;

    @FXML
    private MenuItem menuItemPhone;

    @FXML
    private MenuItem menuItemRepair;

    @FXML
    private AnchorPane billForm_phone;
    @FXML
    private AnchorPane billForm_accessory;

    @FXML
    private AnchorPane billForm_repair;

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
    private TextField searchBarPhoneBill;

    @FXML
    private TextField searchBarAccessoryBill;

    @FXML
    private TableView<phoneData> phoneBill_showData_Table;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_BrandName;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_Color;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_ID;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_Memory;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_ModelName;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_Price;

    @FXML
    private TableColumn<?, ?> phoneBill_showData_Table_Quantity;

    @FXML
    private TableView<accessoryData> accessoryBill_showData_Table;

    @FXML
    private TableColumn<?, ?> accessoryBill_showData_Table_ID;

    @FXML
    private TableColumn<?, ?> accessoryBill_showData_Table_brandName;

    @FXML
    private TableColumn<?, ?> accessoryBill_showData_Table_modelName;

    @FXML
    private TableColumn<?, ?> accessoryBill_showData_Table_price;

    @FXML
    private TableColumn<?, ?> accessoryBill_showData_Table_quantity;

    @FXML
    private TextField phoneBill_BrandName;

    @FXML
    private TextField phoneBill_color;

    @FXML
    private TextField phoneBill_discount;

    @FXML
    private TextField phoneBill_memory;

    @FXML
    private TextField phoneBill_modelName;

    @FXML
    private TextField phoneBill_price;

    @FXML
    private TextField phoneBill_quantity;

    @FXML
    private TextField phoneBill_warranty;

    @FXML
    private TextField phoneBillTotalAmount;
    @FXML
    private RadioButton radioButton_cash;
    @FXML
    private RadioButton radioButton_credit;
    @FXML
    private ToggleGroup paymentMethod;
    @FXML
    private Button phoneBillPrint_OKButton;

    @FXML
    private TextField accessoryBill_brandName;

    @FXML
    private TextField accessoryBill_discount;

    @FXML
    private TextField accessoryBill_modelName;

    @FXML
    private TextField accessoryBill_price;

    @FXML
    private TextField accessoryBill_quantity;

    @FXML
    private TextField accessoryBill_warranty;

    @FXML
    private TextField accessoryBillTotalAmount;

    @FXML
    private TextField phoneBillBalance;

    @FXML
    private TextField phoneBillCash;


    @FXML
    private TableView<billPhoneData> phoneBill_printData_Table;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_brandName;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_color;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_discount;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_memory;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_modelName;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_total;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_unitPrice;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_units;

    @FXML
    private TableColumn<?, ?> phoneBill_printData_Table_warranty;

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
    private TableView<billAccessoryData> accessoryBill_printData_Table;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_brandName;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_discount;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_modelName;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_total;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_unitPrice;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_units;

    @FXML
    private TableColumn<?, ?> accessoryBill_printData_Table_warranty;

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




    private ObservableList<phoneData> phoneBill_show;
    private void phoneBill_showData_Table(){
        phoneBill_show = phonesListData();

        phoneBill_showData_Table_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        phoneBill_showData_Table_BrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        phoneBill_showData_Table_ModelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        phoneBill_showData_Table_Memory.setCellValueFactory(new PropertyValueFactory<>("memory"));
        phoneBill_showData_Table_Color.setCellValueFactory(new PropertyValueFactory<>("color"));
        phoneBill_showData_Table_Price.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        phoneBill_showData_Table_Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        phoneBill_showData_Table.setItems(phoneBill_show);
    }
    public void phoneBillSelect(){
        phoneData phoneData = phoneBill_showData_Table.getSelectionModel().getSelectedItem();
        int num = phoneBill_showData_Table.getSelectionModel().getSelectedIndex();

        if ((num-1) < -1){
            return;
        }
        phoneBill_BrandName.setText(String.valueOf(phoneData.getBrandName()));
        phoneBill_modelName.setText(String.valueOf(phoneData.getModelName()));
        phoneBill_memory.setText(String.valueOf(phoneData.getMemory()));
        phoneBill_color.setText(String.valueOf(phoneData.getColor()));
        phoneBill_price.setText(String.valueOf(phoneData.getSellingPrice()));
        phoneBill_quantity.setText(String.valueOf(1));

    }
    public void phoneBillClear(){
        phoneBill_BrandName.clear();
        phoneBill_modelName.clear();
        phoneBill_memory.clear();
        phoneBill_color.clear();
        phoneBill_price.clear();
        phoneBill_quantity.clear();
        phoneBill_discount.clear();
        phoneBill_warranty.clear();
    }
    public void phoneBillSearch(){
        FilteredList<phoneData> filter = new FilteredList<>(phoneBill_show, e -> true);

        searchBarPhoneBill.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicatePhoneData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicatePhoneData.getID().toString().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getModelName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getMemory().toString().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getColor().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<phoneData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(phoneBill_showData_Table.comparatorProperty());
        phoneBill_showData_Table.setItems(sortList);
    }
    public void temp_bill_addPhones(){
        String sql = "INSERT INTO temp_bill_addphones " +
                "(`Brand Name`, `Model Name`, Memory, Color, `Unit Price`, Units, Discount, Warranty, Total) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";

        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (phoneBill_price.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter Price !");
                alert.showAndWait();
            } else if (phoneBill_quantity.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter Quantity !");
                alert.showAndWait();
            } else if (Double.parseDouble(phoneBill_price.getText()) <= 0 ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Price is less than 0 !");
                alert.showAndWait();
            } else if (Double.parseDouble(phoneBill_quantity.getText()) <= 0 ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Quantity is less than 0 !");
                alert.showAndWait();
            }  else {
                String modelName = phoneBill_modelName.getText();
                String checkSql = "SELECT * FROM `temp_bill_addphones` WHERE `Model Name` = ?";
                prepare = connect.prepareStatement(checkSql);
                prepare.setString(1, modelName);
                ResultSet resultSet = prepare.executeQuery();
                if (resultSet.next()) {
                    // show error for existing brand name
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The Model name already exists in the bill!");
                    alert.showAndWait();
                }
                else {
                    try {

                    double discount;
                    String warranty;

                    if (phoneBill_discount.getText().isEmpty()) {
                        discount = 0;
                    }else {
                        discount = Double.parseDouble(phoneBill_discount.getText());
                    }

                    if (!phoneBill_warranty.getText().isEmpty()) {
                        warranty = phoneBill_warranty.getText();
                    } else {
                        warranty = "-";
                    }

                    double unitPrice = Double.parseDouble(phoneBill_price.getText());
                    int units = Integer.parseInt(phoneBill_quantity.getText());

                    double total = (unitPrice - discount) * units;

                    String unitPrice_ = String.valueOf(unitPrice);
                    String units_ = String.valueOf(units);
                    String discount_ = String.valueOf(discount);
                    String total_ = String.valueOf(total);

                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, phoneBill_BrandName.getText());
                    prepare.setString(2, phoneBill_modelName.getText());
                    prepare.setString(3, phoneBill_memory.getText());
                    prepare.setString(4, phoneBill_color.getText());

                    prepare.setString(5, unitPrice_);
                    prepare.setString(6, units_);
                    prepare.setString(7, discount_);
                    prepare.setString(8, warranty);
                    prepare.setString(9, total_);

                    prepare.executeUpdate();

                    phoneBillClear();
                    phoneBillShowData();
                    calculateTotalPhoneBill();

                } catch (NumberFormatException e) {
                    // Show error alert for non-numeric price or quantity
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a valid Price and Quantity !");
                    alert.showAndWait();
                }}

            }
        }catch (Exception e){e.printStackTrace();
        }
    }
    public ObservableList<billPhoneData> phoneBillListData(){
        ObservableList<billPhoneData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM temp_bill_addphones";

        connect = DatabaseConnection.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            billPhoneData phone_data;

            while (result.next()){
                phone_data = new billPhoneData(
                        result.getString("Brand Name"),
                        result.getString("Model Name"),
                result.getInt("Memory"),
                result.getString("Color"),
                result.getDouble("Unit Price"),
                result.getInt("Units"),
                result.getDouble("Discount"),
                result.getString("Warranty"),
                result.getDouble("Total"));
                listData.add(phone_data);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    public ObservableList<billPhoneData> phonesBillShowList;
    public void phoneBillShowData(){
        phonesBillShowList = phoneBillListData();


        phoneBill_printData_Table_brandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        phoneBill_printData_Table_modelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        phoneBill_printData_Table_memory.setCellValueFactory(new PropertyValueFactory<>("memory"));
        phoneBill_printData_Table_color.setCellValueFactory(new PropertyValueFactory<>("color"));
        phoneBill_printData_Table_unitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        phoneBill_printData_Table_units.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        phoneBill_printData_Table_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        phoneBill_printData_Table_warranty.setCellValueFactory(new PropertyValueFactory<>("warranty"));
        phoneBill_printData_Table_total.setCellValueFactory(new PropertyValueFactory<>("total"));

        phoneBill_printData_Table.setItems(phonesBillShowList);
    }
    public void phoneBillCancel(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel this transaction?");
        alert.setTitle("Cancel Confirmation");
        alert.setHeaderText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Statement statement = connect.createStatement();
                statement.executeUpdate("DELETE FROM temp_bill_addphones");
                phoneBillClear(); // call phoneBillClear method to clear all input fields
                phoneBillShowData();
                calculateTotalPhoneBill();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void phoneBillDrop(){
        try {
            Connection connect = DatabaseConnection.connectDb();
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM temp_bill_addphones");
            statement.executeUpdate("DELETE FROM temp_bill_addaccessory");
            connect.close();
            calculateTotalPhoneBill();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePhoneBillItem() {
        // Get the selected item from the table
        billPhoneData phoneData = phoneBill_printData_Table.getSelectionModel().getSelectedItem();

        // Check if a valid item is selected
        if (phoneData == null) {
            // Show an error message or dialog indicating no item selected
            System.out.println("Please select a phone bill item to delete.");
            return;
        }

        // Confirmation dialog for deletion
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to DELETE Phone model name : " + phoneData.getModelName() + "?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            // Connect to the database
            Connection connect = DatabaseConnection.connectDb();

            try {
                // Prepared statement to prevent SQL injection
                String sql = "DELETE FROM `temp_bill_addphones` WHERE `Model Name` = ? AND `Brand Name` = ? ";
                assert connect != null;
                PreparedStatement statement = connect.prepareStatement(sql);
                statement.setString(1, phoneData.getModelName());
                statement.setString(2,phoneData.getBrandName());

                // Execute the deletion query
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    // Refresh table data (assuming phoneBillShowData() does this)
                    phoneBillShowData();
                    calculateTotalPhoneBill();
                    phoneBillBalance.clear();
                    phoneBillCash.clear();
                } else {
                    // Error message if no rows deleted
                    System.out.println("Deletion failed! No rows affected." );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void calculateTotalPhoneBill() {
        double totalAmount = 0.0;

        if (this.connect == null) {
            System.out.println("Database connection is not established.");
        }

        String query = "SELECT SUM(Total) AS totalAmount FROM temp_bill_addphones";

        try (Statement stmt = this.connect.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                totalAmount = rs.getDouble("totalAmount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        phoneBillTotalAmount.setText(String.valueOf(totalAmount));
    }

    public void updateBalancePhone() {
        try {
            double totalAmount = Double.parseDouble(phoneBillTotalAmount.getText());
            double cashAmount = Double.parseDouble(phoneBillCash.getText());
            double balanceAmount = cashAmount - totalAmount;
            phoneBillBalance.setText(String.valueOf(balanceAmount));
            if(cashAmount < totalAmount && radioButton_cash.isSelected()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Insufficient Cash");
                alert.setContentText("The cash provided is less than the total bill amount. Please enter sufficient cash.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            phoneBillBalance.setText("0.0");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Input Error");
            alert.setContentText("Please enter valid numbers only.");
            alert.showAndWait();
        }
    }



    private ObservableList<accessoryData> accessoryBill_show;
    private void accessoryBill_showData_Table(){
        accessoryBill_show = accessoryListData();

        accessoryBill_showData_Table_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        accessoryBill_showData_Table_brandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        accessoryBill_showData_Table_modelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        accessoryBill_showData_Table_price.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        accessoryBill_showData_Table_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        accessoryBill_showData_Table.setItems(accessoryBill_show);
    }
    public void accessoryBillSelect(){
        accessoryData accessoryData = accessoryBill_showData_Table.getSelectionModel().getSelectedItem();
        int num = accessoryBill_showData_Table.getSelectionModel().getSelectedIndex();

        if ((num-1) < -1){
            return;
        }
        accessoryBill_brandName.setText(String.valueOf(accessoryData.getBrandName()));
        accessoryBill_modelName.setText(String.valueOf(accessoryData.getModelName()));
        accessoryBill_price.setText(String.valueOf(accessoryData.getSellingPrice()));
        accessoryBill_quantity.setText(String.valueOf(1));
    }
    public void accessoryBillClear(){
        accessoryBill_brandName.clear();
        accessoryBill_modelName.clear();
        accessoryBill_price.clear();
        accessoryBill_quantity.clear();
        accessoryBill_discount.clear();
        accessoryBill_warranty.clear();
    }
    public void accessoryBillSearch(){
        FilteredList<accessoryData> filter = new FilteredList<>(accessoryBill_show, e -> true);

        searchBarAccessoryBill.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateAccessoryData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateAccessoryData.getID().toString().contains(searchKey)) {
                    return true;
                } else if (predicateAccessoryData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateAccessoryData.getModelName().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return false;
                }
            });
        });

        SortedList<accessoryData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(accessoryBill_showData_Table.comparatorProperty());
        accessoryBill_showData_Table.setItems(sortList);
    }
    public void temp_bill_addAccessory() {
        String sql = "INSERT INTO `temp_bill_addaccessory`(`brandName`, `modelName`, `unitPrice`, `units`, `discount`, `warranty`, `total`) VALUES (?,?,?,?,?,?,?)";

        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (accessoryBill_price.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter Price !");
                alert.showAndWait();
            } else if (accessoryBill_quantity.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter Quantity !");
                alert.showAndWait();
            } else if (Double.parseDouble(accessoryBill_price.getText()) <= 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Price is less than 0 !");
                alert.showAndWait();
            } else if (Double.parseDouble(accessoryBill_quantity.getText()) <= 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Quantity is less than 0 !");
                alert.showAndWait();
            }else {
                String modelName = accessoryBill_modelName.getText();
                String checkSql = "SELECT * FROM `temp_bill_addaccessory` WHERE `modelName` = ?";
                prepare = connect.prepareStatement(checkSql);
                prepare.setString(1, modelName);
                ResultSet resultSet = prepare.executeQuery();
                if (resultSet.next()) {
                    // show error for existing brand name
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The model name already exists in the bill!");
                    alert.showAndWait();
                }else {
                    try {

                        double discount;
                        String warranty;

                        if (accessoryBill_discount.getText().isEmpty()) {
                            discount = 0;
                        }else {
                            discount = Double.parseDouble(accessoryBill_discount.getText());
                        }

                        if (!accessoryBill_warranty.getText().isEmpty()) {
                            warranty =accessoryBill_warranty.getText();
                        } else {
                            warranty = "-";
                        }

                        double unitPrice = Double.parseDouble(accessoryBill_price.getText());
                        int units = Integer.parseInt(accessoryBill_quantity.getText());

                        double total = (unitPrice - discount) * units;

                        String unitPrice_ = String.valueOf(unitPrice);
                        String units_ = String.valueOf(units);
                        String discount_ = String.valueOf(discount);
                        String total_ = String.valueOf(total);

                        prepare = connect.prepareStatement(sql);

                        prepare.setString(1, accessoryBill_brandName.getText());
                        prepare.setString(2, accessoryBill_modelName.getText());

                        prepare.setString(3, unitPrice_);
                        prepare.setString(4, units_);
                        prepare.setString(5, discount_);
                        prepare.setString(6, warranty);
                        prepare.setString(7, total_);

                        prepare.executeUpdate();

                        accessoryBillClear();
                        accessoryBillShowData();
                        calculateTotalAccessoryBill();

                    } catch (NumberFormatException e) {
                        // Show error alert for non-numeric price or quantity
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter a valid Price and Quantity !");
                        alert.showAndWait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ObservableList<billAccessoryData> accessoryBillListData(){
        ObservableList<billAccessoryData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM temp_bill_addaccessory";

        connect = DatabaseConnection.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            billAccessoryData accessory_data;

            while (result.next()){
                accessory_data = new billAccessoryData(
                        result.getString("brandName"),
                        result.getString("modelName"),
                        result.getDouble("unitPrice"),
                        result.getInt("units"),
                        result.getDouble("discount"),
                        result.getString("warranty"),
                        result.getDouble("total"));
                listData.add(accessory_data);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    public ObservableList<billAccessoryData> accessoryBillShowList;
    public void accessoryBillShowData(){
        accessoryBillShowList = accessoryBillListData();


        accessoryBill_printData_Table_brandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        accessoryBill_printData_Table_modelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        accessoryBill_printData_Table_unitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        accessoryBill_printData_Table_units.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        accessoryBill_printData_Table_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        accessoryBill_printData_Table_warranty.setCellValueFactory(new PropertyValueFactory<>("warranty"));
        accessoryBill_printData_Table_total.setCellValueFactory(new PropertyValueFactory<>("total"));

        accessoryBill_printData_Table.setItems(accessoryBillShowList);

    }
    public void accessoryBillCancel(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel this transaction?");
        alert.setTitle("Cancel Confirmation");
        alert.setHeaderText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Statement statement = connect.createStatement();
                statement.executeUpdate("DELETE FROM temp_bill_addaccessory");
                accessoryBillClear(); // call phoneBillClear method to clear all input fields
                accessoryBillShowData();
                calculateTotalAccessoryBill();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void accessoryBillDrop(){
        try {
            Connection connect = DatabaseConnection.connectDb();
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM temp_bill_addaccessory");
            statement.executeUpdate("DELETE FROM temp_bill_addphones");
            connect.close();
            calculateTotalAccessoryBill();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAccessoryBillItem() {
        // Get the selected item from the table
        billAccessoryData accessoryData = accessoryBill_printData_Table.getSelectionModel().getSelectedItem();

        // Check if a valid item is selected
        if (accessoryData == null) {
            // Show an error message or dialog indicating no item selected
            System.out.println("Please select a phone bill item to delete.");
            return;
        }

        // Confirmation dialog for deletion
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to DELETE item : " + accessoryData.getModelName() + "?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            // Connect to the database
            Connection connect = DatabaseConnection.connectDb();

            try {
                // Prepared statement to prevent SQL injection
                String sql = "DELETE FROM `temp_bill_addaccessory` WHERE `modelName` = ? AND `brandName` = ? ";
                assert connect != null;
                PreparedStatement statement = connect.prepareStatement(sql);
                statement.setString(1, accessoryData.getModelName());
                statement.setString(2,accessoryData.getBrandName());

                // Execute the deletion query
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    // Refresh table data
                    accessoryBillShowData();
                    calculateTotalAccessoryBill();
                } else {
                    // Error message if no rows deleted
                    System.out.println("Deletion failed! No rows affected." );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void calculateTotalAccessoryBill() {
        double totalAmount = 0.0;

        if (this.connect == null) {
            System.out.println("Database connection is not established.");
        }

        String query = "SELECT SUM(total) AS totalAmount FROM temp_bill_addaccessory";

        try (Statement stmt = this.connect.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                totalAmount = rs.getDouble("totalAmount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        accessoryBillTotalAmount.setText(String.valueOf(totalAmount));
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


    public void phoneUpdate() {
        phoneData phoneData = phoneTable.getSelectionModel().getSelectedItem();
        int num = phoneTable.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }
        if (colorPhone.getText().matches("[a-zA-Z]+") &&
                memoryPhone.getText().matches("\\d+") &&
                costPricePhone.getText().matches("\\d+(\\.\\d{1,2})?") &&
                sellingPricePhone.getText().matches("\\d+(\\.\\d{1,2})?") &&
                quantityPhone.getText().matches("\\d+")) {
            try {
                Alert alert;
                if ((brandNamePhone.getText().isEmpty()
                        || modelNamePhone.getText().isEmpty()
                        || memoryPhone.getText().isEmpty()
                        || colorPhone.getText().isEmpty()
                        || costPricePhone.getText().isEmpty()
                        || sellingPricePhone.getText().isEmpty()
                        || quantityPhone.getText().isEmpty())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields");
                    alert.showAndWait();
                } else if (Double.parseDouble(sellingPricePhone.getText()) < Double.parseDouble(costPricePhone.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Selling Price Is Less Than Cost Price!");
                    alert.showAndWait();

                    phonesShowListData();
                    phoneDataReset();
                } else if (brandNamePhone.getText().equals(phoneData.getBrandName()) &&
                        modelNamePhone.getText().equals(phoneData.getModelName()) &&
                        colorPhone.getText().equals(phoneData.getColor()) &&
                        Integer.parseInt(memoryPhone.getText()) == phoneData.getMemory()) {

                    String sql = "UPDATE phones SET costPricePhone = ?, sellingPricePhone = ?, quantityPhone = ? WHERE ID = ?";

                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, costPricePhone.getText());
                    prepare.setString(2, sellingPricePhone.getText());
                    prepare.setString(3, quantityPhone.getText());
                    prepare.setInt(4, phoneData.getID());

                    prepare.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    phonesShowListData();
                    phoneDataReset();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Brand Name/Model Name/Phone Color/phone Memory ,can Not be Changed. Instead You Can Use Delete Button!");
                    alert.showAndWait();

                    phonesShowListData();
                    phoneDataReset();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Enter Correct Data Types !");
            alert.showAndWait();

            phonesShowListData();
            phoneDataReset();
        }
    }
    public void accessoryUpdate() {
        accessoryData accessoryData = accessoryTable.getSelectionModel().getSelectedItem();
        int num = accessoryTable.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }

        if (!costPriceAccessory.getText().matches("\\d+(\\.\\d{1,2})?") ||
                !sellingPriceAccessory.getText().matches("\\d+(\\.\\d{1,2})?") ||
                !quantityAccessory.getText().matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Enter correct data types for cost price, selling price, and quantity.");
            alert.showAndWait();
            return;
        }

        if (brandNameAccessory.getText().isEmpty() ||
                modelNameAccessory.getText().isEmpty() ||
                costPriceAccessory.getText().isEmpty() ||
                sellingPriceAccessory.getText().isEmpty() ||
                quantityAccessory.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields.");
            alert.showAndWait();
            return;
        }

        if (Double.parseDouble(sellingPriceAccessory.getText()) < Double.parseDouble(costPriceAccessory.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Selling price is less than cost price!");
            alert.showAndWait();
            return;
        }

        if (brandNameAccessory.getText().equals(accessoryData.getBrandName()) && modelNameAccessory.getText().equals(accessoryData.getModelName())) {
            String sql = "UPDATE accessories SET costPriceAccessory = ?, sellingPriceAccessory = ?, quantityAccessory = ? WHERE ID = ?";

            try (PreparedStatement prepare = connect.prepareStatement(sql)) {
                prepare.setString(1, costPriceAccessory.getText());
                prepare.setString(2, sellingPriceAccessory.getText());
                prepare.setString(3, quantityAccessory.getText());
                prepare.setInt(4, accessoryData.getID());
                prepare.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully updated!");
                alert.showAndWait();

                accessoryShowListData();
                accessoryDataReset();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Brand name/model name cannot be changed. Instead, you can use the delete button!");
            alert.showAndWait();

            accessoryShowListData();
            accessoryDataReset();
        }
    }


    public void phoneDelete(){
        phoneData phoneData = phoneTable.getSelectionModel().getSelectedItem();
        int num = phoneTable.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }

        String sql ="DELETE FROM phones WHERE ID = " + phoneData.getID();
        connect = DatabaseConnection.connectDb();

        try {
            Alert alert;
            if ((brandNamePhone.getText().isEmpty()
                    || modelNamePhone.getText().isEmpty()
                    || memoryPhone.getText().isEmpty()
                    || colorPhone.getText().isEmpty()
                    || costPricePhone.getText().isEmpty()
                    || sellingPricePhone.getText().isEmpty()
                    || quantityPhone.getText().isEmpty())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Phone ID: " + phoneData.getID() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    phonesShowListData();
                    phoneDataReset();
                }
            }
        }catch (Exception e){e.printStackTrace();}

    }
    public void accessoryDelete(){
        accessoryData accessoryData = accessoryTable.getSelectionModel().getSelectedItem();
        int num = accessoryTable.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }

        String sql = "DELETE FROM accessories WHERE ID = " + accessoryData.getID();
        connect = DatabaseConnection.connectDb();

        try {
            Alert alert;
            if (brandNameAccessory.getText().isEmpty() ||
                    modelNameAccessory.getText().isEmpty() ||
                    costPriceAccessory.getText().isEmpty() ||
                    sellingPriceAccessory.getText().isEmpty() ||
                    quantityAccessory.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();
            }else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure, you want to DELETE Accessory ID: " + accessoryData.getID() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    accessoryShowListData();
                    accessoryDataReset();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public void phoneSearch() {
        FilteredList<phoneData> filter = new FilteredList<>(phoneList, e -> true);

        searchBarPhone.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicatePhoneData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicatePhoneData.getID().toString().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getModelName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getMemory().toString().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePhoneData.getColor().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<phoneData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(phoneTable.comparatorProperty());
        phoneTable.setItems(sortList);
    }
    public void accessorySearch() {
        FilteredList<accessoryData> filter = new FilteredList<>(accessoryList, e -> true);

        searchBarAccessory.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateAccessoryData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateAccessoryData.getID().toString().contains(searchKey)) {
                    return true;
                } else if (predicateAccessoryData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateAccessoryData.getModelName().toLowerCase().contains(searchKey)) {
                    return true;
                }  else {
                    return false;
                }
            });
        });

        SortedList<accessoryData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(accessoryTable.comparatorProperty());
        accessoryTable.setItems(sortList);
    }

    public void phonesChart(){
        String sql = "SELECT brandNamePhone, quantityPhone\n" +
                "FROM phones\n" +
                "GROUP BY brandNamePhone\n" +
                "ORDER BY quantityPhone DESC;\n";

    }



    public void switchForm(ActionEvent event){
        if (event.getSource() == dashboardButton){
            dashBoardForm.setVisible(true);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);

            dashboardButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            billButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            phoneBillDrop();
            accessoryBillDrop();

        } else if (event.getSource() == menuItemPhone) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(true);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);

            billButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            dashboardButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            phoneBill_showData_Table();
            phoneBillSearch();
            phoneBillDrop();
            accessoryBillDrop();

        } else if (event.getSource() == menuItemAccessory) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(true);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);

            billButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            dashboardButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            accessoryBill_showData_Table();
            accessoryBillSearch();
            phoneBillDrop();
            accessoryBillDrop();

        } else if (event.getSource() == menuItemRepair) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(true);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);

            billButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            dashboardButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            phoneBillDrop();
            accessoryBillDrop();

        }else if (event.getSource() == inventoryButton) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(true);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);

            inventoryButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            billButton.setStyle("-fx-background-color:transparent");
            dashboardButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            phonesShowListData();
            accessoryShowListData();
            phoneSearch();
            accessorySearch();
            phoneBillDrop();
            accessoryBillDrop();

        }else if (event.getSource() == reportsButton) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(true);
            contactsForm.setVisible(false);
            settingsForm.setVisible(false);

            reportsButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            billButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            dashboardButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            phoneBillDrop();
            accessoryBillDrop();

        }else if (event.getSource() == contactsButton) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(true);
            settingsForm.setVisible(false);

            contactsButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            billButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            dashboardButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            settingsButton.setStyle("-fx-background-color:transparent");

            phoneBillDrop();
            accessoryBillDrop();

        }else if (event.getSource() == settingsButton) {
            dashBoardForm.setVisible(false);
            billForm_accessory.setVisible(false);
            billForm_phone.setVisible(false);
            billForm_repair.setVisible(false);
            inventoryForm.setVisible(false);
            reportForm.setVisible(false);
            contactsForm.setVisible(false);
            settingsForm.setVisible(true);

            settingsButton.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            billButton.setStyle("-fx-background-color:transparent");
            inventoryButton.setStyle("-fx-background-color:transparent");
            dashboardButton.setStyle("-fx-background-color:transparent");
            contactsButton.setStyle("-fx-background-color:transparent");
            reportsButton.setStyle("-fx-background-color:transparent");
            phoneBillDrop();
            accessoryBillDrop();

        }
    }
}
