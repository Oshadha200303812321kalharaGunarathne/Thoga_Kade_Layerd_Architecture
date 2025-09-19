package customerController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManagementController implements CustomerManagementService{
    ObservableList<CustomerDetails> customerDetails = FXCollections.observableArrayList();

    @Override
    public void addCustomerDetails(CustomerDetails customerDetails){
        String SQL ="INSERT INTO Customer(CustID,CustTitle,CustName,DOB,salary,CustAddress,City,Province,PostalCode) VALUES(?,?,?,?,?,?,?,?,?);";

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);

            preparedStatement.setObject(1,customerDetails.getCustID());
            preparedStatement.setObject(2,customerDetails.getCustTitle());
            preparedStatement.setObject(3,customerDetails.getCustName());
            preparedStatement.setObject(4,customerDetails.getDOB());
            preparedStatement.setObject(5,customerDetails.getSalary());
            preparedStatement.setObject(6,customerDetails.getCustAddress());
            preparedStatement.setObject(7,customerDetails.getCity());
            preparedStatement.setObject(8,customerDetails.getProvince());
            preparedStatement.setObject(9,customerDetails.getPostalCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void UpdateCustomerDetails(CustomerDetails customerDetails){

        String SQL ="UPDATE Customer SET CustTitle=?,CustName=?,DOB=?,Salary=?,CustAddress=?,City=?,Province=?,PostalCode=? WHERE CustID=?;";

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SQL);

            preparedStatement.setObject(2,customerDetails.getCustTitle());
            preparedStatement.setObject(3,customerDetails.getCustName());
            preparedStatement.setObject(4,customerDetails.getDOB());
            preparedStatement.setObject(5,customerDetails.getSalary());
            preparedStatement.setObject(6,customerDetails.getCustAddress());
            preparedStatement.setObject(7,customerDetails.getCity());
            preparedStatement.setObject(8,customerDetails.getProvince());
            preparedStatement.setObject(9,customerDetails.getPostalCode());
            preparedStatement.setObject(1,customerDetails.getCustID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DeleteCustomerDetails(String CustID){
        String SQL ="DELETE FROM Customer WHERE CustID=?;";

        Connection connection=null;

        try {
            connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SQL);

            preparedStatement.setObject(1,CustID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<CustomerDetails>viewCustomerDetails(){
        ObservableList<CustomerDetails>customerDetails1=FXCollections.observableArrayList();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT*FROM Customer;");
            ResultSet resultSet= preparedStatement.executeQuery();

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


