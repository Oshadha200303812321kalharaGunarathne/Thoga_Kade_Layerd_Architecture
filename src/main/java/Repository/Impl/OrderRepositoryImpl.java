package Repository.Impl;

import Repository.OrderRepository;
import db.DBConnection;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public ResultSet viewOrders(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT*FROM Orders");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrders(Orders orders) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO Orders(OrderID,OrderDate,CustID)VALUES(?,?,?);");
            preparedStatement.setObject(1,orders.getOrderID());
            preparedStatement.setObject(2,orders.getOrderDate());
            preparedStatement.setObject(3,orders.getCustID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrders(Orders orders) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE Orders SET OrderDate=?,CustID=? WHERE OrderID=?;");
            preparedStatement.setObject(1,orders.getOrderDate());
            preparedStatement.setObject(2,orders.getCustID());
            preparedStatement.setObject(3,orders.getOrderID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrders(String ID) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM Orders WHERE OrderID=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
