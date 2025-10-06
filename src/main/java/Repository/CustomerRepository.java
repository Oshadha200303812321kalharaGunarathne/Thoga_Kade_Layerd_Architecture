package Repository;

import model.CustomerDetails;

import java.sql.ResultSet;

public interface CustomerRepository {
    ResultSet viewCustomerDetails();
    void addCustomerDetails(CustomerDetails customerDetails);
    void UpdateCustomerDetails(CustomerDetails customerDetails);
    void DeleteCustomerDetails(String CustID);
}
