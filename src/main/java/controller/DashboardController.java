package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private JFXButton btnCustomerDetails;

    @FXML
    private JFXButton btnItemDetails;

    @FXML
    private JFXButton btnOrderDetails;

    @FXML
    private JFXButton btnOrders;


    @FXML
    void btnCustomerDetailsOnAction(ActionEvent event) {
        Stage customerManagement=new Stage();

        try {
            customerManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        customerManagement.setResizable(false);
        customerManagement.show();
    }

    @FXML
    void btnItemDetailsOnAction(ActionEvent event) {
        Stage itemManagement=new Stage();

        try {
            itemManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemManagement.setResizable(false);
        itemManagement.show();
    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) {
        Stage orderManagement=new Stage();

        try {
            orderManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/order_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        orderManagement.setResizable(false);
        orderManagement.show();
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {
        Stage orderDetailsManagement=new Stage();
        try {
            orderDetailsManagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/orderdetails_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        orderDetailsManagement.setResizable(false);
        orderDetailsManagement.show();
    }

}


