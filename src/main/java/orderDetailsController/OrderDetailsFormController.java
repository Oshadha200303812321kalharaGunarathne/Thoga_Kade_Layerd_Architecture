package orderDetailsController;

import Service.Impl.OrderDetailsServiceImpl;
import Service.OrderDetailsManagementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OrderDetails;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailsFormController implements Initializable {
    OrderDetailsManagementService orderDetailsManagementService=new OrderDetailsServiceImpl();

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnView;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderDiscount;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colOrderQty;

    @FXML
    private TableView<OrderDetails> tblOrderDetails;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtOrderQty;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        OrderDetails orderDetails=new OrderDetails(
                txtOrderID.getText(),
                txtItemCode.getText(),
                Integer.parseInt(txtOrderQty.getText()),
                Integer.parseInt(txtDiscount.getText())
        );
        orderDetailsManagementService.addOrderDetails(orderDetails);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtOrderID.setText(null);
        txtItemCode.setText(null);
        txtOrderQty.setText(null);
        txtDiscount.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String ID1=txtOrderID.getText();
        String ID2=txtItemCode.getText();
        orderDetailsManagementService.deleteOrderDetails(ID1,ID2);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        OrderDetails orderDetails=new OrderDetails(
                txtOrderID.getText(),
                txtItemCode.getText(),
                Integer.parseInt(txtOrderQty.getText()),
                Integer.parseInt(txtDiscount.getText())
        );
        orderDetailsManagementService.updateOrderDetails(orderDetails);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        tblOrderDetails.setItems(orderDetailsManagementService.viewOrderDetails());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colOrderDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("OrderQty"));
    }
}
