package Repository;

import model.OrderDetails;

import java.sql.ResultSet;

public interface OrderDetailsRepository {
    ResultSet viewOrderDetails();
    void addOrderDetails(OrderDetails orderDetails);
    void updateOrderDetails(OrderDetails orderDetails);
    void deleteOrderDetails(String ID1,String ID2);
}
