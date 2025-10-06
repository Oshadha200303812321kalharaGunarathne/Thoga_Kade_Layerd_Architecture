package Service;

import javafx.collections.ObservableList;
import model.CustomerDetails;

public interface CustomerManagementService {
    ObservableList<CustomerDetails>viewCustomerDetails();

    void addCustomerDetails(CustomerDetails customerDetails);
    void UpdateCustomerDetails(CustomerDetails customerDetails);
    void DeleteCustomerDetails(String CustID);
}
