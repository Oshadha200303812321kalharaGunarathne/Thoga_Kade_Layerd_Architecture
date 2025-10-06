package Service.Impl;

import Repository.Impl.ItemRepositoryImpl;
import Service.ItemManagementService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemManagementService {
    ItemRepositoryImpl itemRepository=new ItemRepositoryImpl();

    @Override
    public ObservableList<ItemDetails> viewItemDetails() {
        ObservableList<ItemDetails>itemDetails= FXCollections.observableArrayList();
        try {
            ResultSet resultSet = itemRepository.viewItemDetails();

            while (resultSet.next()){
                itemDetails.add(new ItemDetails(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }

    @Override
    public void addItemDetails(ItemDetails itemDetails){
        itemRepository.addItemDetails(itemDetails);
    }

    @Override
    public void updateItemDetails(ItemDetails itemDetails) {
        itemRepository.updateItemDetails(itemDetails);
    }

    @Override
    public void deleteItemDetails(String ID) {
        itemRepository.deleteItemDetails(ID);
    }
}
