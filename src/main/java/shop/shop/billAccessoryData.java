package shop.shop;

import javafx.beans.property.*;

public class billAccessoryData {
    private final StringProperty brandName;
    private final StringProperty modelName;
    private final DoubleProperty price;
    private final IntegerProperty quantity;
    private final DoubleProperty discount;
    private  final StringProperty warranty;
    private  final DoubleProperty total;

    public billAccessoryData(String brandName, String modelName, Double price, Integer quantity, Double discount, String warranty, Double total) {
        this.brandName = new SimpleStringProperty(brandName);
        this.modelName = new SimpleStringProperty(modelName);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.discount = new SimpleDoubleProperty(discount);
        this.warranty = new SimpleStringProperty(warranty);
        this.total = new SimpleDoubleProperty(total);
    }



    public String getBrandName() {
        return brandName.get();
    }

    public String getModelName() {
        return modelName.get();
    }

    public double getPrice() {
        return price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public double getDiscount() {
        return discount.get();
    }

    public String getWarranty() {
        return warranty.get();
    }

    public double getTotal() {
        return total.get();
    }
}
