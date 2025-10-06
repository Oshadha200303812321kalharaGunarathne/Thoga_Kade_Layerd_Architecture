package Repository;

import model.Orders;

import java.sql.ResultSet;

public interface OrderRepository {
    ResultSet viewOrders();
    void addOrders(Orders orders);
    void updateOrders(Orders orders);
    void deleteOrders(String ID);
}
