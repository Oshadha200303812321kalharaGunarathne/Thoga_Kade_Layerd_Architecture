package Service;

import javafx.collections.ObservableList;
import model.ItemDetails;

public interface ItemManagementService {

    public ObservableList<ItemDetails>viewItemDetails();

    void addItemDetails(ItemDetails itemDetails);
    void updateItemDetails(ItemDetails itemDetails);
    void deleteItemDetails(String ID);
}
