package orderController;


import javafx.collections.ObservableList;
import model.Orders;

public interface OrderManagementService {
    ObservableList<Orders>viewOrders();

    void addOrders(Orders orders);
    void updateOrders(Orders orders);
    void deleteOrders(String ID);
}
