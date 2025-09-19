package itemController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManagementController implements ItemManagementService {

    Connection connection;

    {
        try {
            connection = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<ItemDetails> viewItemDetails() {
        ObservableList<ItemDetails>itemDetails= FXCollections.observableArrayList();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT*FROM Item");
            ResultSet resultSet= preparedStatement.executeQuery();
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
    public void addItemDetails(ItemDetails itemDetails) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO Item(ItemCode,Description,PackSize,UnitPrice,QtyOnHand)VALUES(?,?,?,?,?);");
            preparedStatement.setObject(1,itemDetails.getItemCode());
            preparedStatement.setObject(2,itemDetails.getDescription());
            preparedStatement.setObject(3,itemDetails.getPackSize());
            preparedStatement.setObject(4,itemDetails.getUnitPrice());
            preparedStatement.setObject(5,itemDetails.getQtyOnHand());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItemDetails(ItemDetails itemDetails) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE Item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?;");
            preparedStatement.setObject(1,itemDetails.getDescription());
            preparedStatement.setObject(2,itemDetails.getPackSize());
            preparedStatement.setObject(3,itemDetails.getUnitPrice());
            preparedStatement.setObject(4,itemDetails.getQtyOnHand());
            preparedStatement.setObject(5,itemDetails.getItemCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItemDetails(String ID) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM Item WHERE ItemCode=?;");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
