package Service.Impl;

import Repository.Impl.CustomerRepositoryImpl;
import Service.CustomerManagementService;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerManagementService {
    CustomerRepositoryImpl customerRepository=new CustomerRepositoryImpl();

    ObservableList<CustomerDetails> customerDetails = FXCollections.observableArrayList();

    @Override
    public void addCustomerDetails(CustomerDetails customerDetails){
        customerRepository.addCustomerDetails(customerDetails);
    }

    @Override
    public void UpdateCustomerDetails(CustomerDetails customerDetails){
        customerRepository.UpdateCustomerDetails(customerDetails);
    }

    @Override
    public void DeleteCustomerDetails(String CustID){
        customerRepository.DeleteCustomerDetails(CustID);
    }

    @Override
    public ObservableList<CustomerDetails>viewCustomerDetails(){
        ObservableList<CustomerDetails>customerDetails1=FXCollections.observableArrayList();
        try {

            ResultSet resultSet= customerRepository.viewCustomerDetails();
            while (resultSet.next()){
                customerDetails1.add(new CustomerDetails(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getString("DOB"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDetails1;
    }
}


