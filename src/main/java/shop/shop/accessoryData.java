package shop.shop;

import javafx.beans.property.*;

public class accessoryData {
    private final IntegerProperty ID;
    private final StringProperty brandName;
    private final StringProperty modelName;
    private final DoubleProperty costPrice;
    private final DoubleProperty sellingPrice;
    private final IntegerProperty quantity;

    public accessoryData(Integer ID, String brandName, String modelName,  Double costPrice, Double sellingPrice, Integer quantity) {
        this.ID = new SimpleIntegerProperty(ID);
        this.brandName = new SimpleStringProperty(brandName);
        this.modelName = new SimpleStringProperty(modelName);
        this.costPrice = new SimpleDoubleProperty(costPrice);
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
        this.quantity = new SimpleIntegerProperty(quantity);
    }
    public IntegerProperty IDProperty() {
        return ID;
    }

    public Integer getID() {
        return ID.get();
    }

    public void setID(Integer ID) {
        this.ID.set(ID);
    }

    public StringProperty brandNameProperty() {
        return brandName;
    }

    public String getBrandName() {
        return brandName.get();
    }

    public void setBrandName(String brandName) {
        this.brandName.set(brandName);
    }

    public StringProperty modelNameProperty() {
        return modelName;
    }

    public String getModelName() {
        return modelName.get();
    }

    public void setModelName(String modelName) {
        this.modelName.set(modelName);
    }
    public DoubleProperty costPriceProperty() {
        return costPrice;
    }

    public Double getCostPrice() {
        return costPrice.get();
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice.set(costPrice);
    }

    public DoubleProperty sellingPriceProperty() {
        return sellingPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice.get();
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice.set(sellingPrice);
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public void setQuantity(Integer quantity) {
        this.quantity.set(quantity);
    }
}
