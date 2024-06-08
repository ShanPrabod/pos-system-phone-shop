package shop.shop;

import javafx.beans.property.*;

public class contactsData {
    private final IntegerProperty ID;
    private final StringProperty name;
    private final StringProperty item;
    private final StringProperty mobile;

    public contactsData(Integer ID, String name, String item, String mobile) {
        this.ID = new SimpleIntegerProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.item = new SimpleStringProperty(item);
        this.mobile = new SimpleStringProperty(mobile);
    }
    //get methods
    public Integer getID() {
        return ID.get();
    }
    public String getName() {
        return name.get();
    }
    public String getItem() {
        return item.get();
    }
    public String getMobile() {
        return mobile.get();
    }
}
