package shop.shop;

import javafx.beans.property.*;

public class repairData {
    private  final StringProperty partName;
    private final IntegerProperty NoOfParts;
    private final DoubleProperty unitPrice;
    private final DoubleProperty total;

    public repairData(String partName, Integer NoOfParts, Double unitPrice, Double total) {
        this.partName = new SimpleStringProperty(partName);
        this.NoOfParts = new SimpleIntegerProperty(NoOfParts);
        this.unitPrice = new SimpleDoubleProperty(unitPrice);
        this.total = new SimpleDoubleProperty(total);
    }

    public String getPartName() {
        return partName.get();
    }
    public Integer getNoOfParts() {
        return NoOfParts.get();
    }
    public Double getUnitPrice() {
        return unitPrice.get();
    }
    public Double getTotal() {
        return total.get();
    }
}
