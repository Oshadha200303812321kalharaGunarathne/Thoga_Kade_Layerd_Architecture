package Repository;

import model.ItemDetails;

import java.sql.ResultSet;

public interface ItemRepository {
    ResultSet viewItemDetails();
    void addItemDetails(ItemDetails itemDetails);
    void updateItemDetails(ItemDetails itemDetails);
    void deleteItemDetails(String ID);
}

