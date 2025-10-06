package Service.Impl;

import Repository.Impl.OrderDetailsRepositoryImpl;
import Service.OrderDetailsManagementService;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsServiceImpl implements OrderDetailsManagementService {
   OrderDetailsRepositoryImpl orderDetailsRepository=new OrderDetailsRepositoryImpl();

    @Override
    public ObservableList<OrderDetails> viewOrderDetails() {
        ObservableList<OrderDetails> orderDetails= FXCollections.observableArrayList();
        try {
            ResultSet resultSet=orderDetailsRepository.viewOrderDetails();
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
        orderDetailsRepository.addOrderDetails(orderDetails);
    }

    @Override
    public void updateOrderDetails(OrderDetails orderDetails) {
        orderDetailsRepository.updateOrderDetails(orderDetails);
    }

    @Override
    public void deleteOrderDetails(String ID1, String ID2) {
       orderDetailsRepository.deleteOrderDetails(ID1,ID2);
    }
}
