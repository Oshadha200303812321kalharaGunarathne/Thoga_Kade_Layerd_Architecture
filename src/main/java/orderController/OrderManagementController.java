package orderController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderManagementController implements OrderManagementService {
    Connection connection;

    {
        try {
            connection = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Orders> viewOrders() {
        ObservableList<Orders>orders= FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT*FROM Orders");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                orders.add(new Orders(
                        resultSet.getString("OrderID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getString("CustID")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    @Override
    public void addOrders(Orders orders) {
        try {
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
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM Orders WHERE OrderID=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
