package orderDetailsController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsManagementController implements OrderDetailsManagementService {
    Connection connection;

    {
        try {
            connection = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<OrderDetails> viewOrderDetails() {
        ObservableList<OrderDetails> orderDetails= FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT*FROM OrderDetail;");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                orderDetails.add(new OrderDetails(
                        resultSet.getString("OrderID"),
                        resultSet.getString("ItemCode"),
                        resultSet.getInt("OrderQty"),
                        resultSet.getInt("Discount")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetails;
    }

    @Override
    public void addOrderDetails(OrderDetails orderDetails) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO OrderDetail(OrderID,ItemCode,OrderQty,Discount)VALUES(?,?,?,?);");
            preparedStatement.setObject(1,orderDetails.getOrderID());
            preparedStatement.setObject(2,orderDetails.getItemCode());
            preparedStatement.setObject(3,orderDetails.getOrderQty());
            preparedStatement.setObject(4,orderDetails.getDiscount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateOrderDetails(OrderDetails orderDetails) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE OrderDetail set OrderQty=?,Discount=? WHERE OrderID=? AND ItemCode=?");
            preparedStatement.setObject(1,orderDetails.getOrderQty());
            preparedStatement.setObject(2,orderDetails.getDiscount());
            preparedStatement.setObject(3,orderDetails.getOrderID());
            preparedStatement.setObject(4,orderDetails.getItemCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetails(String ID1, String ID2) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM OrderDetail WHERE OrderID=? AND ItemCode=?;");
            preparedStatement.setObject(1,ID1);
            preparedStatement.setObject(2,ID2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
