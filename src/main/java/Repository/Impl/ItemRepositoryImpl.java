package Repository.Impl;

import Repository.ItemRepository;
import db.DBConnection;
import model.ItemDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public ResultSet viewItemDetails() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM Item");

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void addItemDetails(ItemDetails itemDetails) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Item(ItemCode,Description,PackSize,UnitPrice,QtyOnHand)VALUES(?,?,?,?,?);");
            preparedStatement.setObject(1, itemDetails.getItemCode());
            preparedStatement.setObject(2, itemDetails.getDescription());
            preparedStatement.setObject(3, itemDetails.getPackSize());
            preparedStatement.setObject(4, itemDetails.getUnitPrice());
            preparedStatement.setObject(5, itemDetails.getQtyOnHand());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateItemDetails(ItemDetails itemDetails) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?;");
            preparedStatement.setObject(1, itemDetails.getDescription());
            preparedStatement.setObject(2, itemDetails.getPackSize());
            preparedStatement.setObject(3, itemDetails.getUnitPrice());
            preparedStatement.setObject(4, itemDetails.getQtyOnHand());
            preparedStatement.setObject(5, itemDetails.getItemCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteItemDetails(String ID){
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM Item WHERE ItemCode=?;");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
