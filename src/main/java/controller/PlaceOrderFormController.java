package controller;

import Service.CustomerManagementService;
import Service.Impl.CustomerServiceImpl;
import Service.Impl.ItemServiceImpl;
import Service.ItemManagementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.dto.CustomerDetails;
import model.dto.ItemDetails;

public class PlaceOrderFormController {

    @FXML
    private JFXButton btnAddtoCart;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblPrice;

    @FXML
    private TableView<?> tblAddCart;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtQuantity;

    ItemManagementService itemManagementService=new ItemServiceImpl();
    CustomerManagementService customerManagementService=new CustomerServiceImpl();


    @FXML
    void btnAddtoCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerIDOnAction(ActionEvent event) {
        CustomerDetails customerDetails = customerManagementService.getCustomer(txtCustomerID.getText());
        lblCustomerName.setText(customerDetails.getCustName());
    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {
        ItemDetails itemDetails = itemManagementService.searchItem(txtItemCode.getText(), null);
        System.out.println(itemDetails);
        lblDescription.setText(itemDetails.getDescription());
        lblPrice.setText(String.valueOf(itemDetails.getUnitPrice()));
    }

}
