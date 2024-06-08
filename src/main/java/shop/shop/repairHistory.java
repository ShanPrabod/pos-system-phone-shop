package shop.shop;

import javafx.beans.property.*;

public class repairHistory {
    private final StringProperty date;
    private final DoubleProperty revenue;
    private final DoubleProperty profit;

    public repairHistory(String date, Double revenue, Double profit) {
        this.date = new SimpleStringProperty(date);
        this.revenue = new SimpleDoubleProperty(revenue);
        this.profit = new SimpleDoubleProperty(profit);
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
}
