package Repository.Impl;

import Repository.CustomerRepository;
import db.DBConnection;
import model.CustomerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public ResultSet viewCustomerDetails() {
        try {
           Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT*FROM Customer;");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


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
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SQL);

            preparedStatement.setObject(1,CustID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
