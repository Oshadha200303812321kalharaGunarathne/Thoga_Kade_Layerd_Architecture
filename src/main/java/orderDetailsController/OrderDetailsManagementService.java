package orderDetailsController;

import javafx.collections.ObservableList;
import model.OrderDetails;

public interface OrderDetailsManagementService {
    ObservableList<OrderDetails>viewOrderDetails();
    void addOrderDetails(OrderDetails orderDetails);
    void updateOrderDetails(OrderDetails orderDetails);
    void deleteOrderDetails(String ID1,String ID2);
}
