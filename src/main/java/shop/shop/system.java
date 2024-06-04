package shop.shop;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private RadioButton radioButton_cash_phone;
    @FXML
    private RadioButton radioButton_credit_phone;
    @FXML
    private ToggleGroup paymentMethodPhone;
    @FXML
    private Button phoneBillPrint_OKButton;

    @FXML
    private TextField phoneBillCustomer;
    @FXML
    private TextField phoneBillCustomerMobile;

    @FXML
    private TextField accessoryBillBalance;
    @FXML
    private TextField accessoryBillCash;
    @FXML
    private TextField accessoryBillCustomer;
    @FXML
    private TextField accessoryBillCustomerMobile;
    @FXML
    private TextField accessoryBillCashier;

    @FXML
    private RadioButton radioButton_cash_accessory;
    @FXML
    private RadioButton radioButton_credit_accessory;
    @FXML
    private ToggleGroup paymentMethodAccessory;
    @FXML
    private Button accessoryBillPrint_OKButton;

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
    private TextField phoneBillCashier;


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
    public void temp_bill_addPhones() throws SQLException {
        String sql = "INSERT INTO temp_bill_addphones " +
                "(`Brand Name`, `Model Name`, Memory, Color, `Unit Price`, Units, Discount, Warranty, Total) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        connect = DatabaseConnection.connectDb();

        String query = "SELECT `quantityPhone` FROM `phones` WHERE `brandNamePhone` =? AND `modelNamePhone` =?";
        assert connect != null;
        PreparedStatement pstmt = connect.prepareStatement(query);
        pstmt.setString(1, phoneBill_BrandName.getText());
        pstmt.setString(2, phoneBill_modelName.getText());
        ResultSet rs = pstmt.executeQuery();
        int availableQuantity = 0;
        if (rs.next()) {
            availableQuantity = rs.getInt("quantityPhone");
        }
        rs.close();
        pstmt.close();

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
            } else if (availableQuantity < 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The selected item is out of stock!");
                alert.showAndWait();
            } else if (availableQuantity < Integer.parseInt(phoneBill_quantity.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The selected item is not available in the required quantity!");
                alert.showAndWait();
            }else {
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
                        // Check the quantity in the database table
                        String brandName = phoneBill_BrandName.getText();
                        int quantity = Integer.parseInt(phoneBill_quantity.getText());
                        if (!checkQuantityPhone(modelName, brandName, quantity)) {
                            return;
                        }

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
    public boolean checkQuantityPhone(String modelName, String brandName, int quantity) {
        String checkSql = "SELECT `quantityPhone` FROM `phones` WHERE `modelNamePhone` = ? AND `brandNamePhone` = ?";
        try {
            PreparedStatement prepare = connect.prepareStatement(checkSql);
            prepare.setString(1, modelName);
            prepare.setString(2, brandName);
            ResultSet resultSet = prepare.executeQuery();
            if (resultSet.next()) {
                int unitsInDatabase = resultSet.getInt("quantityPhone");
                if (unitsInDatabase < quantity) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The quantity is not sufficient!");
                    alert.showAndWait();
                    return false;
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The model name and brand name are not in the database!");
                alert.showAndWait();
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
                phoneBillCash.clear();
                phoneBillBalance.clear();
                phoneBillCustomer.clear();
                phoneBillCustomerMobile.clear();
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
            if(cashAmount < totalAmount && radioButton_cash_phone.isSelected()){
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
    public void updateBalanceAccessory() {
        try {
            double totalAmount = Double.parseDouble(accessoryBillTotalAmount.getText());
            double cashAmount = Double.parseDouble(accessoryBillCash.getText());
            double balanceAmount = cashAmount - totalAmount;
            accessoryBillBalance.setText(String.valueOf(balanceAmount));
            if(cashAmount < totalAmount && radioButton_cash_accessory.isSelected()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Insufficient Cash");
                alert.setContentText("The cash provided is less than the total bill amount. Please enter sufficient cash.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            accessoryBillCash.setText("0.0");
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
    public void temp_bill_addAccessory() throws SQLException {
        String sql = "INSERT INTO `temp_bill_addaccessory`(`brandName`, `modelName`, `unitPrice`, `units`, `discount`, `warranty`, `total`) VALUES (?,?,?,?,?,?,?)";

        connect = DatabaseConnection.connectDb();

        String query = "SELECT `quantityAccessory` FROM `accessories` WHERE `brandNameAccessory` =? AND `modelNameAccessory` =?";
        assert connect != null;
        PreparedStatement pstmt = connect.prepareStatement(query);
        pstmt.setString(1, phoneBill_BrandName.getText());
        pstmt.setString(2, phoneBill_modelName.getText());
        ResultSet rs = pstmt.executeQuery();
        int availableQuantity = 0;
        if (rs.next()) {
            availableQuantity = rs.getInt("quantityAccessory");
        }
        rs.close();
        pstmt.close();
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
            }else if (availableQuantity < 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The selected item is out of stock!");
                alert.showAndWait();
            } else if (availableQuantity < Integer.parseInt(accessoryBill_quantity.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The selected item is not available in the required quantity!");
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
                    try {// Check the quantity in the database table
                        String brandName = accessoryBill_brandName.getText();
                        int quantity = Integer.parseInt(accessoryBill_quantity.getText());
                        if (!checkQuantityAccessory(modelName, brandName, quantity)) {
                            return;
                        }
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
    public boolean checkQuantityAccessory(String modelName, String brandName, int quantity) {
        String checkSql = "SELECT `quantityAccessory` FROM `accessories` WHERE `modelNameAccessory` = ? AND `brandNameAccessory` = ?";
        try {
            PreparedStatement prepare = connect.prepareStatement(checkSql);
            prepare.setString(1, modelName);
            prepare.setString(2, brandName);
            ResultSet resultSet = prepare.executeQuery();
            if (resultSet.next()) {
                int unitsInDatabase = resultSet.getInt("quantityAccessory");
                if (unitsInDatabase < quantity) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The quantity is not sufficient!");
                    alert.showAndWait();
                    return false;
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The model name and brand name are not in the database!");
                alert.showAndWait();
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
                accessoryBillCash.clear();
                accessoryBillBalance.clear();
                accessoryBillCustomer.clear();
                accessoryBillCustomerMobile.clear();
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
                    accessoryBillBalance.clear();
                    accessoryBillCash.clear();
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







    public void phoneBillPDF_() {
        if (Objects.equals(phoneBillCash.getText(), "")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter the Cash !");
            alert.showAndWait();
        } else if (Double.parseDouble(phoneBillCash.getText()) != Double.parseDouble(phoneBillTotalAmount.getText()) + Double.parseDouble(phoneBillBalance.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter the Cash Correctly!");
            alert.showAndWait();
        } else {
            try {
                List<BillingItem_phones> items_ = fetchBillingItems_phones();
                String revenueProfit = generateReport_phones(items_);
                phoneBill_showData_Table();

                // Get the desktop path
                Path desktopPath = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Documents");

                // Create the Bills folder if it does not exist
                Path billsPath = desktopPath.resolve("Phone Invoices");
                if (!Files.exists(billsPath)) {
                    Files.createDirectories(billsPath); // Changed from createDirectory to createDirectories
                }

                // Get the current date
                LocalDate date = LocalDate.now();
                LocalDateTime time = LocalDateTime.now();

                // Create the PDF file name with the current date and a unique auto-incrementing number
                String fileName = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "_" + time.format(DateTimeFormatter.ofPattern("HH-mm-ss")) + ".pdf";

                // Create the PDF file
                String path = billsPath.resolve(fileName).toString();
                PdfWriter pdfWriter = new PdfWriter(path);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);

                //Database table row count
                connect = DatabaseConnection.connectDb();
                String query = "SELECT COUNT(*) FROM temp_bill_addphones" ;
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                int rowCount;
                if (rs.getInt(1) == 0){
                    rowCount = 1;
                }else {
                    rowCount = rs.getInt(1) *9;
                }

                rs.close();

                // Define the page width with the specified width and add margins
                float widthInPoints = 80 * 2.83465f; // 80mm to points
                float marginInPoints = 4 * 2.83465f; // 4mm to points
                PageSize pageSize = new PageSize(widthInPoints, calculatePageHeight_phones(rowCount));
                pdfDocument.setDefaultPageSize(pageSize);
                Document document = new Document(pdfDocument, pageSize);
                document.setMargins(0, marginInPoints, 0, marginInPoints);

                // Fetch data from the database
                List<BillingItem_phones> items = fetchBillingItems_phones();

                //Add logo
                String imagePath = "images\\logo.png";
                ImageData imageData = ImageDataFactory.create(imagePath);
                Image image = new Image(imageData);
                image.setHeight(50);
                image.setWidth(50);
                image.setHorizontalAlignment(HorizontalAlignment.CENTER);
                document.add(image);


                // Add title to the document
                document.add(new Paragraph("J Mobiles" +
                        "\nNO.  ," +
                        "\nAnuradhapura Rd," +
                        "\nDambulla." +
                        "\n074-1558571" +
                        "\n--------------------------------------------").setTextAlignment(TextAlignment.CENTER).setFontSize(8).setFixedLeading(12));
                String cashier_ = "J Mobile";
                if (!Objects.equals(phoneBillCashier.getText(), "")){
                    cashier_ = phoneBillCashier.getText();
                }
                document.add(new Paragraph("Cashier : " + cashier_ + "             "
                        + LocalDate.now() +
                        "\n----------------------------------------------------------------------------").setFontSize(8).setTextAlignment(TextAlignment.CENTER).setFixedLeading(12));

                if (!Objects.equals(phoneBillCustomer.getText(), "") || !Objects.equals(phoneBillCustomerMobile.getText(),"")){
                    String customer = "-" , customerMobile = "-";
                    if(!Objects.equals(phoneBillCustomer.getText(), "")) {
                        customer = phoneBillCustomer.getText();}
                    if(!Objects.equals(phoneBillCustomerMobile.getText(), "")) {
                        customerMobile = phoneBillCustomerMobile.getText();}
                    document.add(new Paragraph("Customer : " + customer + "              Mobile : " +
                            customerMobile +
                            "----------------------------------------------------------------------------").setFontSize(8).setFixedLeading(12));
                }
                //null comment

                // Add table rows
                for (BillingItem_phones item : items) {
                    addHeaderLine_phones(document, "Brand Name", item.getBrandName());
                    addHeaderLine_phones(document, "Model Name",item.getModelName());
                    addHeaderLine_phones(document, "Memory", String.valueOf(item.getMemory()) + " GB");
                    addHeaderLine_phones(document, "Color",item.getColor());
                    addHeaderLine_phones(document, "Unit Price", String.valueOf(item.getUnitPrice()));
                    addHeaderLine_phones(document, "Units", String.valueOf(item.getUnits()));
                    if (!Objects.equals(String.valueOf(item.getDiscount()),"0.0")){
                        addHeaderLine_phones(document, "Discount", String.valueOf(item.getDiscount()));
                    }
                    if (!Objects.equals(String.valueOf(item.getWarranty()),"-")){
                        addHeaderLine_phones(document, "Warranty",item.getWarranty());
                    }
                    document.add(new Paragraph("-----------------------------------------------------------\n").setFontSize(8));
                }

                // Add total at the bottom
                document.add(new Paragraph("Cash:  Rs. " + phoneBillCash.getText() + "00"+
                        "\nBalance:  Rs. " + phoneBillBalance.getText() + "0" +
                        "\n----------------------------------------------------------------------------" +
                        "\nTotal:  Rs. " + calculateTotal_phones(items) + "0" ).setFontSize(8).setFixedLeading(12));
                document.add(new Paragraph("----------------------------------------------------------------------------" +
                        "*** Thank You, Come Again ! ***" +
                        "\n----------------------------------------------------------------------------" +
                        "\nNXTGen Solutions" +
                        "\nshanprabodh@icloud.com" +
                        "\nWhatsapp : 071-2823447").setFontSize(8).setFixedLeading(12).setTextAlignment(TextAlignment.CENTER));

                // Close the PDF file
                document.close();

                // Show a success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success Message");
                alert.setHeaderText(null);
                alert.setContentText("The PDF file has been created successfully!\n" + billsPath.toAbsolutePath().toString() + "\n" + revenueProfit);
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();

                // Show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while creating the PDF file!");
                alert.showAndWait();
            }
        }

    }

    // Helper method to fetch billing items from the database
    private List<BillingItem_phones> fetchBillingItems_phones() throws SQLException {
        List<BillingItem_phones> items = new ArrayList<>();
        connect = DatabaseConnection.connectDb();
        String query = "SELECT * FROM temp_bill_addphones";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            BillingItem_phones item = new BillingItem_phones();
            item.setBrandName(rs.getString("Brand Name"));
            item.setModelName(rs.getString("Model Name"));
            item.setMemory(rs.getInt("Memory"));
            item.setColor(rs.getString("Color"));
            item.setUnitPrice(rs.getDouble("Unit Price"));
            item.setUnits(rs.getInt("Units"));
            item.setDiscount(rs.getDouble("Discount"));
            item.setWarranty(rs.getString("Warranty"));
            item.setTotal(rs.getDouble("Total"));

            items.add(item);
        }

        rs.close();
        stmt.close();

        return items;
    }

    // Helper method to add table headers
    private void addHeaderLine_phones(Document document, String header, String content) {
        Paragraph headerParagraph = new Paragraph();
        headerParagraph.add(new Text(header +"  :  " ).setBold().setFontSize(8)).add(content).setFontSize(8);
        document.add(headerParagraph);
    }

    // Helper method to calculate the total amount
    private double calculateTotal_phones(List<BillingItem_phones> items) {
        return items.stream().mapToDouble(BillingItem_phones::getTotal).sum();
    }

    // BillingItem class to represent each item in the billing details
    public static class BillingItem_phones {
        private String brandName;
        private String modelName;
        private int memory;
        private String color;
        private double unitPrice;
        private int units;
        private double discount;
        private String warranty;
        private double total;

        // Getters and setters for BillingItem properties

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getUnits() {
            return units;
        }

        public void setUnits(int units) {
            this.units = units;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public String getWarranty() {
            return warranty;
        }

        public void setWarranty(String warranty) {
            this.warranty = warranty;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }
    private float calculatePageHeight_phones(int rowCount) throws SQLException {
        float height = 50; // initial height for top and bottom (image, address+cashier, Divider Line, bottom, company)

        if (!Objects.equals(phoneBillCustomer.getText(), "") ||!Objects.equals(phoneBillCustomerMobile.getText(), "")) {
            height += 24; // add extra space for customer info
        }

        float contentHeight = 0;
        for (BillingItem_phones item : fetchBillingItems_phones()) {
            contentHeight += 12 * (item.getDiscount() == 0.0? 7 : 8); // calculate height of each row
        }

        height += contentHeight; // add content height to total height

        height += 50; // add some padding to the bottom of the page

        return height;
    }

    private String generateReport_phones(List<BillingItem_phones> items) throws SQLException {
        connect = DatabaseConnection.connectDb();
        String query = "SELECT * FROM temp_bill_addphones";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        double totalRevenue;
        if (!phoneBillTotalAmount.getText().isEmpty()) {
            totalRevenue = Double.parseDouble(phoneBillTotalAmount.getText());
        } else {
            totalRevenue = 0;
        }

        int totalQuantity = 0;
        double totalDiscount = 0;

        while (rs.next()) {
            String brandName = rs.getString("Brand Name");
            String modelName = rs.getString("Model Name");
            int memory = rs.getInt("Memory");
            String color = rs.getString("Color");
            double unitPrice = rs.getDouble("Unit Price");
            int units = rs.getInt("Units");
            double discount = rs.getDouble("Discount");


            // Update quantity in phones table
            updateQuantity_phones(brandName, modelName, memory, color, units);

            totalQuantity += units;
            totalDiscount += discount * units;
        }

        rs.close();
        stmt.close();

        double totalProfit = 0;
        for (BillingItem_phones item : items) {
            String brandName = item.getBrandName();
            String modelName = item.getModelName();
            int memory = item.getMemory();
            String color = item.getColor();
            double unitPrice = item.getUnitPrice();
            int units = item.getUnits();

            // Get the cost price from the phones table
            double costPrice = getCostPrice_phones(brandName, modelName, memory, color);

            // Calculate the profit for this item
            double profit = (unitPrice - costPrice) * units;

            // Add the profit to the total profit
            totalProfit += profit;
        }
        totalProfit -= totalDiscount;

        String sql = "INSERT INTO `profitrevenuephones`(`revenue`, `profit`, `quantity`) VALUES (?,?,?)";
        connect = DatabaseConnection.connectDb();
        try {
            prepare = connect.prepareStatement(sql);

            prepare.setString(1, String.valueOf(totalRevenue));
            prepare.setString(2,String.valueOf(totalProfit));
            prepare.setString(3,String.valueOf(totalQuantity));

            prepare.executeUpdate();
        }catch (Exception e){
            System.out.println("ERROR while saving data in profit/revenue");
        }

        return "Revenue : Rs." + totalRevenue + "\nProfit : Rs." + totalProfit + "\nQuantity : "+ totalQuantity;
    }
    private double getCostPrice_phones(String brandName, String modelName, int memory, String color) throws SQLException {
        connect = DatabaseConnection.connectDb();
        String query = "SELECT costPricePhone FROM phones WHERE brandNamePhone = '" + brandName + "' AND modelNamePhone = '" + modelName + "' AND memoryPhone = " + memory + " AND colorPhone = '" + color + "'";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        double costPrice = 0;
        if (rs.next()) {
            costPrice = rs.getDouble("costPricePhone");
        }

        rs.close();
        stmt.close();
        connect.close();

        return costPrice;
    }

    // Helper method to update the quantity in the phones table
    private void updateQuantity_phones(String brandName, String modelName, int memory, String color, int units) throws SQLException {
        connect = DatabaseConnection.connectDb();
        String query = "UPDATE phones SET quantityPhone = quantityPhone - " + units + " WHERE brandNamePhone = '" + brandName + "' AND modelNamePhone = '" + modelName + "' AND memoryPhone = " + memory + " AND colorPhone = '" + color + "'";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(query);

        stmt.close();
    }





    public void accessoryBillPDF_() {
        if (Objects.equals(accessoryBillCash.getText(), "")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter the Cash !");
            alert.showAndWait();
        } else if (Double.parseDouble(accessoryBillCash.getText()) != Double.parseDouble(accessoryBillTotalAmount.getText()) + Double.parseDouble(accessoryBillBalance.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter the Cash Correctly!");
            alert.showAndWait();
        } else {
            try {
                List<BillingItem_accessories> items_ = fetchBillingItems_accessories();
                String revenueProfit = generateReport_accessories(items_);
                phoneBill_showData_Table();

                // Get the desktop path
                Path desktopPath = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Documents");

                // Create the Bills folder if it does not exist
                Path billsPath = desktopPath.resolve("Accessory Invoices");
                if (!Files.exists(billsPath)) {
                    Files.createDirectories(billsPath); // Changed from createDirectory to createDirectories
                }

                // Get the current date
                LocalDate date = LocalDate.now();
                LocalDateTime time = LocalDateTime.now();

                // Create the PDF file name with the current date and a unique auto-incrementing number
                String fileName = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "_" + time.format(DateTimeFormatter.ofPattern("HH-mm-ss")) + ".pdf";

                // Create the PDF file
                String path = billsPath.resolve(fileName).toString();
                PdfWriter pdfWriter = new PdfWriter(path);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);

                //Database table row count
                connect = DatabaseConnection.connectDb();
                String query = "SELECT COUNT(*) FROM temp_bill_addaccessory" ;
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                int rowCount;
                if (rs.getInt(1) == 0){
                    rowCount = 1;
                }else {
                    rowCount = rs.getInt(1) *9;
                }

                rs.close();

                // Define the page width with the specified width and add margins
                float widthInPoints = 80 * 2.83465f; // 80mm to points
                float marginInPoints = 4 * 2.83465f; // 4mm to points
                PageSize pageSize = new PageSize(widthInPoints, calculatePageHeight_accessories(rowCount));
                pdfDocument.setDefaultPageSize(pageSize);
                Document document = new Document(pdfDocument, pageSize);
                document.setMargins(0, marginInPoints, 0, marginInPoints);

                // Fetch data from the database
                List<BillingItem_accessories> items = fetchBillingItems_accessories();

                //Add logo
                String imagePath = "images\\logo.png";
                ImageData imageData = ImageDataFactory.create(imagePath);
                Image image = new Image(imageData);
                image.setHeight(50);
                image.setWidth(50);
                image.setHorizontalAlignment(HorizontalAlignment.CENTER);
                document.add(image);

                // Add title to the document
                document.add(new Paragraph("J Mobiles\nNO.  ,\nAnuradhapura Rd,\nDambulla.\n074-1558571\n--------------------------------------------").setTextAlignment(TextAlignment.CENTER).setFontSize(8));
                String cashier = "J Mobile";
                if (!Objects.equals(accessoryBillCashier.getText(), "")){
                    cashier = accessoryBillCashier.getText();
                }
                document.add(new Paragraph("Cashier : " + cashier + "             " + LocalDate.now()).setFontSize(8).setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph("-----------------------------------------------------------").setFontSize(10));

                if (!Objects.equals(accessoryBillCustomer.getText(), "") || !Objects.equals(accessoryBillCustomerMobile.getText(),"")){
                    String customer = "-" , customerMobile = "-";
                    if(!Objects.equals(accessoryBillCustomer.getText(), "")) {
                        customer = accessoryBillCustomer.getText();}
                    if(!Objects.equals(accessoryBillCustomerMobile.getText(), "")) {
                        customerMobile = accessoryBillCustomerMobile.getText();}
                    document.add(new Paragraph("Customer : " + customer + "              Mobile : " + customerMobile).setFontSize(8));
                    document.add(new Paragraph("-----------------------------------------------------------").setFontSize(10));
                }

                // Add table rows
                for (BillingItem_accessories item : items) {
                    addHeaderLine_phones(document, "Brand Name", item.getBrandName());
                    addHeaderLine_phones(document, "Model Name",item.getModelName());
                    addHeaderLine_phones(document, "Unit Price", String.valueOf(item.getUnitPrice()));
                    addHeaderLine_phones(document, "Units", String.valueOf(item.getUnits()));
                    addHeaderLine_phones(document, "Discount", String.valueOf(item.getDiscount()));
                    addHeaderLine_phones(document, "Warranty",item.getWarranty());
                    document.add(new Paragraph("-----------------------------------------------------------\n").setFontSize(10));
                }

                // Add total at the bottom
                document.add(new Paragraph("Cash:  Rs. " + accessoryBillCash.getText() + ".00").setFontSize(10));
                document.add(new Paragraph("Balance:  Rs. " + accessoryBillBalance.getText() + "0").setFontSize(10));
                document.add(new Paragraph("-----------------------------------------------------------").setFontSize(10));
                Paragraph totalParagraph = new Paragraph("Total:  Rs. " + accessoryBillTotalAmount.getText() + "0").setFontSize(10);
                document.add(totalParagraph);
                document.add(new Paragraph("-----------------------------------------------------------").setFontSize(10));
                document.add(new Paragraph("*** Thank You, Come Again ! ***").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph("-----------------------------------------------------------").setFontSize(10));
                document.add(new Paragraph("NXTGen Solutions\nshanprabodh@icloud.com\nWhatsapp : 071-2823447").setTextAlignment(TextAlignment.CENTER).setFontSize(8));

                // Close the PDF file
                document.close();

                // Show a success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success Message");
                alert.setHeaderText(null);
                alert.setContentText("The PDF file has been created successfully!\n" + billsPath.toAbsolutePath().toString() + "\n" + revenueProfit);
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();

                // Show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while creating the PDF file!");
                alert.showAndWait();
            }
        }
    }

    // Helper method to fetch billing items from the database
    private List<BillingItem_accessories> fetchBillingItems_accessories() throws SQLException {
        List<BillingItem_accessories> items = new ArrayList<>();
        connect = DatabaseConnection.connectDb();
        String query = "SELECT * FROM temp_bill_addaccessory";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            BillingItem_accessories item = new BillingItem_accessories();
            item.setBrandName(rs.getString("brandName"));
            item.setModelName(rs.getString("modelName"));
            item.setUnitPrice(rs.getDouble("unitPrice"));
            item.setUnits(rs.getInt("units"));
            item.setDiscount(rs.getDouble("discount"));
            item.setWarranty(rs.getString("warranty"));
            item.setTotal(rs.getDouble("total"));

            items.add(item);
        }

        rs.close();
        stmt.close();

        return items;
    }

    // BillingItem class to represent each item in the billing details
    public static class BillingItem_accessories {
        private String brandName;
        private String modelName;
        private double unitPrice;
        private int units;
        private double discount;
        private String warranty;
        private double total;

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getUnits() {
            return units;
        }

        public void setUnits(int units) {
            this.units = units;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public String getWarranty() {
            return warranty;
        }

        public void setWarranty(String warranty) {
            this.warranty = warranty;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

    private float calculatePageHeight_accessories(int rowCount) {
        // Calculate the height of the content
        float contentHeight = 25 * (rowCount + 15) ; // Assuming each line takes up 10 points
        if(!Objects.equals(accessoryBillCustomer.getText(), "") || !Objects.equals(accessoryBillCustomerMobile.getText(),"")){
            contentHeight = 25 * (rowCount + 17) ;
        }
        return contentHeight;
    }

    private String generateReport_accessories(List<BillingItem_accessories> items) throws SQLException {
        connect = DatabaseConnection.connectDb();
        String query = "SELECT * FROM temp_bill_addaccessory";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        double totalRevenue;
        if (!accessoryBillTotalAmount.getText().isEmpty()) {
            totalRevenue = Double.parseDouble(accessoryBillTotalAmount.getText());
        } else {
            totalRevenue = 0;
        }

        int totalQuantity = 0;
        double totalDiscount = 0;

        while (rs.next()) {
            String brandName = rs.getString("brandName");
            String modelName = rs.getString("modelName");
            double unitPrice = rs.getDouble("unitPrice");
            int units = rs.getInt("units");
            double discount = rs.getDouble("discount");

            // Update quantity in accessories table
            updateQuantity_accessories(brandName, modelName, units);

            totalQuantity += units;
            totalDiscount += discount * units;
        }

        rs.close();
        stmt.close();

        double totalProfit = 0;
        for (BillingItem_accessories item : items) {
            String brandName = item.getBrandName();
            String modelName = item.getModelName();
            double unitPrice = item.getUnitPrice();
            int units = item.getUnits();

            // Get the cost price from the accessories table
            double costPrice = getCostPrice_accessories(brandName, modelName);

            // Calculate the profit for this item
            double profit = (unitPrice - costPrice) * units;

            // Add the profit to the total profit
            totalProfit += profit;
        }
        totalProfit -= totalDiscount;

        String sql = "INSERT INTO `profitrevenueaccessory`(`revenue`, `profit`, `quantity`) VALUES (?,?,?)";
        connect = DatabaseConnection.connectDb();
        try {
            prepare = connect.prepareStatement(sql);

            prepare.setString(1, String.valueOf(totalRevenue));
            prepare.setString(2,String.valueOf(totalProfit));
            prepare.setString(3,String.valueOf(totalQuantity));

            prepare.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Revenue : Rs." + totalRevenue + "\nProfit : Rs." + totalProfit + "\nQuantity : "+ totalQuantity;
    }

    private double getCostPrice_accessories(String brandName, String modelName) throws SQLException {
        connect = DatabaseConnection.connectDb();
        String query = "SELECT costPriceAccessory FROM accessories WHERE brandNameAccessory = '" + brandName + "' AND modelNameAccessory = '" + modelName + "'";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        double costPrice = 0;
        if (rs.next()) {
            costPrice = rs.getDouble("costPriceAccessory");
        }

        rs.close();
        stmt.close();
        connect.close();

        return costPrice;
    }

    // Helper method to update the quantity in the accessories table
    private void updateQuantity_accessories(String brandName, String modelName, int units) throws SQLException {
        connect = DatabaseConnection.connectDb();
        String query = "UPDATE accessories SET quantityAccessory = quantityAccessory - " + units + " WHERE brandNameAccessory = '" + brandName + "' AND modelNameAccessory = '" + modelName + "'";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(query);

        stmt.close();
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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

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
            accessoryBillShowData();
            phoneBillShowData();

        }
    }

}
