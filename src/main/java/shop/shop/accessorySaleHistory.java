package shop.shop;

import javafx.beans.property.*;

public class accessorySaleHistory {
    private final StringProperty date;
    private final DoubleProperty revenue;
    private final DoubleProperty profit;
    private final IntegerProperty quantity;

    public accessorySaleHistory(String date, Double revenue, Double profit, Integer quantity) {
        this.date = new SimpleStringProperty(date);
        this.revenue = new SimpleDoubleProperty(revenue);
        this.profit = new SimpleDoubleProperty(profit);
        this.quantity = new SimpleIntegerProperty(quantity);
    }
    //get methods
    public String getDate() {
        return date.get();
    }
    public Double getRevenue() {
        return revenue.get();
    }
    public Double getProfit() {
        return profit.get();
    }
    public Integer getQuantity() {
        return quantity.get();
    }
}
