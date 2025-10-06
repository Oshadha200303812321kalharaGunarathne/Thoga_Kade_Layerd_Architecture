package Service.Impl;

import Repository.Impl.OrderRepositoryImpl;
import Repository.OrderRepository;
import Service.OrderManagementService;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderManagementService {
   OrderRepositoryImpl orderRepository=new OrderRepositoryImpl();

    @Override
    public ObservableList<Orders> viewOrders() {
        ObservableList<Orders>orders= FXCollections.observableArrayList();
        try {
            ResultSet resultSet= orderRepository.viewOrders();
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
       orderRepository.addOrders(orders);
    }

    @Override
    public void updateOrders(Orders orders) {
       orderRepository.updateOrders(orders);
    }

    @Override
    public void deleteOrders(String ID) {
        orderRepository.deleteOrders(ID);
    }
}
